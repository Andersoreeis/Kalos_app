package br.senai.sp.jandira.kalos_app.screens.telaHome.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos

@Composable
fun BarraRetaHome() {
    Row(
        modifier = Modifier.fillMaxWidth().height(2.dp)
    ) {
        Box(modifier = Modifier
            .height(2.dp)
            .background(GrayKalos)
            .fillMaxWidth()
        )
    }
}