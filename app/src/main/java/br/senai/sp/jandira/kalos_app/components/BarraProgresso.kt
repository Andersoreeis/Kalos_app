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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.app_kalos.components.createButtonWithFunction
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CampoSenha
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CamposCriarConta
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos


@Composable
fun BarraProgresso() {

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
            .padding(top = 100.dp, start = 30.dp, end = 30.dp)
    ) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)) {
                if (progressCount.value == 0) {
                    CamposCriarConta()
                } else if (progressCount.value == 2) {
                    CampoSenha(value = "", aoMudar = { "" }, placeholder = "sdfsdf")
                }

            }
        }
        Row(
            modifier = Modifier
                .widthIn(min = 30.dp)
                .fillMaxWidth(size.value),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = "${progressCount.value}")
        }
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

            createButtonWithFunction(
                textButton = "Continue",
                corBotao = GreenKalos

            ) {
                increment()
            }
        }


    }
}