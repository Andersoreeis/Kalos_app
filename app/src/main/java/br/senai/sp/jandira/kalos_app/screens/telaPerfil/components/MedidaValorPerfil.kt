package br.senai.sp.jandira.kalos_app.screens.telaPerfil.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos

@Composable
fun MedidaValorPerfil(titulo: String, valor: String, desc: String) {
    Column {
        Text(
            text = titulo,
            color = GreenKalos,
            fontSize = 15.sp
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = valor,
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = desc,
                color = Color.White,
                fontSize = 20.sp
            )
        }

    }
}