package br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createButton
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.app_kalos.components.createTitleKalos
import br.senai.sp.jandira.app_kalos.components.getLogoKalos
import br.senai.sp.jandira.kalos_app.components.Espacamento
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CampoSenha
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CamporEmail
import br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.component.esqueceuSenhaText
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos

@Composable
fun LoginScreen(navController: NavController) {

    val estadoEmail = remember {
        mutableStateOf("")
    }

    val estadoSenha = remember {
        mutableStateOf("")
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Espacamento(tamanho = 10.dp)
            getLogoKalos(size = 80.dp)
            createTitleKalos(
                content = "Olá, aluno (a)!",
                sizeText = 36,
                colorText = Color.White,
                bold = 700,
                alinhamento = TextAlign.Center
            )
            Espacamento(tamanho = 10.dp)
            createTextKalos(
                content = "Bem vindo de volta!",
                sizeText = 20,
                colorText = Color.White,
                bold = 400,
                alinhamento = TextAlign.Center
            )

        }
        Espacamento(tamanho = 80.dp)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp), verticalArrangement = Arrangement.Center
        ) {
            CamporEmail(
                value = estadoEmail.value.toString(),
                aoMudar = { estadoEmail.value = it },
                placeholder = "Digite o email"
            )
            Espacamento(tamanho = 20.dp)
            CampoSenha(
                value = estadoSenha.value.toString(),
                aoMudar = { estadoSenha.value = it },
                placeholder = "Digite a senha"
            )
            Espacamento(tamanho = 15.dp)

            esqueceuSenhaText(
                content = "Esqueci a senha",
                sizeText = 12,
                colorText = Color.White,
                bold = 400,
                alinhamento = TextAlign.End,
                naveController = navController,
                navName = "criarConta"
            )



        }
        Espacamento(tamanho = 50.dp)

        createButton(textButton = "Entrar", naveController =  navController, navName = "" , corBotao = GreenKalos)

    }
}



