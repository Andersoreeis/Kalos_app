package br.senai.sp.jandira.kalos_app.screens.telaHome.components

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.app_kalos.components.getLogoKalos
import br.senai.sp.jandira.kalos_app.model.AlunoResponse
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

@Composable
fun HeaderHome(aluno: AlunoResponse) {
    val calendario = Calendar.getInstance()

    fun obterSemana(): String {
        val formatoDiaDaSemana = SimpleDateFormat("EEEE", Locale.getDefault())
        val diaDaSemana = formatoDiaDaSemana.format(calendario.time)
        return diaDaSemana
    }

    fun obterDia(): String {
        val formatoData = SimpleDateFormat("dd", Locale.getDefault())
        val dataFormatada = formatoData.format(calendario.time)
        return dataFormatada
    }

    fun obterMes(): String {
        val formatoData = SimpleDateFormat("MM", Locale.getDefault())
        val dataFormatada = formatoData.format(calendario.time)
        return dataFormatada
    }

    var dia = obterDia()
    var diaSemana =
        when (obterSemana()) {
            "domingo" -> "DOM"
            "segunda-feira" -> "SEG"
            "sabado" -> "SAB"
            "quarta-feira" -> "QUA"
            "quinta-feira" -> "QUI"
            "sexta-feira" -> "SEX"
            else -> "TER"


        }
    var mes =
        when (obterMes()) {
            "01" -> "JANEIRO"
            "02" -> "FEVEREIRO"
            "03" -> "MARÇO"
            "04" -> "ABRIL"
            "05" -> "MAIO"
            "06" -> "JUNHO"
            "07" -> "JULHO"
            "08" -> "AGOSTO"
            "09" -> "SETEMBRO"
            "10" -> "OUTUBRO"
            "11" -> "NOVEMBRO"
            "12" -> "DEZEMBRO"
            else -> "janeiro"
        }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "${diaSemana.uppercase(Locale.getDefault())}, $dia DE ${
                        mes.uppercase(
                            Locale.getDefault()
                        )
                    }",
                    color = Color.White,
                    fontSize = 15.sp
                )
                Row {
                    Text(
                        text = "Olá, ",
                        color = Color.White,
                        fontSize = 40.sp
                    )
                    Text(
                        text = "${primeiroNome(aluno.nome.toString())} !",
                        color = Color.White,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.width(40.dp))
            getLogoKalos(size = 100.dp)
        }

    }
}

fun primeiroNome(frase: String): String {
    val palavras = frase.split(" ")
    if (palavras.isNotEmpty()) {
        return palavras[0]
    } else {
        return ""
    }
}



//@Preview
//@Composable
//fun HomeHeaderPreview() {
//    HeaderHome()
//}