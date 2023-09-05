package br.senai.sp.jandira.kalos_app.screens.criarContaComponent.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoSenha(value: String, aoMudar: (String) -> Unit, placeholder: String) {
    var passwordVisibilityState by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value =  value,
        onValueChange = {
                        aoMudar (it)
        },
        placeholder = {
                Text(text = placeholder)
        },
        modifier = Modifier
            .background(Color.Black)
            .width(350.dp)
            ,
        trailingIcon = {
            IconButton(
                onClick = {
                    passwordVisibilityState = !passwordVisibilityState
                }
            ) {
                Icon(
                    imageVector = if(passwordVisibilityState)

                        Icons.Default.VisibilityOff
                    else
                        Icons.Default.Visibility,
                    contentDescription = ""

                )
            }
        },
        visualTransformation = if(!passwordVisibilityState)
            PasswordVisualTransformation()
        else
            VisualTransformation.None,

        shape = RoundedCornerShape(25.dp)
         )

}

//@Preview
//@Composable
//fun CampoSenhaPreview() {
//    CampoSenha("", {"" = it}, "Digite a senha")
//}