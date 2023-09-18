package br.senai.sp.jandira.kalos_app.screens.telaSaudeLimitacoes.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.Storage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSaudeLimitacoes(
    localStorage: Storage,
    condicaoMedicaState: String,  condicaoMedicaStateError: String, aoMudarCondicao: (String) -> Unit,
    lesoesState: String, lesoesStateError: String, aoMudarLesoes: (String) -> Unit,
    medicamentoState: String, medicamentoStateError: String, aoMudarMedicamento: (String) -> Unit

    ) {
    val context = LocalContext.current
//    var condicaoMedicaState by remember {
//        mutableStateOf("")
//    }
//    var condicaoMedicaStateError by remember {
//        mutableStateOf("")
//    }
//    var lesoesState by remember {
//        mutableStateOf("")
//    }
//
//    var lesoesStateError by remember {
//        mutableStateOf("")
//    }
//    var medicamentoState by remember {
//        mutableStateOf("")
//    }
//   var medicamentoStateError by remember {
//        mutableStateOf("")
//    }
    Spacer(modifier = Modifier.height(50.dp))
    Column(
        modifier = Modifier
            ,
        verticalArrangement = Arrangement.Center
    ) {
        CampoTexto(
            texto = stringResource(R.string.condicao_medica),
            value = condicaoMedicaState,
            aoMudar = {
                aoMudarCondicao(it)
                      },
            placeholder = "" ,
            isError = condicaoMedicaStateError.isNotEmpty(),
        )
        if (condicaoMedicaStateError != ""){
            androidx.compose.material3.Text(text = condicaoMedicaStateError, color = Color.Red)
            }


        Spacer(modifier = Modifier.height(20.dp))

        CampoTexto(
            texto = stringResource(R.string.lesoes),
            value = lesoesState,
            aoMudar = {
                aoMudarLesoes(it)

                      },
            placeholder = "" ,
            isError = lesoesStateError.isNotEmpty(),
        )
        if ( lesoesStateError != ""){
            androidx.compose.material3.Text(text =  lesoesStateError, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(20.dp))

        CampoTexto(
            texto = stringResource(R.string.medicamentos),
            value = medicamentoState,
            aoMudar = {
                aoMudarMedicamento(it)
                      },
            placeholder = "" ,
            isError = medicamentoStateError.isNotEmpty(),
        )
        if (medicamentoStateError != ""){
            androidx.compose.material3.Text(text = medicamentoStateError, color = Color.Red)
        }


    }
}