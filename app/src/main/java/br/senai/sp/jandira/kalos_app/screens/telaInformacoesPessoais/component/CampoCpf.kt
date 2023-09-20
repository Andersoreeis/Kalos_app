package br.senai.sp.jandira.kalos_app.screens.telaInformacoesPessoais.component
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoCpf(value: String, aoMudar: (String) -> Unit, placeholder: String, isError: Boolean) {
    var formattedValue by remember(value) {
        mutableStateOf(formatCpf(value))
    }

    OutlinedTextField(
        value = formattedValue,
        onValueChange = { newText ->
            if (newText.length <= 11) { // Limita o usuário a 11 caracteres
                val unformattedText = newText.replace(Regex("[^\\d]"), "")
                aoMudar(unformattedText)
                formattedValue = formatCpf(unformattedText)
            }
        },
        placeholder = {
            Text(text = placeholder, color = Color(0xFF606060))
        },
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth(),
        isError = isError,
        singleLine = true,
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
        )
    )
}

private fun formatCpf(value: String): String {
    val formattedValue = StringBuilder()
    for (i in value.indices) {
        when (i) {
            3, 6 -> formattedValue.append('.')
            9 -> formattedValue.append('-')
        }
        formattedValue.append(value[i])
    }
    return formattedValue.toString()
}
