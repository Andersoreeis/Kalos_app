package br.senai.sp.jandira.kalos_app.screens.telaChat.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos

@Composable
fun MensagemEnviada(mensagem: String, horario: String) {

    Row (modifier = Modifier.fillMaxSize().padding(5.dp), horizontalArrangement = Arrangement.End){
        Surface(
            color = GreenKalos,
            modifier = Modifier.widthIn(min = 50.dp,max = 300.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = mensagem.trim(),
                    fontSize = 12.sp,
                    color = Color.Black,
                    textAlign = TextAlign.End
                )
                Text(
                    text = horario,
                    fontSize = 8.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.End
                )
            }
        }
    }

}

@Preview
@Composable
fun MensagemEnviadaPreview() {
    MensagemEnviada(
        "oi",
        "23:09"
    )
}