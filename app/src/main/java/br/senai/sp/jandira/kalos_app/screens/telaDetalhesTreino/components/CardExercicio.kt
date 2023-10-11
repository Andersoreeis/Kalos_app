package br.senai.sp.jandira.kalos_app.screens.telaDetalhesTreino.components

import android.media.Image
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.R
import coil.compose.AsyncImage

@Composable
fun CardExercicio(numero: String, imagem: String, nome: String, series: String, repeticoes: String?, duracao: String?) {

    Row(
        modifier = Modifier
            .height(75.dp)
            .width(350.dp)
            .background(Color.Black)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .width(80.dp)
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = numero,
                color = Color(0, 254, 144)
            )



            AsyncImage(
                model = imagem,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .shadow(2.dp, RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop,
                error = painterResource(id = R.drawable.treinoerro)
            )

        }

        Spacer(modifier = Modifier.width(15.dp))

        Column (
            modifier = Modifier
                .height(50.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = nome,
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )

            Text(
                text = if (repeticoes != null) "SERIES: ${series} - REPETIÇÕES: ${repeticoes}" else "SERIES: ${series} - DURAÇÃO: ${duracao}",
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Light
            )
        }

    }

}

@Preview()
@Composable
fun CardExercicioPreview() {
    CardExercicio(
        "2",
        "https://img.freepik.com/fotos-gratis/garota-jovem-atraente-aptidao-jogging_176420-824.jpg?w=900&t=st=1696724177~exp=1696724777~hmac=22e1bd9fb34febf5a52a3058736cb9993cbd3c433f0b9009aad9e79af16b5e86",
        "Aquecimento de músculos",
        "5",
        "10",
        null
    )
}