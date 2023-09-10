package br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.app_kalos.components.createTextKalosRedirection
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos

@Composable
fun IrparaCadastro(navController: NavController) {
 Row {
     createTextKalos(content = "Não possui conta?", sizeText = 12 , colorText = Color.White , bold = 400 , alinhamento = TextAlign.Center)
     createTextKalosRedirection(content = "Cadastre-se", sizeText = 12 , colorText = GreenKalos, bold = 700 , alinhamento = TextAlign.Center , navControlelr = navController, navName = "criarConta")

 }
}

