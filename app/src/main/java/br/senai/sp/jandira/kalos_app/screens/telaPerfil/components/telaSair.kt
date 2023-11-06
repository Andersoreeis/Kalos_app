package br.senai.sp.jandira.kalos_app.screens.telaPerfil.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createButtonWithWidth
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.components.Espacamento
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos

@Composable
fun ConfirmacaoDeslogarDialog(
    exibirDialog: Boolean,
    onClose: () -> Unit,
    onConfirm: () -> Unit,
    localStorage: Storage,
    navController: NavController

) {
    var context = LocalContext.current

    if (exibirDialog) {

        Surface(
            modifier = Modifier
                .width(400.dp)
                .height(200.dp)
                .padding(20.dp)
                .zIndex(10.0f),
            shape = RoundedCornerShape(20.dp),
            color = Color(96, 96, 96)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                createTextKalos(
                    content = "Deseja sair mesmo?",
                    sizeText = 24,
                    colorText = Color.White,
                    bold = 700,
                    alinhamento = TextAlign.Center
                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    createButtonWithWidth(
                        textButton = "Cancelar",
                        corBotao = Color.Red,
                        width = 150.dp
                    ) {
                        onClose()
                    }


                    createButtonWithWidth(
                        textButton = "Continuar",
                        corBotao = GreenKalos,
                        width = 150.dp
                    ) {
                        onConfirm()
                        localStorage.salvarValor(context, "", "idAluno")
                        navController.navigate("fazerLogin")

                    }
                }
            }

        }
    }

}

@Preview
@Composable
fun Preview() {
    var exibirDialog = remember { mutableStateOf(false) }
    ConfirmacaoDeslogarDialog(
        exibirDialog = exibirDialog.value,
        onClose = {
            exibirDialog.value = false
        },
        onConfirm = {
            exibirDialog.value = false


        },
        Storage(),
        NavController(LocalContext.current)
    )
}

