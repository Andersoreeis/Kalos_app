package br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.kalos_app.R

@Composable
fun HeaderExercicio(nome: String, repeticao: String?, duracao: String?){
    Surface (
        modifier = Modifier
            .height(50.dp)
            .width(300.dp),
            color = Color.Black
    ){
        Row (modifier = Modifier.fillMaxSize()){
            Icon(
                painter = painterResource(id = R.drawable.baseline_chevron_left_24),
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp),
                contentDescription = null
            )

//            Column {
//                Text(text = )
//            }
        }
    }
}

@Preview
@Composable
fun HeaderExercicioPreview(){
//    HeaderExercicio()
}