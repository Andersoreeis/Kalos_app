package br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components

import android.content.Context
import android.os.CountDownTimer
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit
import kotlin.time.toDurationUnit

@Composable
fun Cronometro(tempo: String, cor: String) {
    val color = android.graphics.Color.parseColor(cor)
    val tempoEmPartes = tempo.split(":")
    val horas = tempoEmPartes[0]
    val minutos = tempoEmPartes[1]
    val segundos = tempoEmPartes[2]

    val tempoEmMilisegundos =
        TimeUnit.HOURS.toMillis(horas.toLong()) + TimeUnit.MINUTES.toMillis(minutos.toLong()) + TimeUnit.SECONDS.toMillis(
            segundos.toLong()
        )

    var timeLeft by remember { mutableStateOf(tempoEmMilisegundos) }
    var isPaused by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = timeLeft, key2 = isPaused) {
        while (timeLeft > 0 && !isPaused) {
            delay(1000L)
            timeLeft--
        }
    }

    Log.e(
        "formatadolelelalealfkrlakrjelak",
        String.format(
            "%02d:%02d:%02d",
            TimeUnit.MILLISECONDS.toHours(timeLeft),
            TimeUnit.MILLISECONDS.toMinutes(timeLeft) % 60,
            TimeUnit.MILLISECONDS.toSeconds(timeLeft) % 60
        ),
    )

    Log.e("lasfjskfjkafjek", "${timeLeft}")

    fun resetTimer() {
        timeLeft = tempoEmMilisegundos
        isPaused = false
    }

    Column(
        Modifier
            .background(Color.Black)
            .width(350.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = String.format(
                "%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(timeLeft),
                TimeUnit.MILLISECONDS.toMinutes(timeLeft) % 60,
                TimeUnit.MILLISECONDS.toSeconds(timeLeft) % 60
            ),
            color = Color.White,
            fontSize = 85.sp
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { resetTimer() },
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier
                    .border(1.dp, Color.White, CircleShape)
                    .height(45.dp)
            ) {
                Text(
                    text = "Resetar",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }


            Button(
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(Color(color)),
                modifier = Modifier.height(45.dp)
            ) {
                Text(
                    text = "Iniciar",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}


@Composable
fun CountdownTimerWithReset() {
    var timeLeft by remember { mutableStateOf(60) }
    var isPaused by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = timeLeft, key2 = isPaused) {
        while (timeLeft > 0 && !isPaused) {
            delay(1000L)
            timeLeft--
        }
    }

    fun resetTimer() {
        timeLeft = 60
        isPaused = false
    }

    Column {
        Text(text = "Time left: $timeLeft")
        Button(onClick = { isPaused = !isPaused }) {
            Text(text = if (isPaused) "Resume" else "Pause")
        }
        Button(onClick = { resetTimer() }) {
            Text(text = "Reset")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CronometroPreview() {
    Cronometro("00:02:10", "#34439E")
    //CountdownTimerWithReset()
}