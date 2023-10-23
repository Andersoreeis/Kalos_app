package br.senai.sp.jandira.kalos_app.screens.telaReservas.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.R

@Composable
fun HeaderReservas(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_chevron_left_24) ,
            contentDescription = stringResource(R.string.voltar_para_pagina_anterior),
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
                .clickable { navController.navigate("homeAcademia") }
        )
        Spacer(modifier = Modifier.width(25.dp))

        Text(
            text = stringResource(R.string.suas_reservas),
            fontSize = 24.sp,
            color = Color.White,
             fontWeight = FontWeight.Bold
        )
    }
}