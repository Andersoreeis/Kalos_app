package br.senai.sp.jandira.kalos_app.screens.telaHomeAcademia.components

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.model.TreinosResponse
import br.senai.sp.jandira.kalos_app.screens.telaPerfil.components.convertIso8601ToDate
import br.senai.sp.jandira.kalos_app.service.AlunoService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.service.TreinoService
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.Date

@SuppressLint("CoroutineCreationDuringComposition")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TelaTreinos(
    lifecycleCoroutineScope: LifecycleCoroutineScope,
    localStorage: Storage,
    navController: NavController
) {
    var treinos by remember {
        mutableStateOf(listOf(TreinosResponse()))
    }
    var status by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current


    lateinit var treinoService: TreinoService
    treinoService = RetrofitHelper.getInstance().create(TreinoService::class.java)



    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
    ) {

        val idAcademia = localStorage.lerValor(context, "idAcademia")
        val idAluno = localStorage.lerValor(context, "idAluno")
        Log.e("ids", "TelaTreinos: ${idAcademia} ")
        Log.e("ids", "TelaTreinos: ${idAluno} ")

        lifecycleCoroutineScope.launch {
            val result =
                treinoService.getTreinosAcademiaAluno(idAcademia.toString(), idAluno.toString())
            Log.e("respostas", "TelaTreinos: ${result.body()}")
            if (result.isSuccessful) {
                val response = result.body()
                if (response != null) {
                    Log.e("respostas", "TelaTreinos: ${response.data}")
                    treinos = response.data!!
                    status = true
                } else {
                    status = false
                }
            }

        }
        if (status) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(treinos) {
                    Box(
                        modifier = Modifier
                            .height(227.dp)
                            .width(344.dp)
                            .shadow(2.dp, RoundedCornerShape(16.dp))
                    ) {
                        AsyncImage(
                            model = it.foto,
                            contentDescription = "foto do treino",
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable {
                                    localStorage.salvarValor(
                                        context,
                                        it.id_treino.toString(),
                                        "idTreino"
                                    )
                                    navController.navigate("detalhesTreino")
                                }
                                .shadow(2.dp, RoundedCornerShape(16.dp)),
                            error = painterResource(id = R.drawable.treinoerro),
                            alpha = 0.7f
                        )



                        Column(
                            modifier = Modifier
                                .padding(top = 130.dp, start = 20.dp)
                                .shadow(
                                    elevation = 20.dp,
                                    spotColor = Color.Black,
                                    ambientColor = Color.Black
                                )
                        ) {
                            Text(
                                text = it.nome.toString(),
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = it.nome_categoria_treino.toString(),
                                color = Color.White,
                                fontSize = 15.sp
                            )
                            
                            Spacer(modifier = Modifier.height(8.dp))

                            Surface(
                                modifier = Modifier
                                    .height(25.dp)
                                    .width(90.dp),
                                color = Color(255, 255, 255, 60),
                                shape = RoundedCornerShape(10.dp)

                            ) {

                                Row(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_calendar_month_24),
                                        contentDescription = "calendario",
                                        tint = Color.White
                                    )
                                    Text(
                                        text = it.data_criacao.toString(),
                                        color = Color.White,
                                        fontSize = 12.sp
                                    )
                                }

                            }

                        }

                    }
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        } else {
            Text(
                text = "Você não possui treinos nessa academia",
                color = Color.White,
                fontSize = 20.sp
            )
        }

    }
}





