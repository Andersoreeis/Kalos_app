package br.senai.sp.jandira.kalos_app.screens.telaPerfil.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import br.senai.sp.jandira.app_kalos.components.createButtonWithFunction
import br.senai.sp.jandira.app_kalos.components.createButtonWithWidth
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.kalos_app.components.Espacamento
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos

@Composable
fun ConfirmacaoDeslogarDialog(
    exibirDialog: Boolean,
    onClose: () -> Unit,
    onConfirm: () -> Unit
) {
    if (exibirDialog) {
        Column(
            modifier = Modifier
                .width(400.dp)
                .height(180.dp)
                .background(Color(23, 23, 23))
                .padding(20.dp).offset(y = 80.dp).zIndex(10.0f)
                .border(2.dp, Color.White, RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(20.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Espacamento(tamanho = 50.dp)

            createTextKalos(
                content = "Deseja sair mesmo?",
                sizeText = 24,
                colorText = Color.White,
                bold = 700,
                alinhamento = TextAlign.Center
            )

            Espacamento(tamanho = 50.dp)

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                createButtonWithWidth(
                    textButton = "Cancelar",
                    corBotao = Color.Red,
                    width = 120.dp
                ) {
                    onClose()
                }

                Spacer(modifier = Modifier.width(30.dp))

                createButtonWithWidth(
                    textButton = "Continuar",
                    corBotao = GreenKalos,
                    width = 120.dp
                ) {
                    onConfirm()
                }
            }
        }
    }
}

