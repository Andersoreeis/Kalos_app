package br.senai.sp.jandira.kalos_app.components

import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createButtonWithFunction
import br.senai.sp.jandira.kalos_app.screens.InformacoesCliente.screen.TelasInformacoesdoCliente
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CampoSenha
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CamposCriarConta
import br.senai.sp.jandira.kalos_app.screens.telaInformacoesPessoais.screen.InformacoesPessoais
import br.senai.sp.jandira.kalos_app.screens.telaSaudeLimitacoes.screen.TelaSaudeLimitacoes
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos


@Composable
fun BarraProgresso(navController: NavController) {

    val context = LocalContext.current
    var progressCount = remember { mutableStateOf(0) }
    var progress = remember { mutableStateOf(0.3f) }

    when (progressCount.value) {

        1 -> progress.value = 0.3f
        2 -> progress.value = 0.5f
        3 -> progress.value = 0.6f
        4 -> progress.value = 0.7f
        5 -> progress.value = 0.8f
        6 -> progress.value = 1.0f
    }


    val size = animateFloatAsState(
        targetValue = progress.value,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp)
    ) {

        if (progressCount.value == 0)
            InformacoesPessoais(navController = navController)
        else if (progressCount.value == 2)
            TelaSaudeLimitacoes(navController = navController)
        else if (progressCount.value == 4)
            Text(text = "parte 4")
        else if (progressCount.value == 6)
            Text(text = "parte 6")




        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp), verticalArrangement = Arrangement.Bottom
        ) {
            // Progress Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()

                        .background(GrayKalos)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(size.value)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(9.dp))
                        .background(GreenKalos)
                        .animateContentSize()
                )


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
            ) {

                fun increment() {
                    if (progressCount.value < 6) {
                        progressCount.value += 2
                    } else {
                        Toast.makeText(context, "Erro", Toast.LENGTH_SHORT).show()
                    }
                }


                if (progressCount.value == 0) {
                    createButtonWithFunction(
                        textButton = "Continue",
                        corBotao = GreenKalos

                    ) {
                        increment()
                    }
                } else if (progressCount.value == 2) {
                    createButtonWithFunction(
                        textButton = "Continue",
                        corBotao = GreenKalos

                    ) {
                        increment()
                    }
                } else if (progressCount.value == 4) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        createButtonWithFunction(
                            textButton = "Continue",
                            corBotao = GreenKalos

                        ) {
                            increment()
                        }
                        Espacamento(tamanho = 15.dp)
                        createButtonWithFunction(
                            textButton = "Pular",
                            corBotao = Color.Red

                        ) {
                            increment()
                        }
                    }
                } else if (progressCount.value == 6) {
                    createButtonWithFunction(
                        textButton = "Continue",
                        corBotao = GreenKalos

                    ) {
                        increment()
                    }
                }


            }
        }


    }
}