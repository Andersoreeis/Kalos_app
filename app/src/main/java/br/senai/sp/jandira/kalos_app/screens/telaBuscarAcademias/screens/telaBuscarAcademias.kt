package br.senai.sp.jandira.kalos_app.screens.telaBuscarAcademias.screens

import android.util.Log
import androidx.compose.runtime.Composable
import br.senai.sp.jandira.kalos_app.service.AcademiaService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import androidx.lifecycle.LifecycleCoroutineScope
import br.senai.sp.jandira.kalos_app.model.AcademiaResponse
import br.senai.sp.jandira.kalos_app.model.BaseResponseAcademia
import kotlinx.coroutines.launch

@Composable
fun BuscarAcademias(lifecycleScope: LifecycleCoroutineScope) {

    val academiaService = RetrofitHelper.getInstance().create(AcademiaService::class.java)

    // Função para buscar academias por nome
    fun buscarAcademiasPorNome(nome: String) {
        lifecycleScope.launch {
            val result = academiaService.getAlunoByNome(nome)
            if (result.isSuccessful) {
                val response = result.body()
                if (response != null) {
                    val academias: List<AcademiaResponse>? = response.data
                    if (academias != null) {
                        for (academia in academias) {
                            Log.i("GETTING-DATA", "Nome da academia: ${academia}")
                        }
                    }
                }
            } else {
                Log.e("GETTING-DATA", "Erro ao buscar academias: ${result.message()}")
            }
        }
    }

    buscarAcademiasPorNome("Yasmin fit")
}
