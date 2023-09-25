package br.senai.sp.jandira.kalos_app.screens.telaInformacoesPessoais.screen

import Calendario
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.app_kalos.components.createTitleKalos
import br.senai.sp.jandira.app_kalos.components.getLogoKalos
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.components.BarraProgresso
import br.senai.sp.jandira.kalos_app.components.CampoGenero
import br.senai.sp.jandira.kalos_app.components.Espacamento
import br.senai.sp.jandira.kalos_app.components.HeaderTelaInformacoes
import br.senai.sp.jandira.kalos_app.components.SetaParaVoltar
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CamposCriarConta
import br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.component.CampoEmailLogin
import br.senai.sp.jandira.kalos_app.screens.telaInformacoesPessoais.component.CampoCpf
import br.senai.sp.jandira.kalos_app.screens.telaInformacoesPessoais.component.CampoDataNascimento
import br.senai.sp.jandira.kalos_app.screens.telaInformacoesPessoais.component.CampoGeneroTelaInformacoesPessoais
import br.senai.sp.jandira.kalos_app.screens.telaInformacoesPessoais.component.CampoNome
import br.senai.sp.jandira.kalos_app.screens.telaInformacoesPessoais.component.CampoTelefone

@Composable
fun InformacoesPessoais(
    navController: NavController,
    localStorage: Storage,
    estadoNome: MutableState<String>,
    estadoNomeError: MutableState<String>,
    estadoDia: MutableState<String>,
    estadoMes: MutableState<String>,
    estadoAno: MutableState<String>,
    estadoDataNascimento : MutableState<String>,
    estadoDataNascimentoError: MutableState<String>,
    estadoTelefone: MutableState<String>,
    estadoTelefoneError: MutableState<String>,
    estadoCpf: MutableState<String>,
    estadoCpfError: MutableState<String>,
    categoryGenero: MutableState<String>,
    categoryGeneroError: MutableState<String>
) {
    val context = LocalContext.current


//    val estadoNome = remember {
//        mutableStateOf(estadoNome)
//    }
//
//    val estadoNomeError = remember {
//        mutableStateOf(estadoNomeError)
//    }


//    val estadoDataNascimento = remember {
//        mutableStateOf(estadoDataNascimento)
//
//    }
//    val estadoDataNascimentoError = remember {
//        mutableStateOf(estadoDataNascimentoError)
//    }
//
//    val estadoTelefone = remember {
//        mutableStateOf(estadoTelefone)
//    }
//
//    val estadoTelefoneError = remember {
//        mutableStateOf(estadoTelefoneError)
//    }
//
//
//    val estadoCpf = remember {
//        mutableStateOf(estadoCpf)
//    }
//
//    val estadoCpfError = remember {
//        mutableStateOf(estadoCpfError)
//    }
//
//    var categoryGenero = remember {
//        mutableStateOf(categoryGenero)
//    }
//    var categoryGeneroError = remember {
//        mutableStateOf(categoryGeneroError)
//    }


    HeaderTelaInformacoes(titulo = "Informações Pessoais") {
        navController.navigate("criarConta")
    }
    Espacamento(tamanho = 40.dp)


    Column(
        modifier = Modifier.fillMaxWidth()

    ) {
        Espacamento(tamanho = 20.dp)

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
        CampoNome(
            value = estadoNome.value.toString(), aoMudar = {
                estadoNome.value = it
                localStorage.salvarValor(context, estadoNome.value, "nome")

            },
            placeholder = "Digite o nome",
            isError = estadoNomeError.value.isNotEmpty()
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


            CampoDataNascimento(
                dia = estadoDia.value,
                mes = estadoMes.value,
                ano = estadoAno.value,
                aoMudarDia = {
                    estadoDia.value = it
                    estadoDataNascimentoError.value = ""
                    localStorage.salvarValor(context, it, "diaNascimento")
                },
                aoMudarMes = {
                    estadoMes.value = it
                    estadoDataNascimentoError.value = ""
                    localStorage.salvarValor(context, it, "mesNascimento")
                },
                aoMudarAno = {
                    estadoAno.value = it
                    estadoDataNascimentoError.value = ""
                    localStorage.salvarValor(context, it, "anoNascimento")
                },
                isErrorDia = estadoDataNascimentoError.value.isNotEmpty(),
                isErrorMes = estadoDataNascimentoError.value.isNotEmpty(),
                isErrorAno = estadoDataNascimentoError.value.isNotEmpty()
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

        CampoGenero(
            localStorage,
            isError = categoryGeneroError.value.isNotEmpty(),
            categoria = categoryGenero
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
        CampoTelefone(
            value = estadoTelefone.value.toString(), aoMudar = {
                estadoTelefone.value = it
                localStorage.salvarValor(context, estadoTelefone.value, "telefone")
            }, placeholder = "Digite o telefone",
            isError = estadoTelefoneError.value.isNotEmpty()
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
        CampoCpf(
            value = estadoCpf.value.toString(), aoMudar = {
                estadoCpf.value = it
                localStorage.salvarValor(context, estadoCpf.value, "cpf")
            }, placeholder = "Digite o cpf",
            isError = estadoCpfError.value.isNotEmpty()
        )
        Espacamento(tamanho = 20.dp)


    }


}