package br.senai.sp.jandira.kalos_app.screens.telaDetalhesProduto.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos

@Composable
fun PrecoReserva(corAcademia: String, preco: String, onClick: () -> Unit) {
    val color = android.graphics.Color.parseColor(corAcademia)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(GrayKalos)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "R$ ${preco}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            Button(
                onClick = {
                    onClick()
                },
                colors = ButtonDefaults.buttonColors(Color(color))
            ) {
                Text(
                    text = "Reservar produto",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }


    }
}

@Preview
@Composable
fun PrecoReservaPreview() {
    PrecoReserva("#34439E", "39,90"){

    }
}