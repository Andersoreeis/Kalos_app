package br.senai.sp.jandira.app_kalos.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.R

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
    funcao:  () -> Unit
) {

        Button(
            onClick = {
                funcao()

            },
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, corBotao, CircleShape)

            ,
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
    funcao:  () -> Unit
) {

    Button(
        onClick = {
            funcao()

        },
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, corBotao, CircleShape)

        ,
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        if(teste == false){
        Text(
            text = textButton,
            color = corBotao,
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )}else{
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
fun createButtonWithWidth(
    textButton: String,
    naveController: NavController,
    navName: String,
    corBotao: Color,
    width: Dp
) {
    //cores
    Button(
        onClick = { naveController.navigate(navName) },
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
fun createButtonWithWidth2(textButton: String, naveController: NavController, aoMudar: () -> Unit, corBotao: Color, width: Dp) {
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