package br.senai.sp.jandira.kalos_app.screens.telaInformacoesPessoais.component


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import java.time.format.TextStyle


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoDataNascimento(value: String, aoMudar: (String) -> Unit, placeholder: String, IsError: Boolean) {

    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->

                        aoMudar(newValue)
        },
        readOnly = true,
        placeholder = {
            Text(text = placeholder, color = Color(0xFF606060))
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number
        ),
        shape = RoundedCornerShape(25.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = GreenKalos,
            containerColor = Color(0xFF393939),
            unfocusedBorderColor = Color(0xFF393939),
            focusedBorderColor = GreenKalos,
            cursorColor = GreenKalos
        ),
        isError = IsError,
        textStyle = androidx.compose.ui.text.TextStyle(fontSize = 16.sp, color = Color.White),
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
    )
}

