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
    val color = android.graphics.Color.parseColor(cor)
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(Color(color))
    ) {
        Text(text = "Iniciar treino",
            color =  if(cor.equals("#FFFFFF")){
            Color.Black
        }else{
            Color.White
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun BotaoIniciarTreinoPreview(){
    BotaoIniciarTreino("#34439E")
}