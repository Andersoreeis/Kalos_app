package br.senai.sp.jandira.kalos_app.screens.telaPerfil.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.model.AlunoResponse
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import coil.compose.AsyncImage

@Composable
fun HeaderPerfil(aluno: AlunoResponse) {
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
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 62.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Surface(modifier = Modifier
                .clip(shape = CircleShape)
                .size(200.dp),
                color = GreenKalos
            ){
                Image(
                    painter = painterResource(id = R.drawable.ellipse1) ,
                    contentDescription = null)
                AsyncImage(
                    model = aluno.foto,
                    contentDescription = "Foto de perfil",
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .size(200.dp)   ,
                    contentScale = ContentScale.Crop
                )
            }
        }



    }
}