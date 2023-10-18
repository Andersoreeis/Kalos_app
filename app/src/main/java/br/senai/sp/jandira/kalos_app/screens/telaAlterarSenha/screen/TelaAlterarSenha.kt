package br.senai.sp.jandira.kalos_app.screens.telaAlterarSenha.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createButtonWithError2
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CampoSenhaCadastrar
import br.senai.sp.jandira.kalos_app.service.AlunoService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

@Composable
fun TelaAlterarSenha(
    navController: NavController,
    lifecycleCoroutineScope: LifecycleCoroutineScope,
    localStorage: Storage
) {
    val context = LocalContext.current
    var senhaAtual = localStorage.lerValor(context, "senhaAlunoAlt")
    var email = localStorage.lerValor(context, "emailAluno")
    var senhaAtualState by remember {
        mutableStateOf("")
    }
    var senhaAtualStateError by remember {
        mutableStateOf("")
    }
    var senhaNovaState by remember {
        mutableStateOf("")
    }
    var senhaNovaStateError by remember {
        mutableStateOf("")
    }
    var confirmarState by remember {
        mutableStateOf("")
    }
    var confirmarStateError by remember {
        mutableStateOf("")
    }
    val focusManger = LocalFocusManager.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = { navController.navigate("editarPerfil") }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_chevron_left_24),
                    contentDescription = stringResource(R.string.botao_para_voltar_para_tela_de_home),
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }
            Text(
                text = stringResource(id = R.string.alterar_senha),
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(80.dp))



        Text(
            text = "Digite sua senha atual",
            color = GrayKalos,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        CampoSenhaCadastrar(value = senhaAtualState.toString(),
            keyboarActions = KeyboardActions(
                onNext = { focusManger.moveFocus(focusDirection = FocusDirection.Down) }
            ), keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            aoMudar = { novoValor ->
                senhaAtualState = novoValor
                senhaAtualStateError = ""
            },
            placeholder = "",
            isError = senhaAtualStateError.isNotEmpty()
        )
        if (senhaAtualStateError.isNotEmpty()) {
            createTextKalos(
                content = senhaAtualStateError,
                sizeText = 16,
                colorText = Color.Red,
                bold = 500,
                alinhamento = TextAlign.Left,
                modifier = Modifier.padding(start = 10.dp)

            )
        }
        Spacer(modifier = Modifier.height(30.dp))


        Text(
            text = "Digite a nova senha",
            color = GrayKalos,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        CampoSenhaCadastrar(value = senhaNovaState.toString(),
            keyboarActions = KeyboardActions(
                onNext = { focusManger.moveFocus(focusDirection = FocusDirection.Down) }
            ), keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            aoMudar = { novoValor ->
                senhaNovaState = novoValor
                senhaNovaStateError = ""
            },
            placeholder = "",
            isError = senhaNovaStateError.isNotEmpty()
        )
        if (senhaNovaStateError.isNotEmpty()) {
            createTextKalos(
                content = senhaNovaStateError,
                sizeText = 16,
                colorText = Color.Red,
                bold = 500,
                alinhamento = TextAlign.Left,
                modifier = Modifier.padding(start = 10.dp)

            )
        }
        Spacer(modifier = Modifier.height(30.dp))



        Text(
            text = "Confirme nova senha",
            color = GrayKalos,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        CampoSenhaCadastrar(value = confirmarState.toString(),
            keyboarActions = KeyboardActions(
                onNext = { focusManger.moveFocus(focusDirection = FocusDirection.Down) }
            ), keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            aoMudar = { novoValor ->
                confirmarState = novoValor
                confirmarStateError = ""
            },
            placeholder = "",
            isError = confirmarStateError.isNotEmpty()
        )
        if (senhaNovaStateError.isNotEmpty()) {
            createTextKalos(
                content = senhaNovaStateError,
                sizeText = 16,
                colorText = Color.Red,
                bold = 500,
                alinhamento = TextAlign.Left,
                modifier = Modifier.padding(start = 10.dp)

            )
        }
        Spacer(modifier = Modifier.height(200.dp))

        createButtonWithError2(
            textButton = "Salvar",
            corBotao = GreenKalos ,
            teste = false
        ) {
            senhaNovaStateError = validarSenha(
                senhaAtualState.toString(),
                senhaNovaState,
                confirmarState,
                senhaAtual.toString())
            senhaAtualStateError = validarSenha2(
                senhaAtualState.toString(),
                senhaAtual.toString())
            confirmarStateError = validarSenha(
                senhaAtualState.toString(),
                senhaNovaState,
                confirmarState,
                senhaAtual.toString())
            lateinit var alunoService: AlunoService
            alunoService = RetrofitHelper.getInstance().create(AlunoService::class.java)

            if(senhaNovaStateError == "" && senhaAtualStateError == "" && confirmarStateError == ""){
                lifecycleCoroutineScope.launch {
                    val body = JsonObject().apply {
                        addProperty("email", email)
                        addProperty("senha", senhaNovaState)
                    }

                    val result = alunoService.atualizarSenhaAluno(body)

                    if(result.isSuccessful){
                        Toast.makeText(context, "Senha atualizada", Toast.LENGTH_SHORT).show()
                        navController.navigate("editarPerfil")
                    }else{
                        Toast.makeText(context, "ERRO", Toast.LENGTH_SHORT).show()
                        Log.e("CREAT-DATA", "${result.body()}")
                    }
                }
            }


        }
        Spacer(modifier = Modifier.height(15.dp))

        createButtonWithError2(
            textButton = "Cancelar",
            corBotao = Color.Red,
            teste = false ) {
                navController.navigate("editarPerfil")
        }

    }
}

fun validarSenha(senhaAtual: String, senhaNova: String, confirmarSenha: String, senha: String): String {
    if ( senhaNova.isEmpty() || confirmarSenha.isEmpty()) {
        return "Os campos de senha não podem estar vazios"
    } else if (senhaNova.length < 8) {
        return "A senha deve conter pelo menos 8 caracteres"
    } else if (senhaNova.length > 12) {
        return "A senha excedeu o limite de 12 caracteres"
    } else if (senhaNova != confirmarSenha) {
        return "As senhas não coincidem"
    } else {
        return ""
    }
}

fun validarSenha2(senhaAtual: String,  senha: String): String {
    if (senhaAtual.isEmpty() ) {
        return "Os campos de senha não podem estar vazios"
    } else if(senhaAtual != senha){
        return  "A senha atual está incorreta"
    } else {
        return ""
    }
}