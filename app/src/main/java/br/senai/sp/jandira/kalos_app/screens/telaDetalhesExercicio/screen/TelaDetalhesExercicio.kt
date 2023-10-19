package br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components.CardProximoExercicio
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components.CardVideoPlayer
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components.Cronometro
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components.HeaderExercicio

@Composable
fun TelaDetalhesExercicio(
    lifecycleOwner: LifecycleOwner,
    localStorage: Storage,
    navController: NavController,
) {

    val context = LocalContext.current
    val corPrimariaAcademia =
        localStorage?.lerValor(context, "corPrimariaAcademia")

    Log.e("tatatata", "${localStorage.lerValor(context, "idExercicioSerieRepeticao")}" )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(15.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column {
            Icon(
                painter = painterResource(id = R.drawable.baseline_chevron_left_24),
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        navController.navigate("telaDetalhesExercicio")
                    },
                contentDescription = null
            )

            CardVideoPlayer(
                url = "AzDDreIhb6Y",
                lifecycleOwner = lifecycleOwner
            )

            Spacer(modifier = Modifier.height(15.dp))

            HeaderExercicio(
                nome = "Cardiovascular",
                series = "5",
                repeticoes = null,
                duracao = "00:20:00"
            )
        }

        Cronometro(
            tempo = "00:20:00",
            cor = corPrimariaAcademia.toString()
        )

        CardProximoExercicio(
            imagem = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT40PJyCdkXf6D_RepRTK0q2u4oa66RZEVjsPRBseZR3A&s",
            nome = "Aquecimento de músculos"
        )
    }


}

//@Preview(showSystemUi = true)
//@Composable
//fun TelaDetalhesExercicioPreview() {
//    TelaDetalhesExercicio(LocalLifecycleOwner.current, null, rememberNavController())
//}