package br.senai.sp.jandira.kalos_app.screens.telaEsqueciSenha.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.app_kalos.components.createButtonWithFunction
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.app_kalos.components.getLogoKalos
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CampoEmailCadastrar
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CampoEmailCadastrar2
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalosEscuro
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos

@Composable
fun TelaEsqueciSenhaEmail() {
    var estadoEmail by remember {
        mutableStateOf("")
    }
    var estadoEmailError by remember {
        mutableStateOf("")
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            getLogoKalos(size = 150.dp)
            Text(
                text = stringResource(R.string.esqueci_a_senha),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(R.string.Iremos_enviar_email),
                color = Color.White,
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(70.dp))


            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.digite_o_email_cadastrado),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = GrayKalos
                )
                Spacer(modifier = Modifier.height(10.dp))
                CampoEmailCadastrar2(
                    value = estadoEmail.toString(),
                    aoMudar = { novoValor ->
                        estadoEmail = novoValor
                        estadoEmailError= ""
                    },
                    placeholder = stringResource(R.string.digite_o_email),
                    isError = estadoEmailError.isNotEmpty()
                )
                if (estadoEmailError.isNotEmpty()) {
                    createTextKalos(
                        content = estadoEmailError,
                        sizeText = 16,
                        colorText = Color.Red,
                        bold = 500,
                        alinhamento = TextAlign.Left,
                        modifier = Modifier.padding(start = 10.dp)

                    )
                }
            }
        }

        createButtonWithFunction(textButton = stringResource(R.string.enviar_codigo), corBotao = GreenKalos ) {
            estadoEmailError = validarEmail(estadoEmail).toString()
        }



    }
}

fun validarEmail(email: String): String? {
    if (email.isEmpty()) {
        return "O campo de email não pode estar vazio"
    } else if (email.contains(" ")){
        return "O email não pode conter espaços"
    }else if (email.length < 5) {
        return "O email deve conter pelo menos 5 caracteres"
    } else if (email.length > 255) {
        return "O email excedeu o limite de 255 caracteres"
    } else if (!email.contains("@")) {
        return "O email deve conter o símbolo @"
    } else if (!email.endsWith(".com")) {
        return "O email deve terminar com a extensão .com"
    } else if (email.count { it == '@' } > 1) {
        return "O email não pode conter múltiplos símbolos @"
    } else {
        return ""
    }
}

