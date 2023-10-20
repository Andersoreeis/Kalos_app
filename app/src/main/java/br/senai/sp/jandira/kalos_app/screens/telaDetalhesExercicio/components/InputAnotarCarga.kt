package br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputAnotarCarga(cor: String){
    val color = android.graphics.Color.parseColor(cor)
    var cargaState by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .width(360.dp)
        .height(130.dp)
        .background(Color.Black),
        verticalArrangement = Arrangement.SpaceBetween) {
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start){
            Text(
                text = "Carga:",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }

        OutlinedTextField(
            value = cargaState,
            onValueChange = {cargaState = it},
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.White,
                containerColor = Color(0xFF393939),
                unfocusedBorderColor = Color(0xFF393939),
                focusedBorderColor = GreenKalos,
                cursorColor = GreenKalos
            )
        )

        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color(color))
            ) {
                Text(
                    text = "Salvar",
                    color = if (cor.uppercase() == "#FFFFFF") Color.Black else Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
fun InputAnotarCargaPreview() {
    InputAnotarCarga("#34439E")
}