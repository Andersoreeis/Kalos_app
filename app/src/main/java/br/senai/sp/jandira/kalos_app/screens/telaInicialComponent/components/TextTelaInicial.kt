package br.senai.sp.jandira.kalos_app.screens.telaInicialComponent.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.R

@Composable
fun TextTelaInicial() {
    val montserrat = FontFamily(Font(R.font.montserrat_thin))
    Text(
        text = stringResource(R.string.sua_academia_no_bolso) +
                stringResource(R.string.otimize_seus_treinos),
        color = Color.White,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(350.dp)
            .padding(top = 60.dp),
        fontSize = 16.sp,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal


        )
}