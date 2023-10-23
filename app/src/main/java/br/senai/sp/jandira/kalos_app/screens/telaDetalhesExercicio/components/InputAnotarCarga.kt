package br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components

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
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.service.ExercicioService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputAnotarCarga(
    cor: String,
    lifecycleCoroutineScope: LifecycleCoroutineScope,
    localStorage: Storage,
    idExercicioSerieRepeticao: String
) {
    val color = android.graphics.Color.parseColor(cor)

    var cargaState by remember {
        mutableStateOf("")
    }
    var context = LocalContext.current

    var habilitadoTextField by remember {
        mutableStateOf(true)
    }
    var statusLoading by remember {
        mutableStateOf(false)
    }

    lateinit var exercicioService: ExercicioService
    exercicioService = RetrofitHelper.getInstance().create(ExercicioService::class.java)

    Column(
        modifier = Modifier
            .width(360.dp)
            .height(130.dp)
            .background(Color.Black),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            Text(
                text = "Carga:",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }

        OutlinedTextField(
            value = cargaState,
            onValueChange = {cargaState = it},
            modifier = Modifier
                .height(51.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.White,
                containerColor = Color(0xFF393939),
                unfocusedBorderColor = Color(0xFF393939),
                focusedBorderColor = GreenKalos,
                cursorColor = GreenKalos
            ),
            singleLine = true,
            enabled = habilitadoTextField
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Button(
                onClick = {
                    Log.e("status habilitado", "${habilitadoTextField}", )

                    if (habilitadoTextField){
                        lifecycleCoroutineScope.launch {
                            val body = JsonObject().apply {
                                addProperty("peso", cargaState)
                                addProperty("id_aluno", localStorage.lerValor(context, "idAluno"))
                                addProperty("id_exercicio_serie_repeticao", idExercicioSerieRepeticao)
                            }

                            val result = exercicioService.anotarCarga(body)

                            Log.e("result carga", "${result}")

                            if (result.isSuccessful) {
                                Toast.makeText(context, "Carga salva.", Toast.LENGTH_SHORT).show()
                                habilitadoTextField = false
                            } else {
                                Toast.makeText(
                                    context,
                                    "Erro ao tentar salvar. Tente novamente",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    } else {
                        habilitadoTextField = false
                    }

                },
                colors = ButtonDefaults.buttonColors(Color(color))
            ) {
                Text(
                    text = if (habilitadoTextField) "Salvar" else "Editar",
                    color = if (cor.uppercase() == "#FFFFFF") Color.Black else Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
