package br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createButtonWithError
import br.senai.sp.jandira.kalos_app.LocalStorage
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import br.senai.sp.jandira.kalos_app.Storage

@Composable
fun CamposCriarConta(navController: NavController, localStorage: Storage) {




    val context = LocalContext.current
    var senhaState by remember{
        mutableStateOf("")
    }

    var confirmarSenha by remember{
        mutableStateOf("")
    }

    var emailState by remember{
        mutableStateOf("")
    }

    var validationMessage by remember{
        mutableStateOf("")
    }







    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ){

        CamporEmail(value = emailState , aoMudar = { emailState = it}, placeholder = "Digite o Email" )
        Spacer(modifier = Modifier.height(30.dp))
        CampoSenha(senhaState , {senhaState= it}, "Digite a senha" )
        Spacer(modifier = Modifier.height(30.dp))
        CampoSenha(confirmarSenha, {confirmarSenha = it}, "Confirme a senha" )
        Spacer(modifier = Modifier.height(40.dp))

        createButtonWithError(
            textButton =stringResource(R.string.continuar)  ,
            corBotao =  GreenKalos) {
            navController.navigate("telaInformacoesDoCliente")

            localStorage.salvarValor(context, emailState, "email")
            localStorage.salvarValor(context, senhaState, "senha")

        }

//        createButtonWithWidth(
//            textButton = stringResource(R.string.continuar) ,
//            naveController = navController ,
//            navName = "telaInformacoesDoCliente",
//            corBotao = GreenKalos,
//            width = 350.dp
//        )



    }
}

@Preview(showSystemUi = true)
@Composable
fun CamposCriarContaPreview() {
    
}