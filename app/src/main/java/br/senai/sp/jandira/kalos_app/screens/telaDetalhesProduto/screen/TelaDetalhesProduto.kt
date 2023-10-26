package br.senai.sp.jandira.kalos_app.screens.telaDetalhesProduto.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesProduto.components.ImagemProduto

@Composable
fun TelaDetalhesProduto(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_chevron_left_24),
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
                .clickable {
                    TODO()
                },
            contentDescription = null
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(16.dp)) {
                items(count = 5) {
                    ImagemProduto(
                        imagem = "https://images.unsplash.com/photo-1519160926177-c64030fde1d6?auto=format&fit=crop&q=80&w=3840&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    ImagemProduto(
                        imagem = "https://images.unsplash.com/photo-1543966357-d5fe7c4211bd?auto=format&fit=crop&q=80&w=3945&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                    )
                }
            }

        }

    }

}

@Preview
@Composable
fun TelaDetalhesProdutoPreview() {
    TelaDetalhesProduto(NavController(LocalContext.current))
}