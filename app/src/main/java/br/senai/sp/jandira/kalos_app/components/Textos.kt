package br.senai.sp.jandira.app_kalos.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.style.TextAlign
import br.senai.sp.jandira.kalos_app.R


@Composable
fun createTitleKalos(content: String, sizeText: Int, colorText: Color, bold: Int, alinhamento:TextAlign ) {
    Text(
        text = content, fontSize = sizeText.sp, color = colorText, fontWeight = FontWeight(bold), textAlign = alinhamento
    )

}

@Composable
fun createTextKalos(content: String, sizeText: Int, colorText: Color, bold: Int, alinhamento:TextAlign ) {
    Text(text = content, fontSize = sizeText.sp, color = colorText, fontWeight = FontWeight(bold), textAlign = alinhamento)

}


@Preview
@Composable
fun teste() {
    createTextKalos(content = "sdfdsfdsf", sizeText = 10, colorText = Color.Red, bold = 20, alinhamento = TextAlign.Center)
}
