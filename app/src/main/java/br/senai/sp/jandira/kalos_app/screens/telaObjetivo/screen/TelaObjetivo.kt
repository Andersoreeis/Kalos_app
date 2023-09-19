package br.senai.sp.jandira.kalos_app.screens.telaObjetivo.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.screens.telaObjetivo.CampoTextoObjetivos
import br.senai.sp.jandira.kalos_app.screens.telaObjetivo.components.HeaderObjetivo

@Composable
fun TelaObjetivo(navController: NavController, localStorage: Storage, objetivoState: String, objetivoStateError: String, aoMudar: (String) -> Unit) {
    val context = LocalContext.current


//    HeaderObjetivo(navController = navController )
    Spacer(modifier = Modifier.height(50.dp))
    Column {
        CampoTextoObjetivos(
            value = objetivoState ,
            texto = stringResource(R.string.texto_objetivo)  ,
            aoMudar = {
                aoMudar(it)

            },
            placeholder = "",
            isError = objetivoStateError.isNotEmpty()
        )
        if ( objetivoStateError != ""){
            androidx.compose.material3.Text(text = objetivoStateError , color = Color.Red)
        }
    }


}