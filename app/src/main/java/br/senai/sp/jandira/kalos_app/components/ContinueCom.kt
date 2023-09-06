package br.senai.sp.jandira.kalos_app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos

@Composable
fun ContinueCom() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Surface (
            modifier = Modifier
                .width(90.dp)
                .height(1.dp),
            color = GreenKalos
        ){}
        Text(
            text = stringResource(R.string.ou_continue_com),
            color = Color.White,
            fontSize = 12.sp
        )
        Surface (
            modifier = Modifier
                .width(90.dp)
                .height(1.dp),
            color = GreenKalos
        ){}
    }
    Spacer(modifier = Modifier.height(30.dp))

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Image(
                painter = painterResource(id = R.drawable.facebook) ,
                contentDescription = "Imagem do Google",
                modifier = Modifier.size(30.dp)
                )
        }
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Image(
                painter = painterResource(id = R.drawable.google) ,
                contentDescription = "Imagem do Facebook",
                modifier = Modifier.size(30.dp))
        }
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Image(
                painter = painterResource(id = R.drawable.apple) ,
                contentDescription = "Imagem da Apple",
                modifier = Modifier.size(30.dp))
        }
    }
}

@Preview
@Composable
fun ContinueComPreview() {
    ContinueCom()
}