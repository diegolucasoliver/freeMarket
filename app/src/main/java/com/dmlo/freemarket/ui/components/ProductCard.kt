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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dmlo.freemarket.ui.model.Installment
import com.dmlo.freemarket.ui.model.Product
import com.dmlo.freemarket.ui.theme.FreeMarketTheme
import com.dmlo.freemarket.ui.theme.Shapes
import com.dmlo.freemarket.ui.theme.cardTitle
import com.dmlo.freemarket.ui.theme.installment
import com.dmlo.freemarket.ui.theme.originalPrice
import com.dmlo.freemarket.ui.theme.price
import com.dmlo.freemarket.ui.theme.tag

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
                style = cardTitle
            )

            product.originalPrice?.let {
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = it.toString(),
                    style = originalPrice
                )
            }

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = product.price.toString(),
                style = price
            )

            product.installments?.let {
                Text(
                    modifier = Modifier.padding(bottom = 12.dp, start = 16.dp, end = 16.dp),
                    text = "ou em ${product.installments.quantity}x de ${product.installments.amount}",
                    style = installment
                )
            }

            if (product.freeShipping || product.condition == "new") {
                Tags(product.freeShipping, product.condition)
            }
        }
    }
}

@Composable
fun Tags(freeShipping: Boolean, condition: String) {
    Row(
        modifier = Modifier.padding(bottom = 12.dp, start = 16.dp, end = 16.dp)
    ) {
        if (freeShipping) {
            Tag(modifier = Modifier.padding(end = 12.dp), text = "Frete grátis")
        }

        if (condition == "new") {
            Tag(text = "Novo")
        }
    }
}

@Composable
fun Tag(modifier: Modifier = Modifier, text: String) {
    Box(
        modifier = modifier
            .clip(Shapes.small)
            .background(Color.Black)
            .padding(8.dp)
    ) {
        Text(
            text = text,
            style = tag
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
                price = 1199.0,
                originalPrice = 1362.5,
                salePrice = null,
                availableQuantity = 5,
                condition = "new",
                thumbnail = "http://http2.mlstatic.com/D_719738-MLU72566278420_112023-I.jpg",
                installments = Installment(
                    quantity = 10,
                    amount = 119.9,
                    rate = 0,
                    currencyId = "BRL"
                ),
                freeShipping = true
            )
        ) {}
    }
}