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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import br.senai.sp.jandira.kalos_app.screens.telaSaudeLimitacoes.components.FormSaudeLimitacoes
import br.senai.sp.jandira.kalos_app.screens.telaSaudeLimitacoes.screen.TelaSaudeLimitacoes
import br.senai.sp.jandira.kalos_app.service.AlunoService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import com.google.gson.JsonObject
import kotlinx.coroutines.launch


@Composable
fun BarraProgresso(
    navController: NavController,
    localStorage: Storage,
    lifecycleScope: LifecycleCoroutineScope
) {
    lateinit var alunoService: AlunoService
    alunoService = RetrofitHelper.getInstance().create(AlunoService::class.java)

    val context = LocalContext.current
    var progressCount = remember { mutableStateOf(0) }
    var progress = remember { mutableStateOf(0.3f) }

    var condicaoMedicaState by remember {
        mutableStateOf("")
    }
    var condicaoMedicaStateError by remember {
        mutableStateOf("")
    }
    var lesoesState by remember {
        mutableStateOf("")
    }

    var lesoesStateError by remember {
        mutableStateOf("")
    }
    var medicamentoState by remember {
        mutableStateOf("")
    }
    var medicamentoStateError by remember {
        mutableStateOf("")
    }
    var objetivoState by remember {
        mutableStateOf("")
    }
    var objetivoStateError by remember {
        mutableStateOf("")
    }


    // parte informacoesCliente
    val estadoNome = remember {
        mutableStateOf("")
    }

    val estadoNomeError = remember {
        mutableStateOf("")
    }


    val estadoDataNascimento = remember {
        mutableStateOf("")

    }
    val estadoDataNascimentoError = remember {
        mutableStateOf("")
    }

    val estadoTelefone = remember {
        mutableStateOf("")
    }

    val estadoTelefoneError = remember {
        mutableStateOf("")
    }


    val estadoCpf = remember {
        mutableStateOf("")
    }

    val estadoCpfError = remember {
        mutableStateOf("")
    }

    var categoryGenero = remember {
        mutableStateOf("")
    }
    var categoryGeneroError = remember {
        mutableStateOf("")
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
        if (dataNascimento.isEmpty()) {
            return "Data de nascimento é obrigatória."
        } else {
            // Adicione aqui a validação específica para data de nascimento (exemplo: formato correto)
            // Se a validação falhar, retorne a mensagem de erro apropriada
            // Caso contrário, retorne uma string vazia
            return ""
        }
    }

    fun validarTelefone(telefone: String): String {
        if (telefone.isEmpty()) {
            return "Telefone é obrigatório."
        } else {
            // Adicione aqui a validação específica para telefone (exemplo: formato correto)
            // Se a validação falhar, retorne a mensagem de erro apropriada
            // Caso contrário, retorne uma string vazia
            return ""
        }
    }

    fun validarCPF(cpf: String): String {
        if (cpf.isEmpty()) {
            return "CPF é obrigatório."
        } else {
            // Adicione aqui a validação específica para CPF (exemplo: formato correto)
            // Se a validação falhar, retorne a mensagem de erro apropriada
            // Caso contrário, retorne uma string vazia
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
            .verticalScroll(rememberScrollState())
    ) {

        if (progressCount.value == 2) {
            HeaderTelaInformacoes(titulo = stringResource(id = R.string.saude_limitacoes)) {
                decrement()
            }
        } else if (progressCount.value == 4) {
            HeaderTelaInformacoes(titulo = "Suas Métricas") {
                decrement()
            }
        } else if (progressCount.value == 6) {
            HeaderTelaInformacoes(titulo = stringResource(id = R.string.objetivo)) {
                decrement()
            }
        }

        fun validarCamposQuestoes(condicaoMedica: String, lesoes: String, medicamentos: String) {

            when (condicaoMedica) {
                "" -> condicaoMedicaStateError = "Este campo não pode estar vazio"
            }
            when (lesoes) {
                "" -> lesoesStateError = "Este campo não pode estar vazio"
            }
            when (medicamentos) {
                "" -> medicamentoStateError = "Este campo não pode estar vazio"
            }

        }

        fun validarCampoObjetivo(objetivo: String) {

            when (objetivo) {
                "" -> objetivoStateError = "Este campo não pode estar vazio"
            }

        }



        if (progressCount.value == 0)
            InformacoesPessoais(
                navController = navController,
                localStorage,
                estadoNome = estadoNome,
                estadoNomeError = estadoNomeError,
                estadoDataNascimento = estadoDataNascimento,
                estadoDataNascimentoError = estadoDataNascimentoError,
                categoryGenero = categoryGenero,
                categoryGeneroError = categoryGeneroError,
                estadoTelefone = estadoTelefone,
                estadoTelefoneError = estadoTelefoneError,
                estadoCpf = estadoCpf,
                estadoCpfError = estadoCpfError,
            )
        else if (progressCount.value == 2)

            FormSaudeLimitacoes(
                localStorage = localStorage,
                condicaoMedicaState = condicaoMedicaState,
                condicaoMedicaStateError = condicaoMedicaStateError,
                aoMudarCondicao = {
                    condicaoMedicaState = it
                    condicaoMedicaStateError = ""
                },
                lesoesState = lesoesState,
                lesoesStateError = lesoesStateError,
                aoMudarLesoes = {
                    lesoesState = it
                    lesoesStateError = ""
                },
                medicamentoState = medicamentoState,
                medicamentoStateError = medicamentoStateError
            ) {
                medicamentoState = it
                medicamentoStateError = ""
            }
        else if (progressCount.value == 4)
            TelaMetricas(navController = navController, localStorage)
        else if (progressCount.value == 6)
            TelaObjetivo(navController = navController,
                localStorage,
                objetivoState,
                objetivoStateError,
                {
                    objetivoState = it
                    objetivoStateError = ""
                })






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

//
                if (progressCount.value == 0) {
                    createButtonWithFunction(
                        textButton = "Continue",
                        corBotao = GreenKalos

                    ) {
                        val nomeError = validarNome(estadoNome.value)
                        val dataNascimentoError = validarDataNascimento(estadoDataNascimento.value)
                        val telefoneError = validarTelefone(estadoTelefone.value)
                        val cpfError = validarCPF(estadoCpf.value)
                        val generoError = validarGenero(categoryGenero.value)

                        // Verifique se há erros em algum dos campos
                        if (nomeError == "" && dataNascimentoError == "" &&
                            telefoneError == "" && cpfError == "" && generoError == ""
                        ) {
                            increment()
                        } else {
                            // Exiba as mensagens de erro
                            estadoNomeError.value = nomeError
                            estadoDataNascimentoError.value = dataNascimentoError
                            estadoTelefoneError.value = telefoneError
                            estadoCpfError.value = cpfError
                            categoryGeneroError.value = generoError
                        }

                    }
                } else if (progressCount.value == 2) {
                    createButtonWithFunction(
                        textButton = "Continue",
                        corBotao = GreenKalos

                    ) {

                        validarCamposQuestoes(condicaoMedicaState, lesoesState, medicamentoState)
                        if (condicaoMedicaStateError == "" && lesoesStateError == "" && medicamentoStateError == "")
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

                        val email = localStorage.lerValor(context, "email").toString()
                        val senha = localStorage.lerValor(context, "senha").toString()
                        val nome = localStorage.lerValor(context, "nome").toString()
                        val dataNascimento =
                            localStorage.lerValor(context, "dataNascimento").toString()
                        val cpf = localStorage.lerValor(context, "cpf").toString()
                        val telefone = localStorage.lerValor(context, "telefone").toString()
                        val peso = localStorage.lerValor(context, "peso").toString()
                        val altura = localStorage.lerValor(context, "altura").toString()

                        var generoText = localStorage.lerValor(context, "genero").toString()
                        var genero: Int

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

                        val dataFormatada = formatarData(dataNascimento)

                        if (generoText == "Masculino")
                            genero = 1
                        else if (generoText == "Feminino") {
                            genero = 2
                        } else {
                            genero = 4
                        }

                        validarCampoObjetivo(objetivoState)
                        if (objetivoStateError == "") {
                            lifecycleScope.launch {
                                val body = JsonObject().apply {
                                    addProperty("email", email)
                                    addProperty("senha", senha)
                                    addProperty("nome", nome)
                                    addProperty("data_nascimento", dataFormatada)
                                    addProperty("cpf", cpf)
                                    addProperty("telefone", telefone)
                                    addProperty("id_genero", genero)
                                    addProperty("questao_condicao_medica", condicaoMedicaState)
                                    addProperty("questao_lesoes", lesoesState)
                                    addProperty("questao_medicamento", medicamentoState)
                                    addProperty("peso", peso)
                                    addProperty("altura", altura)
                                    addProperty("objetivo", objetivoState)
                                }

                                val result = alunoService.cadastrarAluno(body)

                                if (result.isSuccessful) {
                                    Log.e("CREAT-DATA", "${result.body()}")
                                    val checagem = result.body()?.get("status")
                                    if (checagem.toString() == "201") {
                                        Toast.makeText(context, "Sucesso", Toast.LENGTH_SHORT)
                                            .show()

                                        navController.navigate("fazerLogin")


                                    } else {
                                        Log.e("TAG", "Deu erro")
                                        Toast.makeText(context, "Erro ", Toast.LENGTH_SHORT).show()
                                    }


                                } else {
                                    Log.e("CREAT-DATA", result.message())
                                }
                            }


                        }


                    }
                }


            }
        }


    }
}