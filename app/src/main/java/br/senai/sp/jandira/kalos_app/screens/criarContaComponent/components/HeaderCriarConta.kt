package br.senai.sp.jandira.kalos_app.screens.criarContaComponent.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.app_kalos.components.getLogoKalos
import br.senai.sp.jandira.kalos_app.R

@Composable
fun HeaderCriarConta() {
    Column (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        getLogoKalos(size = 80.dp)

        Text(
            text = "Criar conta",
            color = Color.White,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Seja bem vindo!",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 10.dp)
        )


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HeaderCriarContaPreview() {
    HeaderCriarConta()
}