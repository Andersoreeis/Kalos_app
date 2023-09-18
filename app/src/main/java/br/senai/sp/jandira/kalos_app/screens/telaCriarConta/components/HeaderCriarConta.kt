package br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.getLogoKalos
import br.senai.sp.jandira.kalos_app.R

@Composable
fun HeaderCriarConta(navController: NavController) {


    Column (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box() {
            getLogoKalos(size = 80.dp)
            IconButton(

                onClick = { navController.navigate("fazerLogin") },
                modifier = Modifier.offset(x= -170.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_chevron_left_24),
                    contentDescription = "Botão para voltar para tela anterior",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }
        }


            Text(
                text = stringResource(id = R.string.criar_conta) ,
                color = Color.White,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = stringResource(R.string.seja_bem_vindo),
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 10.dp)
            )


        }
    }

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun HeaderCriarContaPreview() {
//    HeaderCriarConta()
//}