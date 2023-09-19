package br.senai.sp.jandira.kalos_app.screens.telaMetricas.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun TextoCampoPeso(texto: String) {
    Column (
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = texto,
            fontSize = 15.sp,
            color = Color(0xFFABABAB)
        )
        Spacer(modifier = Modifier.height(5.dp))
//        CamporEmail(
//            value = value ,
//            aoMudar = aoMudar,
//            placeholder = "" )
//    }
    }}