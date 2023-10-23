package br.senai.sp.jandira.kalos_app.screens.telaProdutos.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.R

@Composable
fun BotaoReservas(corPrimariaAcademia: String, navController: NavController) {
    val corPrimaria = Color(android.graphics.Color.parseColor(corPrimariaAcademia ?: "#353535"))

    Surface(
        shape = RoundedCornerShape(10.dp),
        color = Color.Black,
        border = BorderStroke(1.dp, corPrimaria),
        modifier = Modifier.clickable {
            navController.navigate("reservas")
        }

    ) {
        Text(
            text = stringResource(R.string.reservas),
            color = corPrimaria,
            modifier = Modifier.padding(10.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }

}