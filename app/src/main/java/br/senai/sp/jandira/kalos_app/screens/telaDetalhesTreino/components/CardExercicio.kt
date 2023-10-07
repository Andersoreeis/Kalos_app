package br.senai.sp.jandira.kalos_app.screens.telaDetalhesTreino.components

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.longrunning.Operation.ResultCase

@Composable
fun CardExercicio(numero: String) {

    Row(
        modifier = Modifier
            .height(75.dp)
            .width(350.dp)
            .background(Color.Black),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .width(120.dp)
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = numero,
                color = Color(0, 254, 144)
            )

           // androidx.compose.foundation.Image(painter = , contentDescription = )
        }

        Column {

        }

    }

}

@Preview()
@Composable
fun CardExercicioPreview() {
    CardExercicio("2")
}