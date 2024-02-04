package com.dmlo.freemarket.ui.screen.description

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dmlo.freemarket.repository.model.ProductDescription
import com.dmlo.freemarket.repository.model.Snapshot
import com.dmlo.freemarket.ui.theme.FreeMarketTheme
import com.dmlo.freemarket.ui.theme.installmentTypo

@Composable
fun DescriptionContent(
    data: ProductDescription,
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        AsyncImage(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth(),
            model = data.snapshot.url,
            contentDescription = "Imagem do produto"
        )

        Text(
            text = data.plainText,
            style = installmentTypo
        )
    }
}

@Preview
@Composable
fun DescriptionContentPreview() {
    FreeMarketTheme {
        DescriptionContent(
            data = ProductDescription(
                plainText = "O Nintendo Switch está mais bonito do que nunca nesta edição especial Super Smash Bros. A edição acompanha o jogo Super Smash Bros e mais 3 meses de assinatura Nintendo Switch Online. Modelo Nacional, apresenta 3 modos em 1 - Modo TV, Modo de mesa e Modo portátil. Os sistemas OLED Model foram desenvolvidos para se adequar à sua vida, transformando-se de console doméstico em sistema portátil em um piscar de olhos! Além disso, o novo sistema traz uma tela OLED vibrante de 7 polegadas, um amplo suporte ajustável, um dock com uma porta LAN com fio, 64 GB de armazenamento interno e áudio aprimorado. Ideal para quem busca um vídeo game completo.\n\nESPECIFICAÇÕES\nResolução Máxima: 1080p@60fps (TV)\nCapacidade: 64 GB\nDrive: Cartucho\nDimensão: 10 cm (altura) x 24 cm (largura) x 13,9 mm (espessura)\n\nCONTEÚDO DA EMBALAGEM\n1 Console Nintendo Switch OLED 64gb Edição Super Smash Bros\n2 Joy-Con\n1 Jogo Super Smash Bros (Código para Resgate)\n3 Meses de assinatura Nintendo Switch Online (Código para Resgate)\n1 Base para TV\n1 Suporte para o Joy-Con\n2 Straps para o Joy-Con\n1 Cabo de Energia\n1 Cabo HDMI\nManuais",
                snapshot = Snapshot(
                    url = "http://descriptions.mlstatic.com/D-MLB3585944147.jpg?hash=8520c3b8559cb08aa7e782b8f5334ffe_0x0"
                )
            ),
            innerPadding = PaddingValues(16.dp)
        )
    }
}