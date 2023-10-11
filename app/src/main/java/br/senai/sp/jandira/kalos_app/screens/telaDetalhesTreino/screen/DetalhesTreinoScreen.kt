package br.senai.sp.jandira.kalos_app.screens.telaDetalhesTreino.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createButtonWithFunction
import br.senai.sp.jandira.app_kalos.components.createButtonWithWidth2
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.model.TreinoComExercicio
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesTreino.components.BotaoIniciarTreino
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesTreino.components.CardCapaTreino
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesTreino.components.CardExercicio
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesTreino.components.HeaderTreino
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.service.TreinoService
import com.google.firebase.firestore.local.LocalStore
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun DetalhesTreinoScreen(navController: NavController, lifecycleCoroutineScope: LifecycleCoroutineScope, localStorage: Storage) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){

        val context = LocalContext.current
        val corPrimariaAcademia = localStorage.lerValor(context, "corPrimariaAcademia")
        val idTreino = localStorage.lerValor(context, "idTreino")
        var estatoExercicios by remember {
            mutableStateOf(TreinoComExercicio())
        }
        lateinit var treinoService: TreinoService
        treinoService = RetrofitHelper.getInstance().create(TreinoService::class.java)

        lifecycleCoroutineScope.launch {
            val result = treinoService.getTreinoPorId(idTreino.toString())
            if (result.isSuccessful){
                Log.e("ssss", "TelaHomeAcademia: ${result.body()}", )
                estatoExercicios = result.body()?.data!!

            }

        }

        estatoExercicios.foto?.let { CardCapaTreino(it) }

        Column (modifier = Modifier.padding(15.dp)){
            estatoExercicios?.let {
                HeaderTreino(
                    nomeTreino = it.nome!!,
                    nivelTreino = it.nome_nivel!!,
                    categoriaTreino = it.nome_categoria_treino!!,
                    descricao = it.descricao!!,
                    dataTreino = it.data_criacao!!
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            BotaoIniciarTreino(cor = corPrimariaAcademia.toString())

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Resumo",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            var i:Int = 0

            LazyColumn(){
                items(estatoExercicios.exercicios!!){

                    i++

                    CardExercicio(
                        numero = i.toString(),
                        imagem = it.anexo!!,
                        nome = it.nome!!,
                        series = it.series!!,
                        repeticoes = it.repeticoes!!,
                        duracao = it.duracao!!
                    )
                }
            }


    }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun DetalhesTreinoPreview() {
//    DetalhesTreinoScreen(
//        imagem = "https://img.freepik.com/fotos-gratis/mulher-de-alto-angulo-hidratante-apos-treino_23-2148419818.jpg?w=2000&t=st=1696878003~exp=1696878603~hmac=d3a7b647534867fd6fa1264434c1f62b51e4bddd39461e49497234e8531771c1",
//        nome = "Treino Cardiovascular",
//        nivel = "Iniciante",
//        categoria = "Musculação",
//        descricao = "Lorem ipsum dolor sit amet consectetur. Molestie et nam auctor at dis non condimentum leo sodales. Libero quis bibendum nunc lorem lectus...",
//        data = "11/04/2023",
//        corAcademia = "34439E"
//    )
//}