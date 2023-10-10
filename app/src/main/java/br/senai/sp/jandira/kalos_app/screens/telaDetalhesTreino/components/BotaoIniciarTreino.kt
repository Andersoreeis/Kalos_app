package br.senai.sp.jandira.kalos_app.screens.telaDetalhesTreino.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BotaoIniciarTreino (cor: String){
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(Color(0xFF000000.toInt() or Integer.parseInt(cor, 16)))
    ) {
        Text(text = "Iniciar treino")
    }
}

@Composable
@Preview(showBackground = true)
fun BotaoIniciarTreinoPreview(){
    BotaoIniciarTreino("34439E")
}