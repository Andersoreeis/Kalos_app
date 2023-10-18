package br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components.CardProximoExercicio
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components.CardVideoPlayer
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components.Cronometro
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components.HeaderExercicio

@Composable
fun TelaDetalhesExercicio(lifecycleOwner: LifecycleOwner, localStorage: Storage?) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = 20.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Column (modifier = Modifier){
            Icon(
                painter = painterResource(id = R.drawable.baseline_chevron_left_24),
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        TODO()
                    },
                contentDescription = null
            )

            CardVideoPlayer(
                url = "AzDDreIhb6Y",
                lifecycleOwner = lifecycleOwner
            )

            Column (modifier = Modifier.padding(15.dp)){
                HeaderExercicio(
                    nome = "Exercício cardiovascular",
                    series = "5",
                    repeticoes = null,
                    duracao = "00:10:00"
                )


            }

            Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                Cronometro(
                    tempo = "00:10:00",
                    cor = "#34439E"
                )
            }

        }

        Column {
            CardProximoExercicio(
                imagem = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0C19RjomDuUGpzoWem7F3ikZIvwEn5PtQoA&usqp=CAU",
                nome = "Aquecimento de músculos"
            )
        }
    }

}

@Preview (showSystemUi = true)
@Composable
fun TelaDetalhesExercicioPreview() {
    TelaDetalhesExercicio(LocalLifecycleOwner.current, null)
}