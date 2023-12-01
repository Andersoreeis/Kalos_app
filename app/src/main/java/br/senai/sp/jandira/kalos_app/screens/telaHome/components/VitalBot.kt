package br.senai.sp.jandira.kalos_app.screens.telaHome.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import br.senai.sp.jandira.kalos_app.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos

@Composable
fun VitalBot(navController: NavController) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)) {
        Image(
            painter = painterResource(id = R.drawable.botremovebg),
            contentDescription = null,
            modifier = Modifier.width(88.dp)
        )

        Spacer(modifier = Modifier.width(50.dp))

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .height(133.dp)
                .padding(5.dp)
        ) {
            Text(
                text = "Converse com nosso assistente virtual especializado em treinos, saúde e bem-estar!",
                color = Color.White,
                textAlign = TextAlign.End,
                fontSize = 13.sp
            )

            Button(
                onClick = {
                    navController.navigate("chatBot")
                },
                colors = ButtonDefaults.buttonColors(GreenKalos),
                modifier = Modifier.height(35.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.sendicon),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "Vital Bot",
                        color = Color.Black,
                        textAlign = TextAlign.End,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun VitalBotPrev() {
//    VitalBot()
//}