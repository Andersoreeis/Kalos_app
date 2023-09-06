package br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun esqueceuSenhaText(
    content: String,
    sizeText: Int,
    colorText: Color,
    bold: Int,
    alinhamento: TextAlign,
    naveController: NavController,
    navName: String
) {
    Text(
        text = content,
        fontSize = sizeText.sp,
        color = colorText,
        fontWeight = FontWeight(bold),
        textAlign = alinhamento,
        modifier = Modifier
            .clickable {
                naveController.navigate(navName)
            }
            .fillMaxWidth()
    )

}


