package br.senai.sp.jandira.kalos_app.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun Espacamento(tamanho: Dp) {
    Spacer(modifier = Modifier.height(tamanho))
}