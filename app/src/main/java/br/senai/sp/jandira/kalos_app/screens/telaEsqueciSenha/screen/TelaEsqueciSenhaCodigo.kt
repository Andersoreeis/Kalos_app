package br.senai.sp.jandira.kalos_app.screens.telaEsqueciSenha.screen

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.app_kalos.components.createButtonWithFunction
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.app_kalos.components.getLogoKalos
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CampoCodigo
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CampoEmailCadastrar2
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaEsqueciSenhaCodigo() {
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
                text = "Digite o código de recuperação enviado para: ",
                color = Color.White,
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Email.example@.com",
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
                    value = "" ,
                    aoMudar = { } ,
                    isError = false)
                CampoCodigo(
                    value = "" ,
                    aoMudar = { } ,
                    isError = false)
                CampoCodigo(
                    value = "" ,
                    aoMudar = { } ,
                    isError = false)
                CampoCodigo(
                    value = "" ,
                    aoMudar = { } ,
                    isError = false)
            }
        }

        createButtonWithFunction(textButton = stringResource(R.string.verificar), corBotao = GreenKalos ) {

        }



    }
}