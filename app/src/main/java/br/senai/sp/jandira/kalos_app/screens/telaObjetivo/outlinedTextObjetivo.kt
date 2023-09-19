package br.senai.sp.jandira.kalos_app.screens.telaObjetivo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoTextoObjetivos(
    texto: String,
    value: String,
    aoMudar: (String) -> Unit,
    placeholder: String,
    isError: Boolean,

    ) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = texto,
            fontSize = 15.sp,
            color = Color(0xFFABABAB)
        )
        Spacer(modifier = Modifier.height(5.dp))


        val errorText = remember { mutableStateOf("") }

        OutlinedTextField(
            value = value,


            onValueChange = { newValue ->

                val transformedValue = aoMudar(newValue)



                errorText.value = ""

            },
            placeholder = {
                Text(text = placeholder, color = Color(0xFF606060))
            },
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth(),
            shape = RoundedCornerShape(25.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = GreenKalos,
                containerColor = Color(0xFF393939),
                unfocusedBorderColor = Color(0xFF393939),
                focusedBorderColor = GreenKalos,
                cursorColor = GreenKalos
            ),
            isError = isError,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            singleLine = true

        )
    }
}
