package br.senai.sp.jandira.kalos_app.screens.telaPerfil.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.model.AlunoResponse
import br.senai.sp.jandira.kalos_app.screens.telaHome.components.BarraRetaHome
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MedidasPerfil(aluno: AlunoResponse) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BarraRetaHome()
        Row(
            Modifier.fillMaxWidth().padding(vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
             horizontalArrangement = Arrangement.SpaceAround
        ) {
            MedidaValorPerfil(titulo = "PESO", valor = aluno.peso.toString()?: "0", desc = "kg")
            BarraVerticalPerfil()
            MedidaValorPerfil(titulo = "ALTURA", valor = aluno.altura.toString()?: "0", desc = "cm")
            BarraVerticalPerfil()
            val date = convertIso8601ToDate(aluno.data_nascimento.toString())
            val dateLocal = dateToLocalDate(date)
            val idade = calcularDiferencaEntreDatas(dateLocal)
            MedidaValorPerfil(titulo = "IDADE", valor = idade.years.toString(), desc = "")
        }
        BarraRetaHome()

    }
}

fun convertIso8601ToDate(iso8601String: String): Date {
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    return format.parse(iso8601String)
}

@RequiresApi(Build.VERSION_CODES.O)
fun calcularDiferencaEntreDatas(data: LocalDate): Period {
    val dataAtual = LocalDate.now()
    return Period.between(data, dataAtual)
}

@RequiresApi(Build.VERSION_CODES.O)
fun dateToLocalDate(date: Date): LocalDate {
    val instant = date.toInstant()
    return instant.atZone(java.time.ZoneId.systemDefault()).toLocalDate()
}