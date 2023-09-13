package br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import br.senai.sp.jandira.app_kalos.components.createButtonWithError
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.app_kalos.components.createTitleKalos
import br.senai.sp.jandira.app_kalos.components.getLogoKalos
import br.senai.sp.jandira.kalos_app.components.ContinueCom
import br.senai.sp.jandira.kalos_app.components.Espacamento
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CampoSenha
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CamporEmail
import br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.component.CampoEmailLogin
import br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.component.CampoSenhaLogin
import br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.component.IrparaCadastro
import br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.component.esqueceuSenhaText
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos


@Composable

fun LoginScreen(navController: NavController) {
    val estadoEmail = remember { mutableStateOf("") }
    val estadoSenha = remember { mutableStateOf("") }
    val estadoErroEmail = remember { mutableStateOf("") }
    val estadoErroSenha = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
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
                .size(200.dp),
            verticalArrangement = Arrangement.Center
        ) {
            if (estadoErroEmail.value.isNotEmpty()) {
                createTextKalos(
                    content = estadoErroEmail.value,
                    sizeText = 16,
                    colorText = Color.Red,
                    bold = 300,
                    alinhamento = TextAlign.Center
                )
            }
            CampoEmailLogin(
                value = estadoEmail.value.toString(),
                aoMudar = { novoValor ->
                    estadoEmail.value = novoValor
                    estadoErroEmail.value = ""
                },
                placeholder = "Digite o email",
                isError = estadoErroEmail.value.isNotEmpty()
            )

            Espacamento(tamanho = 20.dp)
            if (estadoErroSenha.value.isNotEmpty()) {
                createTextKalos(
                    content = estadoErroSenha.value,
                    sizeText = 16,
                    colorText = Color.Red,
                    bold = 300,
                    alinhamento = TextAlign.Center
                )
            }
            CampoSenhaLogin(
                value = estadoSenha.value.toString(),
                aoMudar = { novoValor ->
                    estadoSenha.value = novoValor
                    estadoErroSenha.value = ""
                },
                placeholder = "Digite a senha",
                isError = estadoErroSenha.value.isNotEmpty()
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
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
        }
        Espacamento(tamanho = 50.dp)

        createButtonWithError(
            textButton = "Entrar",
            corBotao = GreenKalos,

        ) {
            val email = estadoEmail.value
            val senha = estadoSenha.value
            val erroEmail = validarEmail(email)
            val erroSenha = validarSenha(senha)

            estadoErroEmail.value = erroEmail ?: ""
            estadoErroSenha.value = erroSenha ?: ""

            if (erroEmail == null && erroSenha == null) {
                // Navegar para a próxima tela
                navController.navigate("telaInformacoesDoCliente")
            }
        }

        ContinueCom()

        Espacamento(tamanho = 30.dp)

        IrparaCadastro(navController = navController)
    }
}

fun validarEmail(email: String): String? {

    if (email.length > 30 ){

        return "O limite de caracteres ultrapassou o necessário"

    }else if ( email.isEmpty()){

        return "Não pode estár vázio"


    }else {
        return null // Retorna null se o email for válido

    }
}

fun validarSenha(senha: String): String? {

    if (senha.length > 30 ){

        return "O limite de caracteres ultrapassou o necessário"

    }else if ( senha.isEmpty()){

        return "Não pode estár vázio"


    }else {
        return null

    }}



