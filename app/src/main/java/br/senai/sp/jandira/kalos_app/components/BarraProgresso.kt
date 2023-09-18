package br.senai.sp.jandira.kalos_app.components

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createButtonWithFunction
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.screens.telaInformacoesPessoais.screen.InformacoesPessoais
import br.senai.sp.jandira.kalos_app.screens.telaObjetivo.screen.TelaObjetivo
import br.senai.sp.jandira.kalos_app.screens.telaMetricas.screen.TelaMetricas
import br.senai.sp.jandira.kalos_app.screens.telaSaudeLimitacoes.screen.TelaSaudeLimitacoes
import br.senai.sp.jandira.kalos_app.service.AlunoService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import com.google.gson.JsonObject
import kotlinx.coroutines.launch


@Composable
fun BarraProgresso(navController: NavController, localStorage: Storage, lifecycleScope: LifecycleCoroutineScope) {
    lateinit var alunoService: AlunoService
    alunoService = RetrofitHelper.getInstance().create(AlunoService::class.java)

    val context = LocalContext.current
    var progressCount = remember { mutableStateOf(0) }
    var progress = remember { mutableStateOf(0.3f) }

   // LocalStorage.getFromSharedPreferences(context, "emailState")

    //Log.e("TAG",LocalStorage.getFromSharedPreferences(context, "email").toString())
    //val minhaClasse : Storage = Storage()

    when (progressCount.value) {

        1 -> progress.value = 0.3f
        2 -> progress.value = 0.5f
        3 -> progress.value = 0.6f
        4 -> progress.value = 0.7f
        5 -> progress.value = 0.8f
        6 -> progress.value = 1.0f
    }


    val size = animateFloatAsState(
        targetValue = progress.value,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )

    fun increment() {
        if (progressCount.value < 6) {
            progressCount.value += 2
        } else {
            Toast.makeText(context, "Erro", Toast.LENGTH_SHORT).show()
        }
    }

    fun decrement() {
        if (progressCount.value >= 2) {
            progressCount.value -= 2
        } else {
            Toast.makeText(context, "Erro", Toast.LENGTH_SHORT).show()
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp)
    ) {

        if(progressCount.value == 2){
            HeaderTelaInformacoes(titulo = stringResource(id = R.string.saude_limitacoes) ) {
                decrement()
            }
        }else if(progressCount.value == 4){
            HeaderTelaInformacoes(titulo =  "Suas Métricas" ) {
                decrement()
            }
        }else if( progressCount.value == 6) {
            HeaderTelaInformacoes(titulo = stringResource(id = R.string.objetivo) ) {
                decrement()
            }
        }

        if (progressCount.value == 0)
            InformacoesPessoais(navController = navController, localStorage)
        else if (progressCount.value == 2)
            TelaSaudeLimitacoes(navController = navController, localStorage)
        else if (progressCount.value == 4)
            TelaMetricas(navController = navController, localStorage)
        else if (progressCount.value == 6)
            TelaObjetivo(navController = navController, localStorage)


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp), verticalArrangement = Arrangement.Bottom
        ) {
            // Progress Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()

                        .background(GrayKalos)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(size.value)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(9.dp))
                        .background(GreenKalos)
                        .animateContentSize()
                )


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
            ) {


                if (progressCount.value == 0) {
                    createButtonWithFunction(
                        textButton = "Continue",
                        corBotao = GreenKalos

                    ) {
                        increment()
                    }
                } else if (progressCount.value == 2) {
                    createButtonWithFunction(
                        textButton = "Continue",
                        corBotao = GreenKalos

                    ) {
                        increment()
                    }
                } else if (progressCount.value == 4) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        createButtonWithFunction(
                            textButton = "Continue",
                            corBotao = GreenKalos

                        ) {
                            increment()

                        }
                        Espacamento(tamanho = 15.dp)
                        createButtonWithFunction(
                            textButton = "Pular",
                            corBotao = Color.Red

                        ) {
                            increment()
                        }
                    }
                } else if (progressCount.value == 6) {
                    createButtonWithFunction(
                        textButton = "Continue",
                        corBotao = GreenKalos

                    ) {
//                        increment()
//
//                        Log.e("FOI?", localStorage.lerValor(context, "email").toString() )
//                        Log.e("FOI?", localStorage.lerValor(context, "senha").toString() )
//                        Log.e("FOI?", localStorage.lerValor(context, "nome").toString() )
//                        Log.e("FOI?", localStorage.lerValor(context, "dataNascimento").toString() )
//                        Log.e("FOI?", localStorage.lerValor(context, "cpf").toString() )
//                        Log.e("FOI?", localStorage.lerValor(context, "telefone").toString() )
//                        Log.e("FOI?", localStorage.lerValor(context, "genero").toString() )
//                        Log.e("FOI?", localStorage.lerValor(context, "condicaoMedica").toString() )
//                        Log.e("FOI?", localStorage.lerValor(context, "lesoes").toString() )
//                        Log.e("FOI?", localStorage.lerValor(context, "medicamentos").toString() )
//                        Log.e("FOI?", localStorage.lerValor(context, "peso").toString() )
//                        Log.e("FOI?", localStorage.lerValor(context, "altura").toString() )
//                        Log.e("FOI?", localStorage.lerValor(context, "objetivo").toString() )
                        var generoText = localStorage.lerValor(context, "genero").toString()
                        var genero: Int
                        if(generoText == "Masculino")
                                        genero = 1
                        else if (generoText == "Feminino"){
                            genero = 2
                        }else{
                            genero = 4
                        }

                        lifecycleScope.launch {
                            val body = JsonObject().apply{
                                addProperty("email",localStorage.lerValor(context, "email").toString() )
                                addProperty("senha",localStorage.lerValor(context, "senha").toString())
                                addProperty("nome", localStorage.lerValor(context, "nome").toString() )
                                addProperty("data_nascimento", localStorage.lerValor(context, "dataNascimento").toString() )
                                addProperty("cpf", localStorage.lerValor(context, "cpf").toString() )
                                addProperty("telefone", localStorage.lerValor(context, "telefone").toString() )
                                addProperty("id_genero", genero )
                                addProperty("questao_condicao_medica", localStorage.lerValor(context, "condicaoMedica").toString() )
                                addProperty("questao_lesoes", localStorage.lerValor(context, "lesoes").toString() )
                                addProperty("questao_medicamento", localStorage.lerValor(context, "medicamento").toString() )
                                addProperty("peso", localStorage.lerValor(context, "peso").toString() )
                                addProperty("altura", localStorage.lerValor(context, "altura").toString() )
                                addProperty("objetivo", localStorage.lerValor(context, "objetivo").toString() )
                            }

                            val result = alunoService.cadastrarAluno(body)

                            if(result.isSuccessful){
                                Log.e("CREAT-DATA", "${result.body()}")
                                val checagem = result.body()?.get("status")
                                if(checagem.toString() == "401"){
                                    Log.e("TAG", "Deu erro", )
                                    Toast.makeText(context, "Erro ", Toast.LENGTH_SHORT).show()

                                }else{
                                    Toast.makeText(context, "Sucesso", Toast.LENGTH_SHORT).show()

                                    navController.navigate("home")
                                }


                            }else{
                                Log.e("CREAT-DATA", result.message())
                            }
                        }

                    }
                }


            }
        }


    }
}