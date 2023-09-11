package br.senai.sp.jandira.kalos_app.screens.telaSaudeLimitacoes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CamporEmail

@Composable
fun TextoCampoSaudeLimitacoes(texto: String, aoMudar: (String) -> Unit, value: String) {
    Column (
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = texto,
            fontSize = 15.sp,
            color = Color(0xFFABABAB)
        )
        Spacer(modifier = Modifier.height(5.dp))
        CamporEmail(
            value = value ,
            aoMudar = aoMudar,
            placeholder = "" )
    }
}