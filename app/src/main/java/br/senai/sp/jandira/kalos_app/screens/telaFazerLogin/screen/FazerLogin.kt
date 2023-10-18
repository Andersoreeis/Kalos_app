package br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.LifecycleCoroutineScope

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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createButton
import br.senai.sp.jandira.app_kalos.components.createButtonWithError
import br.senai.sp.jandira.app_kalos.components.createButtonWithError2
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.app_kalos.components.createTitleKalos
import br.senai.sp.jandira.app_kalos.components.getLogoKalos
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.components.ContinueCom
import br.senai.sp.jandira.kalos_app.components.Espacamento
import br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.LoginScreeViewModel
import br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.component.CampoEmailLogin
import br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.component.CampoSenhaLogin
import br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.component.IrparaCadastro
import br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.component.esqueceuSenhaText
import br.senai.sp.jandira.kalos_app.service.AlunoService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import com.google.gson.JsonObject
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


@Composable

fun LoginScreen(navController: NavController,
                lifecycleScope: LifecycleCoroutineScope,
                viewModel: LoginScreeViewModel,
                localStorage:Storage) {
    val estadoEmail = remember { mutableStateOf("") }
    val estadoSenha = remember { mutableStateOf("") }
    val estadoErroEmail = remember { mutableStateOf("") }
    val estadoErroSenha = remember { mutableStateOf("") }
    val context = LocalContext.current

    val focusManger = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
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
                    bold = 750,
                    alinhamento = TextAlign.Left,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
            CampoEmailLogin(
                value = estadoEmail.value.toString(),
                keyboarActions = KeyboardActions(
                    onNext = { focusManger.moveFocus(focusDirection = FocusDirection.Down) }
                ), keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
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
                    bold = 750,
                    alinhamento = TextAlign.Left,
                    modifier = Modifier.padding(start = 10.dp)

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
                    navName = "esqueciSenhaEmail"
                )
            }
        }
        Espacamento(tamanho = 50.dp)

        lateinit var alunoService: AlunoService
        alunoService = RetrofitHelper.getInstance().create(AlunoService::class.java)


        var statusCarregando by remember {
            mutableStateOf(false)
        }


        createButtonWithError2(
            textButton = "Entrar",
            corBotao = GreenKalos,
            teste = statusCarregando

            ) {
            val email = estadoEmail.value
            val senha = estadoSenha.value
            val erroEmail = validarEmail(email)
            val erroSenha = validarSenha(senha)


            estadoErroEmail.value = erroEmail ?: ""
            estadoErroSenha.value = erroSenha ?: ""

            Log.e("TAG", "$erroEmail")
            Log.e("TAG", "$erroSenha")


            if (erroEmail == null && erroSenha == null) {
                statusCarregando = true
                lifecycleScope.launch {

                    val body = JsonObject().apply {
                        addProperty("email", email)
                        addProperty("senha", senha)
                    }

                    Log.e("teste", body.toString())
                    val result = alunoService.autenticarAluno(body)

                    if (result.isSuccessful) {
                        Log.e("CREAT-DATA", "${result.body()}")
                        val checagem = result.body()?.get("status")
                        val idAluno = result.body()?.get("id")
                        Log.e("id", idAluno.toString())

                        if (checagem.toString() == "401") {
                            Log.e("TAG", "Deu erro")
                            Toast.makeText(
                                context,
                                "Erro senha ou email encorretos",
                                Toast.LENGTH_SHORT
                            ).show()

                        } else {
                            Toast.makeText(context, "Sucesso", Toast.LENGTH_SHORT).show()
                            localStorage.salvarValor(context, idAluno.toString(), "idAluno")
                            navController.navigate("home")
                        }


                    } else {
                        Log.e("CREAT-DATA", result.message())
                    }


                }


            }

        }

        

        ContinueCom(navController = navController, viewModel = viewModel,localStorage, lifecycleScope)

        Espacamento(tamanho = 30.dp)

        IrparaCadastro(navController = navController)


    }
}


fun validarEmail(email: String): String? {
    if (email.isEmpty()  ) {
        return "O campo de email não pode estar vazio ou conter espaços"
    } else if(email.contains(" ")){
        return "O campo não pode conter espaços"
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
        return null
    }
}

fun validarSenha(senha: String): String? {
    if (senha.isEmpty() ) {
        return "O campo de senha não pode estar vazios"
    } else if( senha.contains(" ")){
        return "O campo não pode conter espaços"
    }else if (senha.length < 8) {
        return "A senha deve conter pelo menos 8 caracteres"
    } else if (senha.length > 12) {
        return "A senha excedeu o limite de 30 caracteres"
    } else {
        return null
    }
}










