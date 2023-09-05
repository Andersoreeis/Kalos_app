package br.senai.sp.jandira.kalos_app.screens.telaInicialComponent.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.app_kalos.components.getLogoKalosCompleted
import br.senai.sp.jandira.kalos_app.R

@Composable
fun TelaInicial() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF464646),
                        Color(0xFF000000)
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(90.dp))
        getLogoKalosCompleted()
        Spacer(modifier = Modifier.height(40.dp))
        Box (
            modifier = Modifier
                .height(1.dp)
                .width(50.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF58B2E1),
                            Color(0xFF00F49B)
                        )
                    )
                )
        ){}
        Text(
            text = stringResource(R.string.sua_academia_no_bolso) +
                    stringResource(R.string.otimize_seus_treinos),
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(350.dp)
                .padding(top = 100.dp),
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TelaInicialPreview() {
    TelaInicial()
}