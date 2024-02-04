package com.dmlo.freemarket.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dmlo.freemarket.R
import com.dmlo.freemarket.utils.formatToMoney
import com.dmlo.freemarket.ui.model.Installment
import com.dmlo.freemarket.ui.model.Product
import com.dmlo.freemarket.ui.theme.FreeMarketTheme
import com.dmlo.freemarket.ui.theme.Shapes
import com.dmlo.freemarket.ui.theme.cardTitleTypo
import com.dmlo.freemarket.ui.theme.installmentTypo
import com.dmlo.freemarket.ui.theme.originalPriceTypo
import com.dmlo.freemarket.ui.theme.priceTypo
import com.dmlo.freemarket.ui.theme.tagTypo
import java.math.BigDecimal

private const val NEW = "new"
private const val ALERT_QUANTITY = 5

@Composable
fun ProductCard(
    product: Product,
    action: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(Shapes.medium)
            .background(Color.LightGray)
            .clickable { action() }
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                model = product.thumbnail,
                contentDescription = "Imagem do ${product.title}"
            )

            Text(
                modifier = Modifier.padding(bottom = 12.dp, start = 16.dp, end = 16.dp),
                text = product.title,
                style = cardTitleTypo
            )

            product.originalPrice?.let {
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = it.formatToMoney(),
                    style = originalPriceTypo
                )
            }

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = product.price.formatToMoney(),
                style = priceTypo
            )

            product.installments?.let { installment ->
                Text(
                    modifier = Modifier.padding(bottom = 12.dp, start = 16.dp, end = 16.dp),
                    text = stringResource(
                        id = R.string.installment_condition,
                        installment.quantity,
                        installment.amount.formatToMoney()
                    ),
                    style = installmentTypo
                )
            }

            if (
                product.freeShipping ||
                product.condition == NEW ||
                product.availableQuantity <= ALERT_QUANTITY
            ) {
                Tags(product.freeShipping, product.condition, product.availableQuantity)
            }
        }
    }
}

@Composable
fun Tags(freeShipping: Boolean, condition: String, quantity: Int) {
    Row(
        modifier = Modifier.padding(bottom = 12.dp, start = 16.dp, end = 16.dp)
    ) {
        if (freeShipping) {
            Tag(
                modifier = Modifier
                    .padding(end = 12.dp),
                text = stringResource(id = R.string.free_shipping),
                backgroundColor = Color.Black
            )
        }

        if (condition == NEW) {
            Tag(
                modifier = Modifier.padding(end = 12.dp),
                text = stringResource(id = R.string.new_item),
                backgroundColor = Color.Black
            )
        }

        if (quantity <= ALERT_QUANTITY) {
            Tag(
                text = pluralStringResource(id = R.plurals.quantity_alert, count = quantity),
                backgroundColor = Color.Red
            )
        }
    }
}

@Composable
fun Tag(modifier: Modifier = Modifier, text: String, backgroundColor: Color) {
    Box(
        modifier = modifier
            .clip(Shapes.small)
            .background(backgroundColor)
            .padding(8.dp)
    ) {
        Text(
            text = text,
            style = tagTypo
        )
    }

}

@Preview
@Composable
fun ProductCardPreview() {
    FreeMarketTheme {
        ProductCard(
            Product(
                id = "MLB4370015658",
                title = "Console Nintendo Switch Lite 32gb Turquesa",
                price = BigDecimal("1199.0"),
                originalPrice = BigDecimal("1362.5"),
                salePrice = null,
                availableQuantity = 5,
                condition = "new",
                thumbnail = "http://http2.mlstatic.com/D_719738-MLU72566278420_112023-I.jpg",
                installments = Installment(
                    quantity = 10,
                    amount = BigDecimal("119.9"),
                    rate = 0,
                    currencyId = "BRL"
                ),
                freeShipping = true
            )
        ) {}
    }
}