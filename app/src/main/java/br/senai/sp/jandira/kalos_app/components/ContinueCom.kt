package br.senai.sp.jandira.kalos_app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Brush
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

    val degradeLeft = Brush.horizontalGradient(
        colors = listOf(Color(0xFF000000), Color(0xFF00FE90
        )) // Cores do degradê
    )

    val degradeRight = Brush.horizontalGradient(
        colors = listOf(Color(0xFF00FE90), Color(0xFF000000
        )) // Cores do degradê
    )


    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

    }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween, Alignment.CenterVertically,
        ) {
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(brush = degradeLeft)
            )

            Text(
                text = stringResource(R.string.ou_continue_com),
                color = Color.White,
                fontSize = 12.sp, modifier = Modifier.padding(10.dp)
            )

            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(brush = degradeRight)
            )
        
    }



Spacer(modifier = Modifier.height(20.dp))

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
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