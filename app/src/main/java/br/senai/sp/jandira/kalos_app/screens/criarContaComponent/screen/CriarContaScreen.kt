package br.senai.sp.jandira.kalos_app.screens.criarContaComponent.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createButton
import br.senai.sp.jandira.app_kalos.components.createButtonWithWidth
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.screens.criarContaComponent.components.CamposCriarConta
import br.senai.sp.jandira.kalos_app.screens.criarContaComponent.components.HeaderCriarConta
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos

@Composable
fun CriarContaScreen( navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp, start = 21.dp)
            ) {
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_chevron_left_24) ,
                        contentDescription = "Botão para voltar para tela anterior",
                        tint = Color.White,
                    )
                }
            }

            HeaderCriarConta()
            Spacer(modifier = Modifier.height(72.dp))
            CamposCriarConta()
            Spacer(modifier = Modifier.height(98.dp))


                createButtonWithWidth(
                    textButton = stringResource(R.string.continuar) ,
                    naveController = navController ,
                    navName = "",
                    corBotao = GreenKalos,
                    width = 350.dp)


        }

}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun CriarContaScreenPreview() {
//    CriarContaScreen()
//}