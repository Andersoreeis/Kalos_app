package br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createButtonWithError
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.kalos_app.LocalStorage
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import br.senai.sp.jandira.kalos_app.Storage

@Composable
fun CamposCriarConta(navController: NavController, localStorage: Storage) {


    val context = LocalContext.current
    var senhaState by remember {
        mutableStateOf("")
    }


    var emailState by remember {
        mutableStateOf("")
    }

    var senhaRepetidaState by remember {
        mutableStateOf("")
    }


    var emailStateError by remember {
        mutableStateOf("")


    }
    var senhaStateError by remember {
        mutableStateOf("")
    }

    var senhaRepetidaError by remember {
        mutableStateOf("")
    }
    val focusManger = LocalFocusManager.current












    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(20.dp),


        ) {
        if (emailStateError.isNotEmpty()) {
            createTextKalos(
                content = emailStateError,
                sizeText = 16,
                colorText = Color.Red,
                bold = 150,
                alinhamento = TextAlign.Left,
                modifier = Modifier.padding(start = 10.dp)

            )
        }
        CampoEmailCadastrar(
            value = emailState.toString(),
            keyboarActions = KeyboardActions(
                onNext = { focusManger.moveFocus(focusDirection = FocusDirection.Down) }
            ), keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            aoMudar = { novoValor ->
                emailState = novoValor
                emailStateError = ""
            },
            placeholder = "Digite o email",
            isError = emailStateError.isNotEmpty()
        )
        Spacer(modifier = Modifier.height(30.dp))

        if (senhaStateError.isNotEmpty()) {
            createTextKalos(
                content = senhaStateError,
                sizeText = 16,
                colorText = Color.Red,
                bold = 150,
                alinhamento = TextAlign.Left,
                modifier = Modifier.padding(start = 10.dp)

            )
        }
        CampoSenhaCadastrar(value = senhaState.toString(),
            keyboarActions = KeyboardActions(
                onNext = { focusManger.moveFocus(focusDirection = FocusDirection.Down) }
            ), keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            aoMudar = { novoValor ->
                senhaState = novoValor
                senhaStateError = ""
            },
            placeholder = "Digite a senha",
            isError = senhaStateError.isNotEmpty()
        )
        Spacer(modifier = Modifier.height(30.dp))

        if (senhaRepetidaError.isNotEmpty()) {
            createTextKalos(
                content = senhaRepetidaError,
                sizeText = 16,
                colorText = Color.Red,
                bold = 150,
                alinhamento = TextAlign.Left,
                modifier = Modifier.padding(start = 10.dp)

            )
        }
        CampoSenhaCadastrar(value = senhaRepetidaState.toString(),
            keyboarActions = KeyboardActions(
                onNext = { focusManger.moveFocus(focusDirection = FocusDirection.Down) }
            ), keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            aoMudar = { novoValor ->
                senhaRepetidaState = novoValor
                senhaRepetidaError = ""
            },
            placeholder = "Digite a senha",
            isError = senhaRepetidaError.isNotEmpty()
        )
        Spacer(modifier = Modifier.height(30.dp))


        Spacer(modifier = Modifier.height(40.dp))

        createButtonWithError(
            textButton = stringResource(R.string.continuar),
            corBotao = GreenKalos
        ) {

            val email = emailState
            val senha = senhaState
            val senhaRepetida = senhaRepetidaState
            val erroEmail = validarEmail(email)
            val erroSenha = validarSenha(senha, senhaRepetida)




            emailStateError = validarEmail(email).toString()
            senhaStateError = validarSenha(senha, senhaRepetida).toString()
            senhaRepetidaError = validarSenha(senha, senhaRepetida).toString()

            if (erroEmail == "" && erroSenha == "") {

                navController.navigate("telaInformacoesDoCliente")
                localStorage.salvarValor(context, emailState, "email")
                localStorage.salvarValor(context, senhaState, "senha")
            } else {
                Toast.makeText(context, "Erro tente denovo", Toast.LENGTH_SHORT).show()

            }


        }


    }
}

fun validarEmail(email: String): String? {
    if (email.isEmpty()) {
        return "O campo de email não pode estar vazio"
    } else if (email.length < 5) {
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

fun validarSenha(senha: String, senhaRepetida: String): String? {
    if (senha.isEmpty() || senhaRepetida.isEmpty()) {
        return "Os campos de senha não podem estar vazios"
    } else if (senha.length < 8) {
        return "A senha deve conter pelo menos 8 caracteres"
    } else if (senha.length > 12) {
        return "A senha excedeu o limite de 30 caracteres"
    } else if (senha != senhaRepetida) {
        return "As senhas não coincidem"
    } else {
        return ""
    }
}

