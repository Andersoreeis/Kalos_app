package br.senai.sp.jandira.kalos_app.screens.telaInformacoesPessoais.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createTitleKalos
import br.senai.sp.jandira.app_kalos.components.getLogoKalos
import br.senai.sp.jandira.kalos_app.components.BarraProgresso
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
fun InformacoesPessoais(navController: NavController) {

    val estadoNome = remember {
        mutableStateOf("")
    }

    val estadoDataNascimento = remember {
        mutableStateOf("")
    }

    val estadoTelefone = remember {
        mutableStateOf("")
    }


    val estadoCpf = remember {
        mutableStateOf("")
    }


    HeaderTelaInformacoes(titulo ="Informações Pessoais" ) {
        navController.navigate("criarConta")
    }
    Espacamento(tamanho = 40.dp)


    Column(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Espacamento(tamanho = 20.dp)

            CampoNome(
                value = estadoNome.value.toString(),
                aoMudar = { estadoNome.value = it },
                placeholder = "Digite o nome"
            )
            Espacamento(tamanho = 20.dp)

            CampoDataNascimento(
                value = estadoDataNascimento.value.toString(),
                aoMudar = { estadoDataNascimento.value = it },
                placeholder = "Digite a data de nascimento"
            )
            Espacamento(tamanho = 20.dp)

            CampoGeneroTelaInformacoesPessoais()
            Espacamento(tamanho = 20.dp)


            CampoTelefone(
                value = estadoTelefone.value.toString(),
                aoMudar = { estadoTelefone.value = it },
                placeholder = "Digite o telefone"
            )
            Espacamento(tamanho = 20.dp)


            CampoCpf(
                value = estadoCpf.value.toString(),
                aoMudar = { estadoCpf.value = it },
                placeholder = "Digite o cpf"
            )
            Espacamento(tamanho = 20.dp)



        }



}