package br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components


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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.R
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

@Composable
fun Cronometro(tempo: String, cor: String) {
    val color = android.graphics.Color.parseColor(cor)
    val tempoEmPartes = tempo.split(":")
    val horas = tempoEmPartes[0]
    val minutos = tempoEmPartes[1]
    val segundos = tempoEmPartes[2]

    val tempoEmMilisegundos = TimeUnit.HOURS.toMillis(horas.toLong()) +
                              TimeUnit.MINUTES.toMillis(minutos.toLong()) +
                              TimeUnit.SECONDS.toMillis(segundos.toLong())

    var tempoRestante by remember { mutableStateOf(tempoEmMilisegundos) }
    var pausado by remember { mutableStateOf(true) }

    fun millisegParaHMS(milisegundos: Long): String {
        val horas = (milisegundos / 3600000).toInt()
        val minutos = ((milisegundos % 3600000) / 60000).toInt()
        val segundos = ((milisegundos % 60000) / 1000).toInt()

        return String.format("%02d:%02d:%02d", horas, minutos, segundos)
    }

    fun resetarContador() {
        pausado = true
        tempoRestante = tempoEmMilisegundos
    }

    LaunchedEffect(key1 = tempoRestante, key2 = pausado) {
        while (tempoRestante > 0 && !pausado) {
            delay(1000)
            tempoRestante -= 1000
        }
    }

    val formattedTime = remember(tempoRestante) {
        millisegParaHMS(tempoRestante)
    }

    Column(
        Modifier
            .width(360.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formattedTime,
            color = Color.White,
            fontSize = 75.sp,
            fontFamily = FontFamily( Font(R.font.montserrat)),
            fontWeight = FontWeight.Black
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    resetarContador()
                },
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
                    pausado = !pausado
                },
                colors = ButtonDefaults.buttonColors(Color(color)),
                modifier = Modifier.height(45.dp)
            ) {
                Text(
                    text = if (pausado) "Iniciar" else "Pausar",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CronometroPreview() {
    Cronometro("00:02:00", "#34439E")
}