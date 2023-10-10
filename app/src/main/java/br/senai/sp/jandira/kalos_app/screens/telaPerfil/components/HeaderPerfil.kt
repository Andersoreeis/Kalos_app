package br.senai.sp.jandira.kalos_app.screens.telaPerfil.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.components.Espacamento
import br.senai.sp.jandira.kalos_app.model.AlunoResponse
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import coil.compose.AsyncImage

@Composable
fun HeaderPerfil(aluno: AlunoResponse, navController: NavController, exibirDialog: MutableState<Boolean>) {




    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(262.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(186.dp)
                .clip(RoundedCornerShape(0.dp, 0.dp, 50.dp, 50.dp)),
            color = GrayKalos,
        ) {}
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 62.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(200.dp),
                color = GreenKalos
            ) {
                AsyncImage(
                    model = aluno.foto,
                    contentDescription = "Foto de perfil",
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .size(200.dp),
                    contentScale = ContentScale.Crop,
                    error = painterResource(id = R.drawable.ellipse1)
                )
            }
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Surface(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape),
                color = Color.White
            ) {
                IconButton(
                    modifier = Modifier.background(GreenKalos),
                    onClick = {
                        navController.navigate("editarPerfil")
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_create_24),
                        contentDescription = stringResource(R.string.editar),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.width(5.dp))
            Surface(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape),
                color = Color.White
            ) {
                IconButton(
                    modifier = Modifier.background(GreenKalos),
                    onClick = {
                        exibirDialog.value = true
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_person_off_24),
                        contentDescription = stringResource(R.string.editar),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}