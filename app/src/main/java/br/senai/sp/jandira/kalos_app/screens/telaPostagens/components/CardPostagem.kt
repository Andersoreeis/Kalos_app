package br.senai.sp.jandira.kalos_app.screens.telaPostagens.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalosEscuro
import coil.compose.AsyncImage
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CardPostagem(titulo: String, foto: String?, descricao: String, data: String, hora: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            ,

    ) {
        Text(
            text = titulo,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))

        if(foto != null){
            Surface(
                modifier = Modifier
                    .size(350.dp)
                    .clip(RoundedCornerShape(20.dp))
            ) {
                AsyncImage(
                    model = foto,
                    contentDescription = stringResource(R.string.foto_da_postagem),
                    modifier = Modifier
                        .fillMaxSize() ,
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
        }


        Text(
            text = descricao ,
            color = Color.White,
            lineHeight = TextUnit(18f, TextUnitType.Sp),
            fontSize = 12.sp

        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            arrumarData(data)?.let {
                Text(
                    text = it,
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(900),
                )
            }

            Text(
                text = " - ",
                color = Color.White ,
                fontSize = 12.sp,
                fontWeight = FontWeight(900)
            )

            arrumarHorario(hora)?.let {
                Text(
                    text = it,
                    color = Color.White ,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(900)
                )
            }
        }





        Spacer(modifier = Modifier.height(10.dp))

        Box (
            modifier = Modifier
                .fillMaxWidth()
                .background(GrayKalos)
                .height(2.dp)
        ){}



    }
}

fun arrumarData(date: String): String? {
    val formatoOriginal = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")

    // Parse a data original em um objeto Date
    val data = formatoOriginal.parse(date)

    // Define o formato desejado para a data formatada
    val formatoFormatado = SimpleDateFormat("dd/MM/yyyy")

    // Formata a data no formato desejado
    val dataFormatada = data?.let { formatoFormatado.format(it) }
    return dataFormatada
}

@RequiresApi(Build.VERSION_CODES.O)
fun arrumarHorario(date: String): String? {
    // Parse a data original em um objeto Instant
    val instant = Instant.parse(date)

    // Converte o Instant para um objeto ZonedDateTime em um fuso horário específico (UTC)
    val zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.of("UTC"))

    // Define o formato desejado para o horário
    val formatoHorario = DateTimeFormatter.ofPattern("H:mm")

    // Formata o horário no formato desejado
    val horarioFormatado = zonedDateTime.format(formatoHorario)
    return horarioFormatado
}

//@Preview
//@Composable
//fun PreviewCardPostagem() {
//    CardPostagem(titulo = "teste", foto = null, descricao = "lalala", data = , hora = )
//}
