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
import br.senai.sp.jandira.kalos_app.R

// fonte montserrat
val montserrat = FontFamily(Font(R.font.montserrat_thin))

@Composable
// Função para criar Títulos
fun createTitleKalos(content: String, sizeText: Int, colorText: Color, bold: Int) {
    Text(
        text = content,
        fontSize = sizeText.sp,
        color = colorText,
        fontWeight = FontWeight(bold),
        fontFamily = montserrat
    )

}

// Função para criar Textos
@Composable
fun createTextKalos(content: String, sizeText: Int, colorText: Color, bold: Int) {
    Text(
        text = content,
        fontSize = sizeText.sp,
        color = colorText,
        fontWeight = FontWeight(bold),
        fontFamily = montserrat
    )

}

@Preview
@Composable
fun prevteste() {

     createTextKalos(content = "tetesteeee", sizeText = 30, colorText =  Color.Black, bold = 20)


    }