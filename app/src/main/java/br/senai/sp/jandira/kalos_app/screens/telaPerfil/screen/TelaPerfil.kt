package br.senai.sp.jandira.kalos_app.screens.telaPerfil.screen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.model.AlunoResponse
import br.senai.sp.jandira.kalos_app.screens.telaHome.components.BarraRetaHome
import br.senai.sp.jandira.kalos_app.screens.telaPerfil.components.ConfirmacaoDeslogarDialog
import br.senai.sp.jandira.kalos_app.screens.telaPerfil.components.HeaderPerfil
import br.senai.sp.jandira.kalos_app.screens.telaPerfil.components.MedidasPerfil
import br.senai.sp.jandira.kalos_app.screens.telaPerfil.components.NomeCodigoPerfil
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TelaPerfil(aluno: AlunoResponse, navController: NavController, localStorage: Storage) {

    var exibirDialog = remember { mutableStateOf(false) }

    Log.i("valor dialog", "${exibirDialog}")

    if(exibirDialog.value){
        Box(modifier = Modifier.fillMaxSize().clickable { exibirDialog.value = false }){
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                HeaderPerfil(aluno = aluno, navController, exibirDialog)

                Spacer(modifier = Modifier.height(10.dp))


                NomeCodigoPerfil(aluno = aluno)
                Spacer(modifier = Modifier.height(16.dp))
                MedidasPerfil(aluno = aluno)

            }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(16, 16, 16, 210)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ConfirmacaoDeslogarDialog(
                    exibirDialog = exibirDialog.value,
                    onClose = {
                        exibirDialog.value = false
                    },
                    onConfirm = {
                        exibirDialog.value = false


                    },
                    localStorage,
                    navController
                )
            }

        }



    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ConfirmacaoDeslogarDialog(
                exibirDialog = exibirDialog.value,
                onClose = {
                    exibirDialog.value = false
                },
                onConfirm = {
                    exibirDialog.value = false


                },
                localStorage,
                navController
            )
            HeaderPerfil(aluno = aluno, navController, exibirDialog)

            Spacer(modifier = Modifier.height(10.dp))


            NomeCodigoPerfil(aluno = aluno)
            Spacer(modifier = Modifier.height(16.dp))
            MedidasPerfil(aluno = aluno)

        }
    }

}

