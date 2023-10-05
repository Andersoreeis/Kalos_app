package br.senai.sp.jandira.kalos_app.screens.telaHomeAcademia.components

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.model.TreinosResponse
import br.senai.sp.jandira.kalos_app.screens.telaPerfil.components.convertIso8601ToDate
import coil.compose.AsyncImage
import java.time.LocalDate
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TelaTreinos() {

    val testes = listOf(
        TreinosResponse(
            nome = "Treino de perna",
            foto = "https://firebasestorage.googleapis.com/v0/b/kalos-app-b403c.appspot.com/o/" +
                    "images%2Ffotoacademia.png?alt=media&token=699de6e9-2d5f-4843-8c4f-c600cfa1ae" +
                    "df&_gl=1*k4mb0j*_ga*NDQ2MTg1MTA2LjE2OTE2OTMzMDY.*_ga_CW55HF8NVT*MTY5NjUyNTUxMy4" +
                    "xOS4xLjE2OTY1MjU3MjMuMzguMC4w",
            nome_categoria_treino = "Musculação",
            data_criacao = "2004-04-10T00:00:00.000Z"
        ),
        TreinosResponse(
            nome = "Treino de Costas",
            foto = "https://firebasestorage.googleapis.com/v0/b/kalos-app-b403c.appspot.com/o/" +
                    "images%2Ffotoacademia.png?alt=media&token=699de6e9-2d5f-4843-8c4f-c600cfa1ae" +
                    "df&_gl=1*k4mb0j*_ga*NDQ2MTg1MTA2LjE2OTE2OTMzMDY.*_ga_CW55HF8NVT*MTY5NjUyNTUxMy4" +
                    "xOS4xLjE2OTY1MjU3MjMuMzguMC4w",
            nome_categoria_treino = "Musculação",
            data_criacao = "2004-04-10T00:00:00.000Z"
        ),
        TreinosResponse(
            nome = "Treino de Peito",
            foto = "https://firebasestorage.googleapis.com/v0/b/kalos-app-b403c.appspot.com/o/" +
                    "images%2Ffotoacademia.png?alt=media&token=699de6e9-2d5f-4843-8c4f-c600cfa1ae" +
                    "df&_gl=1*k4mb0j*_ga*NDQ2MTg1MTA2LjE2OTE2OTMzMDY.*_ga_CW55HF8NVT*MTY5NjUyNTUxMy4" +
                    "xOS4xLjE2OTY1MjU3MjMuMzguMC4w",
            nome_categoria_treino = "Musculação",
            data_criacao = "2004-04-10T00:00:00.000Z"
        )
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(testes) {
                Box(
                    modifier = Modifier
                        .height(227.dp)
                        .width(344.dp)
                ) {
                    AsyncImage(
                        model = it.foto,
                        contentDescription = "foto do treino",
                        modifier = Modifier.fillMaxSize()
                    )
                    Column(
                        modifier = Modifier.padding(top = 140.dp, start = 20.dp)
                    ) {
                        Text(text = it.nome.toString(), color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(
                            text = it.nome_categoria_treino.toString(),
                            color = Color.White,
                            fontSize = 15.sp
                        )
                        Surface(
                            modifier = Modifier
                                .height(25.dp)
                                .width(90.dp)
                                ,
                             color = Color(255, 255, 255, 60),
                            shape = RoundedCornerShape(10.dp)

                        ) {
                            val date =
                                dateToLocalDate(convertIso8601ToDate(it.data_criacao.toString())).toString()
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_calendar_month_24),
                                    contentDescription = "calendario",
                                    tint = Color.White
                                )
                                Text(
                                    text = formatarData2(date),
                                    color = Color.White,
                                    fontSize = 12.sp
                                )
                            }

                        }

                    }

                }
                Spacer(modifier = Modifier.height(15.dp))
            }
        }

    }
}

fun formatarData2(input: String): String {
    val digitsOnly = input.replace(Regex("[^\\d]"), "")

    if (digitsOnly.length < 8) {
        Log.e("digi", "formatarData: ${digitsOnly}")
        return digitsOnly
    }

    val day = digitsOnly.substring(6, 8)
    val month = digitsOnly.substring(4, 6)
    val year = digitsOnly.substring(0, 4)

    val formattedDate = "$day/$month/$year"

    return formattedDate
}

@RequiresApi(Build.VERSION_CODES.O)
fun dateToLocalDate(date: Date): LocalDate {
    val instant = date.toInstant()
    return instant.atZone(java.time.ZoneId.systemDefault()).toLocalDate()
}