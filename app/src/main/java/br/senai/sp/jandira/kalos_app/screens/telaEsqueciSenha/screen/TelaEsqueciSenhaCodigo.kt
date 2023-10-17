package br.senai.sp.jandira.kalos_app.screens.telaEsqueciSenha.screen

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createButtonWithError
import br.senai.sp.jandira.app_kalos.components.createButtonWithError2
import br.senai.sp.jandira.app_kalos.components.createButtonWithFunction
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.app_kalos.components.getLogoKalos
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CampoCodigo
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CampoEmailCadastrar2
import br.senai.sp.jandira.kalos_app.service.AlunoService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaEsqueciSenhaCodigo(
    navController: NavController,
    lifecycleCoroutineScope: LifecycleCoroutineScope,
    localStorage: Storage
) {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    var codigo1 by remember { mutableStateOf("") }
    var codigo2 by remember { mutableStateOf("") }
    var codigo3 by remember { mutableStateOf("") }
    var codigo4 by remember { mutableStateOf("") }
    var codigo5 by remember { mutableStateOf("") }

    var error by remember {
        mutableStateOf(false)
    }
    val email = localStorage.lerValor(context, "emailEsqueciSenha")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            getLogoKalos(size = 150.dp)
            Text(
                text = stringResource(R.string.esqueci_a_senha),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Digite o código de recuperação enviado para: ",
                color = Color.White,
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )

            Text(
                text = email.toString(),
                color = GreenKalos,
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(70.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CampoCodigo(
                    value = codigo1,
                    aoMudar = {
                        codigo1 = it.take(1)
                        if (it.length > 1) {
                            focusManager.moveFocus(FocusDirection.Next)
                        }
                    },
                    isError = false)
                CampoCodigo(
                    value = codigo2,
                    aoMudar = {
                        codigo2 = it.take(1)
                        if (it.length > 1) {
                            focusManager.moveFocus(FocusDirection.Next)
                        }
                    },
                    isError = false)
                CampoCodigo(
                    value = codigo3,
                    aoMudar = {
                        codigo3 = it.take(1)
                        if (it.length > 1) {
                            focusManager.moveFocus(FocusDirection.Next)
                        }
                    },
                    isError = false)
                CampoCodigo(
                    value = codigo4,
                    aoMudar = {
                        codigo4 = it.take(1)
                        if (it.length > 1) {
                            focusManager.moveFocus(FocusDirection.Next)
                        }
                    },
                    isError = false)
                CampoCodigo(
                    value = codigo5,
                    aoMudar = {
                        codigo5 = it.take(1)
                        if (it.length > 1) {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    },
                    isError = false)

            }
            if (error) {
                Text(
                    text = "Preencha todos os campos antes de verificar",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color.Red,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
        var statusCarregando by remember {
            mutableStateOf(false)
        }

        createButtonWithError2(
            textButton = stringResource(R.string.verificar),
            corBotao = GreenKalos,
            statusCarregando
        ) {
            lateinit var alunoService: AlunoService
            alunoService = RetrofitHelper.getInstance().create(AlunoService::class.java)

            if (codigo1 != "" && codigo2 != "" && codigo3 != "" && codigo4 != "" && codigo5 != "" ) {
                error = false
                val codigo = "${codigo1}${codigo2}${codigo3}${codigo4}${codigo5}"
                lifecycleCoroutineScope.launch {
                    val body = JsonObject().apply {
                        addProperty("email", email)
                        addProperty("token", codigo)
                    }
                    val result = alunoService.enviarCodigo(body)
                    if(result.isSuccessful){
                        navController.navigate("esqueciSenhaNovaSenha")
                    }else{
                        Toast.makeText(context, "Código inválido", Toast.LENGTH_SHORT).show()
                    }
                }

            } else {
                error = true
            }
        }


    }
}