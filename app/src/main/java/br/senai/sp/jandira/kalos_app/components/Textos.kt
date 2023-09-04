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

@Composable
fun createTitleKalos(content: String, sizeText: Int, colorText: Color, bold: Int) {
    Text(
        text = content, fontSize = sizeText.sp, color = colorText, fontWeight = FontWeight(bold)
    )

}

@Composable
fun createTextKalos(content: String, sizeText: Int, colorText: Color, bold: Int) {
    Text(text = content, fontSize = sizeText.sp, color = colorText, fontWeight = FontWeight(bold))

}
