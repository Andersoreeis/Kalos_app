package br.senai.sp.jandira.kalos_app.screens.telaObjetivo.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.screens.telaObjetivo.components.HeaderObjetivo
import br.senai.sp.jandira.kalos_app.screens.telaSaudeLimitacoes.components.TextoCampoSaudeLimitacoes

@Composable
fun TelaObjetivo(navController: NavController, localStorage: Storage) {
    val context = LocalContext.current
    var objetivoState by remember {
        mutableStateOf("")
    }

//    HeaderObjetivo(navController = navController )
    Spacer(modifier = Modifier.height(50.dp))
    TextoCampoSaudeLimitacoes(
        texto = stringResource(R.string.texto_objetivo) ,
        aoMudar = {
            objetivoState = it
            localStorage.salvarValor(context,objetivoState,"objetivo")
                  },
        value = objetivoState )
}