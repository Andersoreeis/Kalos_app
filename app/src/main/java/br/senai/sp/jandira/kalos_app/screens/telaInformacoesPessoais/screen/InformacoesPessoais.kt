package br.senai.sp.jandira.kalos_app.screens.telaInformacoesPessoais.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.components.BarraProgresso
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CamposCriarConta

@Composable
fun InformacoesPessoais(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {

        BarraProgresso()

    }
}