package br.senai.sp.jandira.kalos_app.screens.telaHome.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.components.Espacamento
import br.senai.sp.jandira.kalos_app.model.AcademiaResponse
import br.senai.sp.jandira.kalos_app.model.AlunoResponse
import br.senai.sp.jandira.kalos_app.screens.telaBuscarAcademias.components.AcademiaCard
import br.senai.sp.jandira.kalos_app.service.AlunoService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalosEscuro
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun HomeAluno(aluno: AlunoResponse, navController: NavController,

              lifecycleCoroutineScope: LifecycleCoroutineScope, localStorage: Storage) {
    lateinit var alunoService: AlunoService
    alunoService = RetrofitHelper.getInstance().create(AlunoService::class.java)
    var academias by remember {
        mutableStateOf(emptyList<AcademiaResponse>())
    }
    val context = LocalContext.current
    var statuAtivo = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        HeaderHome(aluno)
        Spacer(modifier = Modifier.height(17.dp))
        BarraRetaHome()
        Spacer(modifier = Modifier.height(17.dp))
        Text(
            text = stringResource(R.string.suas_matriculas),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
        )
        var status by remember {
            mutableStateOf(false)
        }
        lifecycleCoroutineScope.launch {
            val result = alunoService.getAlunoAcademias(aluno.id.toString())



            if (result.isSuccessful) {
                val response = result.body()
                if (response != null) {
                     academias = response.data!!
                    status = true
                } else {
                    status = false
                }

            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        if(status) {

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(academias){
                            academia ->

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
                            onClick = { navController.navigate("homeAcademia")
                                statuAtivo.value = true
                                localStorage.salvarValor(context, "${statuAtivo.value}", "alunoAtivo")
                                localStorage.salvarValor(context, "${aluno.nome}", "aluno")
                                localStorage.salvarValor(
                                    context,
                                    "${academia.nome}",
                                    "nomeAcademia"
                                )
                                localStorage.salvarValor(
                                    context,
                                    "${academia.telefone}",
                                    "telefoneAcademia"
                                )
                                localStorage.salvarValor(
                                    context,
                                    "${academia.email}",
                                    "emailAcademia"
                                )
                                localStorage.salvarValor(
                                    context,
                                    "${academia.instagram}",
                                    "instagramAcademia"
                                )
                                localStorage.salvarValor(
                                    context,
                                    "${academia.facebook}",
                                    "facebookAcademia"
                                )
                                localStorage.salvarValor(
                                    context,
                                    "${academia.whatsapp}",
                                    "whatsappAcademia"
                                )
                                localStorage.salvarValor(
                                    context,
                                    "${academia.foto}",
                                    "fotoAcademia"
                                )
                                localStorage.salvarValor(
                                    context,
                                    "${academia.descricao}",
                                    "descricaoAcademia"
                                )
                                localStorage.salvarValor(
                                    context,
                                    "${academia.cor_primaria}",
                                    "corPrimariaAcademia"
                                )
                                localStorage.salvarValor(
                                    context,
                                    "${academia.cor_secundaria}",
                                    "corSegundariaAcademia"
                                )
                                localStorage.salvarValor(
                                    context,
                                    "${academia.foto}",
                                    "fotoAcademia"
                                )
                                localStorage.salvarValor(
                                    context,
                                    pegarNomeTags(academia).toString(),
                                    "tagsAcademia"
                                )
                                Log.e("tags", pegarNomeTags(academia).toString())

                            }
                        )
                        Espacamento(tamanho = 20.dp)
                    }
                }


        }else{
            Text(text = "Busque por mais academias", color = Color.White, fontSize = 20.sp)
        }
    }



    }


//@Preview
//@Composable
//fun HomeAlunoPreview() {
//    HomeAluno()
//}