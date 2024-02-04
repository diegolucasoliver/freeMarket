package com.dmlo.freemarket.ui.screen.results

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmlo.freemarket.ui.theme.cardTitleTypo

@Composable
fun ResultsError(
    innerPadding: PaddingValues,
    action: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .align(Alignment.CenterHorizontally),
            imageVector = Icons.Default.Warning,
            tint = Color.Yellow,
            contentDescription = "Ícone de alerta"
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = "Algo deu errado",
            style = cardTitleTypo
        )

        Button(
            onClick = action,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            colors = ButtonDefaults.buttonColors(Color.Yellow)
        ) {
            Text(
                text = "Tentar novamente",
                color = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun ResultsErrorPreview() {
    ResultsError(innerPadding = PaddingValues(16.dp)) {}
}