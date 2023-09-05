package br.senai.sp.jandira.kalos_app.screens.criarContaComponent.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CamposCriarConta() {
    var teste by remember{
        mutableStateOf("")
    }
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ){

        CampoSenha("", {teste = it}, "Digite a senha" )
        CampoSenha("", {teste = it}, "Digite a senha" )
        CampoSenha("", {teste = it}, "Digite a senha" )



    }
}

@Preview(showSystemUi = true)
@Composable
fun CamposCriarContaPreview() {
    
}