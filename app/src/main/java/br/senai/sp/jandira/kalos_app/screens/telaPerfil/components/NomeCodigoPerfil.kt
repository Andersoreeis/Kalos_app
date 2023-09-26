package br.senai.sp.jandira.kalos_app.screens.telaPerfil.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.model.AlunoResponse

@Composable
fun NomeCodigoPerfil(aluno: AlunoResponse) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        aluno.nome?.let {
            Text(
                text = it,
                fontSize = 32.sp,
                color = Color.White
            )
        }

        var soma: Int? = aluno.id!! + 10000
        Text(
            text = "#${soma.toString()}" ,
            fontSize = 20.sp,
            color = Color.Gray
        )
    }
}