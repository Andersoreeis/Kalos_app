package br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.model.CargaResponse
import br.senai.sp.jandira.kalos_app.service.ExercicioService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import java.util.Locale

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputAnotarCarga(
    cor: String,
    lifecycleCoroutineScope: LifecycleCoroutineScope,
    localStorage: Storage,
    idExercicioSerieRepeticao: String
) {
    val color = android.graphics.Color.parseColor(cor)


    var context = LocalContext.current

    var habilitadoTextField by remember {
        mutableStateOf(false)
    }
    var carga by remember {
        mutableStateOf(CargaResponse())
    }
    var cargaState by remember {
        mutableStateOf("")
    }

    Log.e("idexercicioserierep", "${idExercicioSerieRepeticao}")

    lateinit var exercicioService: ExercicioService
    exercicioService = RetrofitHelper.getInstance().create(ExercicioService::class.java)

    //Busca um registro de carga com o id do aluno e id do exercicio
    lifecycleCoroutineScope.launch {
        var resultCargaExistente = exercicioService.getCargaPorIdAlunoEExercicio(
            localStorage.lerValor(
                context,
                "idAluno"
            )!!.toInt(), idExercicioSerieRepeticao.toInt()
        )

        Log.e("result carga existente antes do if", "${resultCargaExistente.body()}")

        //Se existir um registro, atribui a variavel "carga" o registro.
        if (resultCargaExistente.body()?.data != null) {
            carga = resultCargaExistente.body()?.data?.get(0)!!

            Log.e("scr", "caiu no if se existe carga, response: ${carga}", )
            //Se não existir, deixa o textfield habilitado para o usuário salvar a carga
        } else {
            habilitadoTextField = true
            Log.e("scr", "caiu no if se existe carga", )
        }
    }

    fun salvarEditarCarga(){
        //Se o carga.peso for vazio, significa que não foi atribuido nenhum valor a ele, portanto não existe registro de carga anotada no exercício e o botão irá salvar.
        if (carga.peso == "") {
            Log.e("status habilitado", "${habilitadoTextField}")

            lifecycleCoroutineScope.launch {
                val body = JsonObject().apply {
                    addProperty("peso", cargaState)
                    addProperty(
                        "id_aluno",
                        localStorage.lerValor(context, "idAluno")
                    )
                    addProperty(
                        "id_exercicio_serie_repeticao",
                        idExercicioSerieRepeticao
                    )
                }

                val result = exercicioService.anotarCarga(body)

                Log.e("result id carga", "${result.body()?.data?.id}")

                if (result.isSuccessful) {
                    Toast.makeText(context, "Carga salva.", Toast.LENGTH_SHORT)
                        .show()
                    habilitadoTextField = false
                    carga = result.body()?.data!!
                    Log.e("caragaagagag", "${carga}", )
                } else {
                    Toast.makeText(
                        context,
                        "Erro ao tentar salvar. Tente novamente",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            //Se houver algum registro em carga.peso, significa que foi atribuido algum valor, então ao invés de salvar ele vai editar
        } else {
            Log.e("clicou no salvar dps de editar", "${carga}" )
            lifecycleCoroutineScope.launch {
                val body = JsonObject().apply {
                    addProperty("peso", cargaState)
                    addProperty(
                        "id_aluno",
                        localStorage.lerValor(context, "idAluno")
                    )
                    addProperty(
                        "id_exercicio_serie_repeticao",
                        idExercicioSerieRepeticao
                    )
                }

                Log.e("body", "${body}", )

                Log.e("depois do launch", "${carga}", )

                val result = exercicioService.updateCarga(body, carga.id!!)

                Log.e("result id carga", "${result}")
                Log.e("result carga", "${carga.id}")

                if (result.isSuccessful) {
                    Toast.makeText(context, "Carga editada com sucesso.", Toast.LENGTH_SHORT)
                        .show()
                    habilitadoTextField = false
                    carga = result.body()?.data!!
                } else {
                    Toast.makeText(
                        context,
                        "Erro ao tentar editar. Tente novamente",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }


    }

    Column(
        modifier = Modifier
            .width(360.dp)
            .height(130.dp)
            .background(Color.Black),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            Text(
                text = "Carga (em kg):",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }

        OutlinedTextField(
            value = if (habilitadoTextField) cargaState else carga.peso!!,
            onValueChange = { cargaState = it },
            modifier = Modifier
                .height(51.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.White,
                containerColor = Color(0xFF393939),
                unfocusedBorderColor = Color(0xFF393939),
                focusedBorderColor = GreenKalos,
                cursorColor = GreenKalos,
                disabledTextColor = GrayKalos
            ),
            singleLine = true,
            enabled = habilitadoTextField,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {

            //Verifica se o textfield está habilitado
            if (habilitadoTextField) {

                Button(
                    onClick = {
                        salvarEditarCarga()
                    },
                    colors = ButtonDefaults.buttonColors(Color(color))
                ) {
                    Text(
                        text = "Salvar",
                        color = if (cor.uppercase() == "#FFFFFF") Color.Black else Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }


            } else {
                Button(
                    onClick = {
                        habilitadoTextField = true
                        Log.e("status habilitado é true", "${habilitadoTextField}")

                        Log.e("clicou no editar", "${carga}", )
                    },
                    colors = ButtonDefaults.buttonColors(Color(color))
                ) {
                    Text(
                        text = "Editar",
                        color = if (cor.uppercase() == "#FFFFFF") Color.Black else Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
