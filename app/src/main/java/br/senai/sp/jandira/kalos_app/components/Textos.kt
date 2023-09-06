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
<<<<<<< HEAD
import br.senai.sp.jandira.kalos_app.R

// fonte montserrat
val montserrat = FontFamily(Font(R.font.montserrat_thin))
=======
import androidx.compose.ui.text.style.TextAlign
import br.senai.sp.jandira.kalos_app.R

>>>>>>> 1dac610d2455cc44df14d113ffdbda76fc480dcd

@Composable
// Função para criar Títulos
fun createTitleKalos(content: String, sizeText: Int, colorText: Color, bold: Int) {
    Text(
<<<<<<< HEAD
        text = content,
        fontSize = sizeText.sp,
        color = colorText,
        fontWeight = FontWeight(bold),
        fontFamily = montserrat
=======
        text = content, fontSize = sizeText.sp, color = colorText, fontWeight = FontWeight(bold),
>>>>>>> 1dac610d2455cc44df14d113ffdbda76fc480dcd
    )

}

// Função para criar Textos
@Composable
<<<<<<< HEAD
fun createTextKalos(content: String, sizeText: Int, colorText: Color, bold: Int) {
    Text(
        text = content,
        fontSize = sizeText.sp,
        color = colorText,
        fontWeight = FontWeight(bold),
        fontFamily = montserrat
    )
=======
fun createTextKalos(content: String, sizeText: Int, colorText: Color, bold: Int, alinhamento:TextAlign ) {
    Text(text = content, fontSize = sizeText.sp, color = colorText, fontWeight = FontWeight(bold), textAlign = alinhamento)

}
>>>>>>> 1dac610d2455cc44df14d113ffdbda76fc480dcd


@Preview
@Composable
fun teste() {
    createTextKalos(content = "sdfdsfdsf", sizeText = 10, colorText = Color.Red, bold = 20, alinhamento = TextAlign.Center)
}

@Preview
@Composable
fun prevteste() {

     createTextKalos(content = "tetesteeee", sizeText = 30, colorText =  Color.Black, bold = 20)


    }