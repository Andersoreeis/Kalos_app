package br.senai.sp.jandira.kalos_app.screens.telaDetalhesProduto.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.kalos_app.R
import coil.compose.AsyncImage

@Composable
fun ImagemProduto(imagem: String) {
    Surface(
        modifier = Modifier.size(310.dp),
        shape = RoundedCornerShape(15.dp)
    ){
        AsyncImage(
            model = imagem,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize(),
            error = painterResource(id = R.drawable.treinoerro)
        )
    }

}

//@Preview
//@Composable
//fun ImagemProdutoPreview() {
//    ImagemProduto("")
//}