package br.senai.sp.jandira.kalos_app.screens.telaReservas.screen

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.model.PostagensResponse
import br.senai.sp.jandira.kalos_app.model.ProdutosTeste
import br.senai.sp.jandira.kalos_app.model.ReservaResponse
import br.senai.sp.jandira.kalos_app.screens.telaPostagens.components.arrumarData
import br.senai.sp.jandira.kalos_app.screens.telaReservas.components.CardReservas
import br.senai.sp.jandira.kalos_app.screens.telaReservas.components.HeaderReservas
import br.senai.sp.jandira.kalos_app.service.PostagemService
import br.senai.sp.jandira.kalos_app.service.ReservaService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import org.json.JSONObject

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun TelaReservas(
    navController: NavController,
    context: Context,
    lifecycleCoroutineScope: LifecycleCoroutineScope,
    localStorage: Storage
) {

    lateinit var reservaService: ReservaService
    reservaService = RetrofitHelper.getInstance().create(ReservaService::class.java)

    var listaReservas by remember {
        mutableStateOf(listOf<ReservaResponse>())
    }

    var status by remember {
        mutableStateOf(false)
    }

    var idParaCancelar by remember {
        mutableStateOf(0)
    }

    val bodyUpdateReserva by remember {
        mutableStateOf(JsonObject())
    }

    var statusCarregamento = remember {
        mutableStateOf(false)
    }

    lifecycleCoroutineScope.launch {
        val result = reservaService.getReservasAluno(
            localStorage.lerValor(context, "idAcademia").toString(),
            localStorage.lerValor(context, "idAluno").toString()
        )

        Log.e("result", "${result.body()}")
        if (result.isSuccessful) {
            listaReservas = result.body()!!.data!!
            status = true
        }
    }


    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(20.dp)
        ) {
            HeaderReservas(navController = navController)

            if (status){
                LazyColumn() {
                    items(listaReservas) {

                        CardReservas(
                            it.nome_produto!!,
                            it.foto!!,
                            arrumarData(it.data!!)!!,
                            it.quantidade!!,
                            it.total!!,
                            it.codigo!!,
                            it.status_reserva!!,
                            statusCarregamento,
                        ) {
                            idParaCancelar = it.id!!

                            bodyUpdateReserva.apply {
                                addProperty("quantidade", it.quantidade)
                                addProperty("total", it.total)
                                addProperty("id_produto", it.id_produto)
                                addProperty("id_aluno", localStorage.lerValor(context, "idAluno"))
                                addProperty("id_status_reserva", 2) //id para "cancelado"
                            }

                        }
                    }
                }
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(
                        color = Color(0, 255, 144),
                        modifier = Modifier.size(64.dp)
                    )
                }
            }



        }




        if (statusCarregamento.value) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(16, 16, 16, 210))
                    .clickable { statusCarregamento.value = false },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                Surface(
                    modifier = Modifier
                        .height(140.dp)
                        .width(250.dp),
                    color = GrayKalos,
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = "Tem certeza de que deseja cancelar sua reserva?",
                            color = Color.White,
                            modifier = Modifier.width(200.dp),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.x),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(Color.Red),
                                modifier = Modifier
                                    .size(19.dp)
                                    .clickable { statusCarregamento.value = false }
                            )

                            Image(
                                painter = painterResource(id = R.drawable.right),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable {
                                        statusCarregamento.value = false

                                        Log.i("body", "$bodyUpdateReserva")

                                        lifecycleCoroutineScope.launch {
                                            var result =
                                                reservaService.updateReserva(
                                                    idParaCancelar.toString(),
                                                    bodyUpdateReserva
                                                )


                                            Log.i("result cancelar", "$result")

                                            if (result.isSuccessful) {
                                                Toast
                                                    .makeText(
                                                        context,
                                                        "Reserva cancelada com sucesso.",
                                                        Toast.LENGTH_LONG
                                                    )
                                                    .show()

                                                navController.navigate("reservas")
                                            } else {
                                                Toast
                                                    .makeText(
                                                        context,
                                                        "Algo deu errado. Tente novamente mais tarde",
                                                        Toast.LENGTH_LONG
                                                    )
                                                    .show()
                                            }
                                        }


                                    }
                            )
                        }

                    }
                }
            }
        }


    }

}