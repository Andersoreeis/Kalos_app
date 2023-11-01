package br.senai.sp.jandira.app_kalos.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun createButton(
    textButton: String,
    naveController: NavController,
    navName: String,
    corBotao: Color
) {
    //cores
    Button(
        onClick = { naveController.navigate(navName) },
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, corBotao, CircleShape),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Text(
            text = textButton,
            color = corBotao,
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
    }
}

@Composable

fun createButtonWithError(
    textButton: String,
    corBotao: Color,
    funcao: () -> Unit
) {

    Button(
        onClick = {
            funcao()

        },
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, corBotao, CircleShape),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Text(
            text = textButton,
            color = corBotao,
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
    }


}

@Composable

fun createButtonWithError2(
    textButton: String,
    corBotao: Color,
    teste: Boolean,
    funcao: () -> Unit
) {

    Button(
        onClick = {
            funcao()

        },
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, corBotao, CircleShape),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        if (teste == false) {
            Text(
                text = textButton,
                color = corBotao,
                fontSize = 20.sp,
                fontWeight = FontWeight(400)
            )
        } else {
            CircularProgressIndicator(
                modifier = Modifier.width(32.dp),
                color = MaterialTheme.colorScheme.surfaceVariant
            )
        }
    }


}

@Composable
fun createButtonWithFunction(
    textButton: String,
    corBotao: Color,
    funcao: () -> Unit
) {
    // Cores
    Button(
        onClick = {
            funcao()
        },
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, corBotao, CircleShape),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Text(
            text = textButton,
            color = corBotao,
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
    }
}

@Composable
fun createButtonWithFunction4(
    textButton: String,
    corBotao: Color,
    funcao: () -> Unit
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(27.dp)
            .border(1.dp, corBotao, CircleShape)
            .background(Color.Black)
            .clickable { funcao() },
        color = Color.Black
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = textButton,
                color = corBotao,
                fontSize = 15.sp,
                fontWeight = FontWeight(400)
            )
        }

    }

}


@Composable
fun createButtonWithWidth(
    textButton: String,
    corBotao: Color,
    width: Dp,
    funcao: () -> Unit
) {
    //cores
    Button(
        onClick = { funcao() },
        modifier = Modifier
            .width(width)
            .border(1.dp, corBotao, CircleShape),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Text(
            text = textButton,
            color = corBotao,
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
    }
}

@Composable
fun createButtonWithWidth2(
    textButton: String,
    naveController: NavController,
    aoMudar: () -> Unit,
    corBotao: Color,
    width: Dp
) {
    //cores
    Button(
        onClick = { aoMudar() },
        modifier = Modifier
            .width(width)
            .border(1.dp, corBotao, CircleShape),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Text(
            text = textButton,
            color = corBotao,
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
    }
}


@Preview
@Composable
fun botaoPreview() {
}