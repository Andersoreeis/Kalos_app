package br.senai.sp.jandira.kalos_app.screens.telaSaudeLimitacoes.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.screens.telaSaudeLimitacoes.components.FormSaudeLimitacoes
import br.senai.sp.jandira.kalos_app.screens.telaSaudeLimitacoes.components.HeaderSaudeLimitacoes

@Composable
fun TelaSaudeLimitacoes(navController: NavController) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.Black)

  ) {
    Spacer(modifier = Modifier.height(30.dp))
    HeaderSaudeLimitacoes(navController = navController)
    Spacer(modifier = Modifier.height(50.dp))
    FormSaudeLimitacoes()
  }
}

//@Preview
//@Composable
//fun TelaSaudeLimitacoesPreview() {
//    TelaSaudeLimitacoes()
//}