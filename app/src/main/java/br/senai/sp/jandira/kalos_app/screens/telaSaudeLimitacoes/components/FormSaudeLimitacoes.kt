package br.senai.sp.jandira.kalos_app.screens.telaSaudeLimitacoes.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CamporEmail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSaudeLimitacoes() {
    var condicaoMedicaState by remember {
        mutableStateOf("")
    }
    var lesoesState by remember {
        mutableStateOf("")
    }
    var medicamentoState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            ,
        verticalArrangement = Arrangement.Center
    ) {
        TextoCampoSaudeLimitacoes(
            texto = stringResource(R.string.condicao_medica),
            aoMudar = { condicaoMedicaState = it },
            value = condicaoMedicaState
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextoCampoSaudeLimitacoes(
            texto = stringResource(R.string.lesoes),
            aoMudar = { lesoesState = it },
            value = lesoesState
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextoCampoSaudeLimitacoes(
            texto = stringResource(R.string.medicamentos),
            aoMudar = { medicamentoState = it },
            value = medicamentoState
        )
    }
}