package br.senai.sp.jandira.kalos_app.screens.telaBuscarAcademias.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.service.AcademiaService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController

import br.senai.sp.jandira.app_kalos.components.getLogoKalos
import br.senai.sp.jandira.kalos_app.LocalStorage
import br.senai.sp.jandira.kalos_app.Storage

import br.senai.sp.jandira.kalos_app.components.Espacamento
import br.senai.sp.jandira.kalos_app.model.AcademiaResponse
//import br.senai.sp.jandira.kalos_app.model.Tag
import br.senai.sp.jandira.kalos_app.screens.telaBuscarAcademias.components.AcademiaCard
import br.senai.sp.jandira.kalos_app.screens.telaBuscarAcademias.components.CampoPesquisa


import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuscarAcademias(
    lifecycleScope: LifecycleCoroutineScope,
    navController: NavController,
    localStorage: Storage
) {

    val context = LocalContext.current



    val academiaService = RetrofitHelper.getInstance().create(AcademiaService::class.java)
    val estadoAcademia = remember { mutableStateOf("") }
    val estadoTodasAcademias = remember { mutableStateOf(emptyList<AcademiaResponse>()) }
    val academiaEncontrada = remember { mutableStateOf(true) }
    val buscandoAcademias = remember { mutableStateOf(false) }


    // Função para buscar academias por nome
    suspend fun buscarAcademiasPorNome(nome: String): List<AcademiaResponse> {
        val result = academiaService.getAlunoByNome(nome)
        if (result.isSuccessful) {
            val response = result.body()
            if (response != null) {
                val academias: List<AcademiaResponse>? = response.data
                if (academias != null) {
                    academiaEncontrada.value = true
                    estadoTodasAcademias.value = academias
                    return estadoTodasAcademias.value


                }
            }
        } else {
            Log.e("GETTING-DATA", "Erro ao buscar academias: ${result.message()}")
            academiaEncontrada.value = false

        }


        return emptyList()
    }

    // Função para buscar todas as academias
    suspend fun buscarTodasAcademias(): List<AcademiaResponse> {
        var paginaPrincial = 1
        val result = academiaService.getAcademia(page = paginaPrincial.toString())
        if (result.isSuccessful) {
            val response = result.body()
            if (response != null) {
                val academias: List<AcademiaResponse>? = response.data
                if (academias != null) {
                    return academias
                }
            } else {
                Log.e("GETTING-DATA", "Erro ao buscar academias: ${result.message()}")
            }
        }

        return emptyList()
    }


    suspend fun buscarAcademias() {
        buscandoAcademias.value = true

        val nome = estadoAcademia.value
        val academias: List<AcademiaResponse> = if (nome.isNotEmpty()) {
            // academiaEncontrada.value = true

            buscarAcademiasPorNome(nome)

        } else {
            // academiaEncontrada.value = true
            buscarTodasAcademias()

        }
        buscandoAcademias.value = false
        estadoTodasAcademias.value = academias
    }

    LaunchedEffect(key1 = true) {
        buscarAcademias()
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)

    ) {
        getLogoKalos(size = 70.dp)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Gray)
        )

        Espacamento(tamanho = 20.dp)

        Column(modifier = Modifier.fillMaxWidth()) {
            CampoPesquisa(
                estadoValue = estadoAcademia.value,
                aoMudar = { estadoAcademia.value = it },
                funcao = {
                    lifecycleScope.launch {
                        buscarAcademias()
                    }
                },
                lifecycleScope = lifecycleScope
            )

            Espacamento(tamanho = 40.dp)

            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.height(20.dp))
                        if (buscandoAcademias.value) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(60.dp),
                                    color = Color.White,
                                    strokeWidth = 5.dp
                                )
                            }

                        } else if (!academiaEncontrada.value) {

                            Text(
                                text = "Academia não encontrada",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 16.dp),
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp,
                                color = Color.White
                            )
                        } else {
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .background(Color.Black)
                            ) {
                                items(estadoTodasAcademias.value) { academia ->

                                    fun pegarNomeTags(academia: AcademiaResponse): String {
                                        val tagsList = academia.tags
                                        val nomesTags = mutableListOf<String>()

                                        tagsList?.forEach { tag ->
                                            val nomeTag = tag.nome_tags
                                            if (nomeTag != null && nomeTag.isNotEmpty()) {
                                                nomesTags.add(nomeTag)
                                            }
                                        }

                                        return nomesTags.joinToString(", ")
                                    }




                                    AcademiaCard(
                                        academia = academia,
                                        onClick = {
                                            navController.navigate("perfilAcademia");

                                            localStorage.salvarValor(context, "${academia.nome}", "nomeAcademia");
                                            Log.e("Valor nomeAcademia", "${academia.nome}");

                                            localStorage.salvarValor(context, "${academia.telefone}", "telefoneAcademia");
                                            Log.e("Valor telefoneAcademia", "${academia.telefone}");

                                            localStorage.salvarValor(context, "${academia.email}", "emailAcademia");
                                            Log.e("Valor emailAcademia", "${academia.email}");

                                            localStorage.salvarValor(context, "${academia.instagram}", "instagramAcademia");
                                            Log.e("Valor instagramAcademia", "${academia.instagram}");

                                            localStorage.salvarValor(context, "${academia.facebook}", "facebookAcademia");
                                            Log.e("Valor facebookAcademia", "${academia.facebook}");

                                            localStorage.salvarValor(context, "${academia.whatsapp}", "whatsappAcademia");
                                            Log.e("Valor whatsappAcademia", "${academia.whatsapp}");

                                            localStorage.salvarValor(context, "${academia.foto}", "fotoAcademia");
                                            Log.e("Valor fotoAcademia", "${academia.foto}");

                                            localStorage.salvarValor(context, "${academia.descricao}", "descricaoAcademia");
                                            Log.e("Valor descricaoAcademia", "${academia.descricao}");

                                            localStorage.salvarValor(context, "${academia.cor_primaria}", "corPrimariaAcademia");
                                            Log.e("Valor corPrimariaAcademia", "${academia.cor_primaria}");

                                            localStorage.salvarValor(context, "${academia.cor_secundaria}", "corSegundariaAcademia");
                                            Log.e("Valor corSegundariaAcademia", "${academia.cor_secundaria}");

                                            localStorage.salvarValor(context, "${academia.foto}", "fotoAcademia");
                                            Log.e("Valor fotoAcademia (repetido)", "${academia.foto}");

                                            localStorage.salvarValor(context, "${academia.logradouro}", "logradouroAcademia");
                                            Log.e("Valor logradouro", "${academia.logradouro}");

                                            localStorage.salvarValor(context, "${academia.numero_endereco}", "numeroAcademia");
                                            Log.e("Valor numero endereço", "${academia.numero_endereco}");

                                            localStorage.salvarValor(context, pegarNomeTags(academia).toString(), "tagsAcademia");
                                            Log.e("Valor tagsAcademia", pegarNomeTags(academia).toString());


                                        }
                                    )
                                    Espacamento(tamanho = 20.dp)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
