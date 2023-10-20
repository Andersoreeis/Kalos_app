package br.senai.sp.jandira.kalos_app.screens.telaProdutos.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BotaoReservas(corPrimariaAcademia: String) {
    val corPrimaria = Color(android.graphics.Color.parseColor(corPrimariaAcademia ?: "#353535"))

    Surface(
        shape = RoundedCornerShape(10.dp),
        color = Color.Black,
        border = BorderStroke(1.dp, corPrimaria)

    ) {
        Text(
            text = "Reservas",
            color = corPrimaria,
            modifier = Modifier.padding(10.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }

}