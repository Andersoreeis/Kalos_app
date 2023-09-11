package br.senai.sp.jandira.kalos_app.components

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.R

@Composable
fun SetaParaVoltar(navController: NavController, navName: String) {
    IconButton(

        onClick = { navController.navigate(navName) },

    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_chevron_left_24),
            contentDescription = "Botão para voltar para tela anterior",
            tint = Color.White,
            modifier = Modifier.size(40.dp)
        )
    }
}