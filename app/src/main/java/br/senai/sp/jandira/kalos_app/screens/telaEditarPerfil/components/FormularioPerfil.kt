package br.senai.sp.jandira.kalos_app.screens.telaEditarPerfil.components

import android.net.Uri
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createButtonWithError2
import br.senai.sp.jandira.app_kalos.components.createButtonWithFunction
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.components.CampoGenero2
import br.senai.sp.jandira.kalos_app.components.Espacamento
import br.senai.sp.jandira.kalos_app.model.AlunoResponse
import br.senai.sp.jandira.kalos_app.screens.telaInformacoesPessoais.component.CampoCpf
import br.senai.sp.jandira.kalos_app.screens.telaInformacoesPessoais.component.CampoDataNascimento
import br.senai.sp.jandira.kalos_app.screens.telaInformacoesPessoais.component.CampoNome
import br.senai.sp.jandira.kalos_app.screens.telaInformacoesPessoais.component.CampoTelefone
import br.senai.sp.jandira.kalos_app.screens.telaMetricas.component.CampoTextoMetricas
import br.senai.sp.jandira.kalos_app.screens.telaMetricas.component.CampoTextoMetricas2
import br.senai.sp.jandira.kalos_app.screens.telaPerfil.components.convertIso8601ToDate
import br.senai.sp.jandira.kalos_app.service.AlunoService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FormularioPerfil(aluno: AlunoResponse, lifecycleCoroutineScope: LifecycleCoroutineScope,
                     navController:NavController, localStorage: Storage) {
    lateinit var storageRef: StorageReference
    lateinit var fibaseFirestore: FirebaseFirestore
    storageRef = FirebaseStorage.getInstance().reference.child("images")
    fibaseFirestore = FirebaseFirestore.getInstance()

    var context = LocalContext.current
    var estadoNome = remember {
        mutableStateOf(aluno.nome.toString())
    }
    var estadoNomeError = remember {
        mutableStateOf("")
    }
    var estadoTelefone = remember {
        mutableStateOf(aluno.telefone.toString())
    }

    var estadoTelefoneError = remember {
        mutableStateOf("")
    }
    var categoryGenero by remember {
        mutableStateOf(aluno.genero)
    }
    var categoryGeneroError = remember {
        mutableStateOf("")
    }
    var data = dateToLocalDate(convertIso8601ToDate(aluno.data_nascimento.toString()))

    var estadoDia = remember { mutableStateOf("0" + data.dayOfMonth.toString()) }
    var estadoMes = remember { mutableStateOf("0" + data.monthValue.toString()) }
    var estadoAno = remember { mutableStateOf(data.year.toString()) }
    val estadoDataNascimentoError = remember {
        mutableStateOf("")
    }
    var estadoDataNascimento = remember {
        mutableStateOf("")

    }
    val estadoCpf = remember {
        mutableStateOf(aluno.cpf.toString())
    }

    val estadoCpfError = remember {
        mutableStateOf("")
    }
    var estadoPeso = remember {
        mutableStateOf(if(aluno.peso.toString() == "null"){"0"}else{ aluno.peso.toString()})
    }

    var estadoPesoError = remember {
        mutableStateOf("")
    }

    var estadoAltura = remember {
        mutableStateOf(if(aluno.altura == "null"){"0"}else{ aluno.altura.toString()})
    }

    var estadoAlturaError = remember {
        mutableStateOf("")
    }

    var valorFoto by remember {
        mutableStateOf("")
    }
    var statusCarregando by remember {
        mutableStateOf(false)
    }
    fun convertIso8601ToDate(iso8601String: String): Date {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        return format.parse(iso8601String)
    }

    fun validarNome(nome: String): String {
        if (nome.isEmpty()) {
            return "Nome é obrigatório."
        } else if (nome.length < 2) {
            return "Nome deve ter pelo menos 2 caracteres."
        } else if (!nome.matches(Regex("^[A-Za-zÀ-ÖØ-öø-ÿ\\s]*\$"))) {
            return "Nome contém caracteres inválidos."
        } else {
            return ""
        }
    }

    fun validarDataNascimento(dataNascimento: String): String {
        if (dataNascimento.isEmpty() || dataNascimento == "") {
            return "Data de nascimento é obrigatória."
        }else if(dataNascimento.length > 8 || dataNascimento.length < 8){
            return "Data de nascimento está incorreto"
        }else{
            return ""
        }
    }

    fun validarTelefone(telefone: String): String {
        if (telefone.isEmpty()) {
            return "Telefone é obrigatório."
        }  else {
            return ""

        }
    }

    fun validarCPF(cpf: String): String {
        if (cpf.isEmpty()) {
            return "CPF é obrigatório."
        } else {
            return ""

        }
    }

    fun validarGenero(genero: String): String {
        if (genero.isEmpty()) {
            return "Gênero é obrigatório."
        } else {
            // Adicione aqui a validação específica para gênero (exemplo: opções válidas)
            // Se a validação falhar, retorne a mensagem de erro apropriada
            // Caso contrário, retorne uma string vazia
            return ""
        }
    }
    var fotoUri =  remember {
        mutableStateOf<Uri?>(null)
    }


    estadoDataNascimento.value = "${estadoDia.value + estadoMes.value + estadoAno.value}"
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        EditarFoto(aluno, fotoUri)
        Spacer(modifier = Modifier.height(36.dp))
        Text(
            text = stringResource(R.string.nome),
            color = GrayKalos,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )

        if (estadoNomeError.value.isNotEmpty()) {
            createTextKalos(
                content = estadoNomeError.value,
                sizeText = 16,
                colorText = Color.Red,
                bold = 500,
                alinhamento = TextAlign.Left,
                modifier = Modifier.padding(start = 10.dp)

            )
        }
        CampoNome(value = estadoNome.value, aoMudar ={ estadoNome.value = it} ,
            placeholder ="" , isError =estadoNomeError.value.isNotEmpty()
        )
        Espacamento(tamanho = 20.dp)

        if (estadoTelefoneError.value.isNotEmpty()) {
            createTextKalos(
                content = estadoTelefoneError.value,
                sizeText = 16,
                colorText = Color.Red,
                bold = 500,
                alinhamento = TextAlign.Left,
                modifier = Modifier.padding(start = 10.dp)

            )
        }
        Text(
            text = stringResource(R.string.telefone),
            color = GrayKalos,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        CampoTelefone(
            value = estadoTelefone.value.toString(), aoMudar = {
                estadoTelefone.value = it
            }, placeholder = "Digite o telefone",
            isError = estadoTelefoneError.value.isNotEmpty()
        )
        Espacamento(tamanho = 20.dp)

        if (categoryGeneroError.value.isNotEmpty()) {
            createTextKalos(
                content = categoryGeneroError.value,
                sizeText = 16,
                colorText = Color.Red,
                bold = 500,
                alinhamento = TextAlign.Left,
                modifier = Modifier.padding(start = 10.dp)

            )
        }
        Text(
            text = stringResource(R.string.genero),
            color = GrayKalos,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )

        CampoGenero2(
            isError = categoryGeneroError.value.isNotEmpty(),
            category = categoryGenero.toString(),
            {
            categoryGenero = it
            },
            {
                categoryGenero = it
            }
        )
        Espacamento(tamanho = 20.dp)

        if (estadoDataNascimentoError.value.isNotEmpty()) {
            createTextKalos(
                content = estadoDataNascimentoError.value,
                sizeText = 16,
                colorText = Color.Red,
                bold = 500,
                alinhamento = TextAlign.Left,
                modifier = Modifier.padding(start = 10.dp)

            )
        }

        Text(
            text = stringResource(R.string.data_de_nascimento),
            color = GrayKalos,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )


        CampoDataNascimento(
            dia = estadoDia.value,
            mes = estadoMes.value,
            ano = estadoAno.value,
            aoMudarDia = {
                estadoDia.value = it
                estadoDataNascimentoError.value = ""

            },
            aoMudarMes = {
                estadoMes.value = it
                estadoDataNascimentoError.value = ""

            },
            aoMudarAno = {
                estadoAno.value = it
                estadoDataNascimentoError.value = ""

            },
            isErrorDia = estadoDataNascimentoError.value.isNotEmpty(),
            isErrorMes = estadoDataNascimentoError.value.isNotEmpty(),
            isErrorAno = estadoDataNascimentoError.value.isNotEmpty()
        )

        Espacamento(tamanho = 20.dp)

        if (estadoCpfError.value.isNotEmpty()) {
            createTextKalos(
                content = estadoCpfError.value,
                sizeText = 16,
                colorText = Color.Red,
                bold = 500,
                alinhamento = TextAlign.Left,
                modifier = Modifier.padding(start = 10.dp)

            )
        }
        Text(
            text = stringResource(R.string.cpf),
            color = GrayKalos,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        CampoCpf(
            value = estadoCpf.value.toString(), aoMudar = {
                estadoCpf.value = it

            }, placeholder = "Digite o cpf",
            isError = estadoCpfError.value.isNotEmpty()
        )
        Espacamento(tamanho = 20.dp)

        Text(
            text = stringResource(R.string.peso_em_kg),
            color = GrayKalos,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        CampoTextoMetricas(value = estadoPeso.value, aoMudar ={ novoValor ->
            estadoPeso.value = novoValor
            estadoPesoError.value = ""
               },
            placeholder = "",
            isError = estadoPesoError.value.isNotEmpty() )

        Espacamento(tamanho = 20.dp)

        Text(
            text = stringResource(R.string.altura_em_cm),
            color = GrayKalos,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )

        CampoTextoMetricas2(value = estadoAltura.value, aoMudar ={ novoValor ->
            estadoAltura.value = novoValor
            estadoAlturaError.value = ""
              },
            placeholder = "",
            isError = estadoAlturaError.value.isNotEmpty() )

        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    localStorage.salvarValor(context, aluno.senha.toString(), "senhaAlunoAlt")
                    localStorage.salvarValor(context, aluno.email.toString(), "emailAluno")

                    navController.navigate("alterarSenha")
                },
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.alterar_senha),
                color = Color.White,
                fontSize = 15.sp
            )
            Icon(painter = painterResource(id = R.drawable.baseline_arrow_right_alt_24) ,
                contentDescription = stringResource(R.string.ir_para_alterar_senha),
                tint = Color.White,
                modifier = Modifier.size(13.dp))
        }
        Spacer(modifier = Modifier.height(30.dp))
        createButtonWithError2(
            textButton = stringResource(R.string.salvar),
            corBotao = GreenKalos,
            teste = statusCarregando
        ) {
            val nomeError = validarNome(estadoNome.value)
            val dataNascimentoError = validarDataNascimento(estadoDataNascimento.value)
            val telefoneError = validarTelefone(estadoTelefone.value)
            val cpfError = validarCPF(estadoCpf.value)
            val generoError = categoryGenero?.let { validarGenero(it) }

            fun formatarData(input: String): String {
                val digitsOnly = input.replace(Regex("[^\\d]"), "")

                if (digitsOnly.length < 8) {
                    return digitsOnly
                }

                val day = digitsOnly.substring(0, 2)
                val month = digitsOnly.substring(2, 4)
                val year = digitsOnly.substring(4, 8)

                val formattedDate = "$year/$month/$day"

                return formattedDate
            }

            val dataFormatada = formatarData(estadoDataNascimento.value)
            Log.e("teste", "FormularioPerfil: ${categoryGenero}", )
            var genero: Int
            if (categoryGenero == "Masculino")
                genero = 1
            else if (categoryGenero== "Feminino") {
                genero = 2
            } else {
                genero = 4
            }


            if (nomeError == "" && dataNascimentoError == "" &&
                telefoneError == "" && cpfError == "" && generoError == ""
            ) {
                statusCarregando = true

                lateinit var alunoService: AlunoService
                alunoService = RetrofitHelper.getInstance().create(AlunoService::class.java)

                Log.e("teste", "FormularioPerfil: ${genero}", )

                if(fotoUri.value == null){
                    lifecycleCoroutineScope.launch {
                        val body = JsonObject().apply {
                                addProperty("email", aluno.email.toString())
                                addProperty("senha", aluno.senha)
                                addProperty("nome", estadoNome.value)
                                addProperty("data_nascimento", dataFormatada)
                                addProperty("cpf", estadoCpf.value)
                                addProperty("telefone", estadoTelefone.value)
                                addProperty("id_genero", genero)
                                addProperty("questao_condicao_medica", aluno.questao_condicao_medica)
                                addProperty("questao_lesoes", aluno.questao_lesoes)
                                addProperty("questao_medicamento", aluno.questao_medicamento)
                                addProperty("peso", estadoPeso.value)
                                addProperty("altura", estadoAltura.value)
                                addProperty("objetivo", aluno.objetivo)
                                addProperty("foto", aluno.foto)
                        }

                        val result = alunoService.AtualizarAluno(body, aluno.id.toString())
                        if (result.isSuccessful) {
                            Log.e("CREAT-DATA", "${result.body()}")
                            val checagem = result.body()?.get("status")
                            if (checagem.toString() == "200") {

                                navController.navigate("home")


                            } else {
                                Log.e("TAG", "Deu erro")
                            }
                        } else {
                            Log.e("CREAT-DATA", result.message())
                        }

                    }
                }else{
                    storageRef = storageRef.child(System.currentTimeMillis().toString())
                    fotoUri.let {
                        it.value?.let { it1 ->
                            storageRef.putFile(it1).addOnCompleteListener { task ->


                                    if (task.isSuccessful) {

                                            storageRef.downloadUrl.addOnSuccessListener { uri ->

                                                val map = HashMap<String, Any>()
                                                map["pic"] = uri.toString()
                                                valorFoto = map.toString()
                                                fibaseFirestore.collection("images").add(map)
                                                lifecycleCoroutineScope.launch {
                                                    val body = JsonObject().apply {
                                                        addProperty("email", aluno.email.toString())
                                                        addProperty("senha", aluno.senha)
                                                        addProperty("nome", estadoNome.value)
                                                        addProperty("data_nascimento", dataFormatada)
                                                        addProperty("cpf", estadoCpf.value)
                                                        addProperty("telefone", estadoTelefone.value)
                                                        addProperty("id_genero", genero)
                                                        addProperty("questao_condicao_medica", aluno.questao_condicao_medica)
                                                        addProperty("questao_lesoes", aluno.questao_lesoes)
                                                        addProperty("questao_medicamento", aluno.questao_medicamento)
                                                        addProperty("peso", estadoPeso.value)
                                                        addProperty("altura", estadoAltura.value)
                                                        addProperty("objetivo", aluno.objetivo)
                                                        addProperty("foto", uri.toString())
                                                    }

                                                    val result = alunoService.AtualizarAluno(body, aluno.id.toString())
                                                    if (result.isSuccessful) {
                                                        Log.e("CREAT-DATA", "${result.body()}")
                                                        val checagem = result.body()?.get("status")
                                                        if (checagem.toString() == "200") {

                                                            navController.navigate("home")


                                                        } else {
                                                            Log.e("TAG", "Deu erro")
                                                        }
                                                    } else {
                                                        Log.e("CREAT-DATA", result.message())
                                                    }

                                                }


                                            }

                                    } else {
                                        Toast.makeText(
                                            context,
                                            task.exception?.message,
                                            Toast.LENGTH_SHORT
                                        )
                                            .show()
                                    }

                            }

                        }
                    }
                }



            } else {
                // Exiba as mensagens de erro
                estadoNomeError.value = nomeError
                estadoDataNascimentoError.value = dataNascimentoError
                estadoTelefoneError.value = telefoneError
                estadoCpfError.value = cpfError
                if (generoError != null) {
                    categoryGeneroError.value = generoError
                }
            }
        }

    }



}



@RequiresApi(Build.VERSION_CODES.O)
fun dateToLocalDate(date: Date): LocalDate {
    val instant = date.toInstant()
    return instant.atZone(java.time.ZoneId.systemDefault()).toLocalDate()
}

