package br.senai.sp.jandira.kalos_app.screens.telaBuscarAcademias.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.service.AcademiaService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import androidx.lifecycle.LifecycleCoroutineScope
import br.senai.sp.jandira.app_kalos.components.getLogoKalos
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.components.Espacamento
import br.senai.sp.jandira.kalos_app.model.AcademiaResponse
import br.senai.sp.jandira.kalos_app.model.BaseResponseAcademia
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalosEscuroCard
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import kotlinx.coroutines.launch
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuscarAcademias(lifecycleScope: LifecycleCoroutineScope) {

    val academiaService = RetrofitHelper.getInstance().create(AcademiaService::class.java)
    val estadoAcademia = remember { mutableStateOf("") }
    val estadoTodasAcademias = remember { mutableStateOf(emptyList<AcademiaResponse>()) }

    // Função para buscar academias e atualizar o estado

    // Função para buscar academias por nome
    suspend fun buscarAcademiasPorNome(nome: String): List<AcademiaResponse> {
        val result = academiaService.getAlunoByNome(nome)
        if (result.isSuccessful) {
            val response = result.body()
            if (response != null) {
                val academias: List<AcademiaResponse>? = response.data
                if (academias != null) {
                    return academias
                }
            }
        } else {
            Log.e("GETTING-DATA", "Erro ao buscar academias: ${result.message()}")
        }

        return emptyList()
    }

    // Função para buscar todas as academias
    suspend fun buscarTodasAcademias(): List<AcademiaResponse> {
        val result = academiaService.getAcademia()
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
        val nome = estadoAcademia.value
        val academias: List<AcademiaResponse> = if (nome.isNotEmpty()) {
            buscarAcademiasPorNome(nome)
        } else {
            buscarTodasAcademias()

        }
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
            OutlinedTextField(
                value = estadoAcademia.value,
                onValueChange = { estadoAcademia.value = it },
                trailingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.baseline_search_24),
                        contentDescription = "Icon de Phone",
                        tint = Color.White,
                        modifier = Modifier.clickable {
                            lifecycleScope.launch {
                                buscarAcademias()
                            }
                        }
                    )
                },
                placeholder = {
                    Text(text = "Buscar Academias", color = Color(0xFF606060))
                },
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(25.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    containerColor = Color(0xFF393939),
                    cursorColor = Color.White,
                    focusedBorderColor = Color.Transparent
                ),
                singleLine = true
            )

            Espacamento(tamanho = 50.dp)

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
                        if (estadoAcademia.value != estadoAcademia.value) {
                            Text(
                                text = "Academia não encontrada",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 16.dp),
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp,
                                color = Color.White
                            )



                        }else if (estadoAcademia.value != null){
                            Text(
                                text = "Procure por alguma academia",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 16.dp),
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp,
                                color = Color.White
                            )
                        }
                        else {
                            LazyColumn {
                                items(estadoTodasAcademias.value) { academia ->
                                    Card(modifier = Modifier.fillMaxWidth().height(150.dp).background(
                                        GrayKalosEscuroCard
                                    )) {
                                        Text(
                                            text = academia.nome.toString(),
                                            fontSize = 64.sp,
                                            color = Color.White
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
