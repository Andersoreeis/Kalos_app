package br.senai.sp.jandira.app_kalos.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.kalos_app.R

// Função para pegar a Logo
@Composable
fun getLogoKalos(size: Dp) {
    Image(
        painterResource(id = R.drawable.logo_kalos),
        contentDescription = "logo",
        modifier = Modifier.size(size)
    )
}
// Função para pegar a Logo Junto com o nome

@Composable
fun getLogoKalosCompleted() {
    Image(
        painterResource(id = R.drawable.logo_kalos_app),
        contentDescription = "logo",
        modifier = Modifier
            .size(150.dp)
    )
    Image(
        painterResource(id = R.drawable.logo_name_kalos),
        contentDescription = "nome Kalos",
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
    )


}








@Preview
@Composable
fun LogoKalosPrev() {
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        getLogoKalosCompleted()

    }

}