package br.senai.sp.jandira.kalos_app.screens.criarContaComponent.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.app_kalos.components.getLogoKalos
import br.senai.sp.jandira.kalos_app.R

@Composable
fun HeaderCriarConta() {
    Column (
        modifier = Modifier.fillMaxWidth()
    ) {
        getLogoKalos(size = 80.dp)




    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HeaderCriarContaPreview() {
    HeaderCriarConta()
}