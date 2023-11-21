package br.senai.sp.jandira.kalos_app.screens.telaChat.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos

@Composable
fun MensagemRecebida(mensagem: String, horario: String) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),

        horizontalArrangement = Arrangement.Start
    ) {
        Surface(
            color = GrayKalos,
            modifier = Modifier.widthIn(min = 50.dp,max = 300.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = mensagem.trim(),
                    fontSize = 12.sp,
                    color = Color.White
                )

                Text(
                    text = horario,
                    fontSize = 8.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Light
                )
            }
        }
    }

}

@Preview
@Composable
fun MensagemRecebidaPreview() {
    MensagemRecebida(
        "aifaodfcdoad",
        "23:09"
    )
}