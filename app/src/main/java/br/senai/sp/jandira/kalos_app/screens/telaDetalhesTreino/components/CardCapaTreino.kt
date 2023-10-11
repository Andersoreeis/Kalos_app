package br.senai.sp.jandira.kalos_app.screens.telaDetalhesTreino.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.R
import coil.compose.AsyncImage


@Composable
fun CardCapaTreino(imagem: String, navController: NavController) {

//    val colorStops = arrayOf(
//        0.0f to Color.Yellow,
//        1f to Color.Black
//    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
    ) {



        AsyncImage(
            model = imagem,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(alpha = 0.5f),
            colorFilter = ColorFilter.tint(Color.Black, BlendMode.Lighten),
            error = painterResource(id = R.drawable.treinoerro)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black

                        )
                    )
                )
        )

        Icon(
            painter = painterResource(id = R.drawable.baseline_chevron_left_24),
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
                .clickable {
                           navController.navigate("homeAcademia")
                },
            contentDescription = null
        )
    }


}

//@Preview
//@Composable
//fun CardCapaTreinoPreview() {
//    CardCapaTreino(imagem = "")
//}