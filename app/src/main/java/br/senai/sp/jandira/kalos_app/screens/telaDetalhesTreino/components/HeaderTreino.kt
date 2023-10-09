package br.senai.sp.jandira.kalos_app.screens.telaDetalhesTreino.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesTreino.components.ui.theme.Kalos_appTheme
import br.senai.sp.jandira.kalos_app.screens.telaHomeAcademia.components.dateToLocalDate
import br.senai.sp.jandira.kalos_app.screens.telaHomeAcademia.components.formatarData2
import br.senai.sp.jandira.kalos_app.screens.telaPerfil.components.convertIso8601ToDate

@Composable
fun HeaderTreino(
    nomeTreino: String,
    nivelTreino: String,
    categoriaTreino: String,
    descricao: String?,
    dataTreino: String
) {
    Column(
        modifier = Modifier
            .background(Color.Black)
    ) {


        Text(
            text = nomeTreino,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )


        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${categoriaTreino} - ${nivelTreino}",
                color = Color.White,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )


            Surface(
                modifier = Modifier
                    .height(25.dp)
                    .width(90.dp)
                ,
                color = Color(255, 255, 255, 60),
                shape = RoundedCornerShape(10.dp)

            ) {
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

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = dataTreino,
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }

            }


        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = descricao ?: "",
            color = Color.White,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp
        )

    }
}

@Composable
@Preview(showBackground = true)
fun HeaderTreinoPreview() {
    HeaderTreino(
        "Treino cardiovascular",
        "Iniciante",
        "Musculação",
        "Lorem ipsum dolor sit amet consectetur. Molestie et nam auctor at dis non condimentum leo sodales. Libero quis bibendum nunc lorem lectus...",
        "01/05/2023"
    )
}