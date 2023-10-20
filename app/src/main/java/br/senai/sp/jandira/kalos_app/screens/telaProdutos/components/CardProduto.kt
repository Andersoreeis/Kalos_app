package br.senai.sp.jandira.kalos_app.screens.telaProdutos.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalosEscuro
import coil.compose.AsyncImage

@Composable
fun CardProduto() {
    Surface (
        modifier = Modifier
            .height(260.dp)
            .width(180.dp),
        color = GrayKalosEscuro,
        shape = RoundedCornerShape(20.dp),

    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(6.dp))
            Surface(
                modifier = Modifier.size(170.dp),
                shape = RoundedCornerShape(15.dp)
            ) {
                AsyncImage(
                    model =  "",
                    contentDescription = "Foto do produto",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    error = painterResource(id = R.drawable.produto)
                )
            }
        }

    }
}

@Preview
@Composable
fun CardPreview() {
    CardProduto()
}