package br.senai.sp.jandira.kalos_app.screens.telaInicialComponent.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createButton
import br.senai.sp.jandira.app_kalos.components.getLogoKalosCompleted
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.screens.telaInicialComponent.components.TextTelaInicial
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos

@Composable
fun TelaInicial(navController: NavController) {
    val montserrat = FontFamily(Font(R.font.montserrat_thin))
    Column(
        modifier = Modifier
            .fillMaxSize()

            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF464646),
                        Color(0xFF000000)
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        getLogoKalosCompleted()

        Spacer(modifier = Modifier.height(5.dp))
        Box (
            modifier = Modifier
                .height(1.dp)
                .width(50.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF58B2E1),
                            Color(0xFF00F49B)
                        )
                    )
                )
        ){}

        TextTelaInicial()

        Spacer(modifier = Modifier.height(30.dp))

        Column (
            modifier = Modifier.padding(horizontal = 20.dp)
        ){
            createButton(
                textButton = "Sou Aluno" ,
                naveController = navController,
                navName = "",
                corBotao = GreenKalos)

            Spacer(modifier = Modifier.height(5.dp))

            createButton(
                textButton = "Sou Academia" ,
                naveController = navController,
                navName = "",
                corBotao = GreenKalos)
        }


    }
}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun TelaInicialPreview() {
//    TelaInicial()
//}