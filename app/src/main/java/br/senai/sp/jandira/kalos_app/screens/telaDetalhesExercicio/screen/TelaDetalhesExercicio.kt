package br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createButtonWithWidth
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.model.ExercicioResponse
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components.CardProximoExercicio
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components.CardVideoPlayer
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components.Cronometro
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components.HeaderExercicio
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components.InputAnotarCarga
import br.senai.sp.jandira.kalos_app.service.ExercicioService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun TelaDetalhesExercicio(
    lifecycleOwner: LifecycleOwner,
    localStorage: Storage,
    navController: NavController,
    lifecycleCoroutineScope: LifecycleCoroutineScope
) {

    val context = LocalContext.current
    val corPrimariaAcademia =
        localStorage?.lerValor(context, "corPrimariaAcademia")

    val idsExercicios = localStorage.lerValor(context, "idExercicioSerieRepeticao")

    val arrayIdsExercicios = idsExercicios.toString()
        .substring(1, idsExercicios.toString().length - 1)
        .split(",")
        .map { it.trim().toInt() }

    var contador by remember {
        mutableStateOf(0)
    }


    var status by remember {
        mutableStateOf(false)
    }

    var estadoExercicio by remember {
        mutableStateOf(ExercicioResponse())
    }

    var estadoProximoExercicio by remember {
        mutableStateOf(ExercicioResponse())
    }


    lateinit var exercicioService: ExercicioService
    exercicioService = RetrofitHelper.getInstance().create(ExercicioService::class.java)

    lifecycleCoroutineScope.launch {

        val result = exercicioService.getExercicioPorId(arrayIdsExercicios[contador])

        if (result.isSuccessful) {
            estadoExercicio = result.body()?.data!!
            Log.e("exercico atual", estadoExercicio.toString())
        }

    }

    if (contador < arrayIdsExercicios.size - 1) {
        lifecycleCoroutineScope.launch {

            val result = exercicioService.getExercicioPorId(arrayIdsExercicios[contador + 1])

            if (result.isSuccessful) {
                estadoProximoExercicio = result.body()?.data!!
                Log.e("proximo exercico", estadoProximoExercicio.toString())
                status = true
            }
        }


    } else {
        estadoProximoExercicio = estadoExercicio
        status = true
    }


    if (status) {
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
                            arrayIdsExercicios.forEach {
                                if (it == estadoExercicio.id_exercicio_serie_repeticao){
                                    if (contador == 0){
                                        navController.navigate("detalhesTreino")
                                    } else {
                                        contador -= 1
                                        status = false
                                    }

                                }
                            }
                        },
                    contentDescription = null
                )

                CardVideoPlayer(
                    url = estadoExercicio.anexo!!,
                    lifecycleOwner = lifecycleOwner
                )

                Spacer(modifier = Modifier.height(15.dp))

                HeaderExercicio(
                    nome = estadoExercicio.nome!!,
                    series = estadoExercicio.series!!,
                    repeticoes = estadoExercicio.repeticoes,
                    duracao = estadoExercicio.duracao
                )
            }

            if (estadoExercicio.duracao != null) {
                Cronometro(
                    tempo = estadoExercicio.duracao!!,
                    cor = corPrimariaAcademia.toString()
                )
            } else {
                InputAnotarCarga(cor = corPrimariaAcademia.toString(), lifecycleCoroutineScope, localStorage, estadoExercicio.id_exercicio_serie_repeticao.toString())
            }

            val thumbnailUrl = "https://img.youtube.com/vi/${estadoProximoExercicio.anexo}/0.jpg"

            if (contador < arrayIdsExercicios.size - 1) {
                CardProximoExercicio(
                    imagem = thumbnailUrl,
                    nome = estadoProximoExercicio.nome!!
                ) {
                    contador += 1
                    status = false
                }
            } else {
                createButtonWithWidth(
                    textButton = "Finalizar treino",
                    corBotao = Color(android.graphics.Color.parseColor(corPrimariaAcademia)),
                    width = 350.dp
                ) {
                    navController.navigate("treinoConcluido")
                }
            }

        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                color = Color(0, 255, 144),
                modifier = Modifier.size(64.dp)
            )
        }
    }


}

//@Preview(showSystemUi = true)
//@Composable
//fun TelaDetalhesExercicioPreview() {
//    TelaDetalhesExercicio(LocalLifecycleOwner.current, null, rememberNavController())
//}