package br.senai.sp.jandira.kalos_app.screens.InformacoesCliente.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.components.BarraProgresso

@Composable
fun TelasInformacoesdoCliente(navController: NavController, classe: Storage, lifecycleCoroutineScope: LifecycleCoroutineScope) {
    BarraProgresso(navController, classe, lifecycleCoroutineScope)
}