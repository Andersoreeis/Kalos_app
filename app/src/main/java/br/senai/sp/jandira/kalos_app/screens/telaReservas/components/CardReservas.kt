package br.senai.sp.jandira.kalos_app.screens.telaReservas.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import br.senai.sp.jandira.app_kalos.components.createButtonWithFunction4
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.service.ReservaService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

@Composable
fun CardReservas(
    nomeProduto: String,
    imagem: String,
    dataReserva: String,
    quantidade: String,
    valor: String,
    codigoProduto: String,
    status: String, mutableState: MutableState<Boolean>,
    onClick: () -> Unit
) {

//    val nomeProduto = "Whey Protein 907g"
//    val imagem = ""
//    val dataReserva = "01/07/2023"
//    val quantidade = "2"
//    val valor = "285,50"
//    val status = "Recebido"


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Surface(
                modifier = Modifier.size(160.dp),
                shape = RoundedCornerShape(15.dp)
            ) {
                AsyncImage(
                    model = imagem,
                    contentDescription = stringResource(R.string.foto_do_produto),
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    error = painterResource(id = R.drawable.produto)
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = nomeProduto,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(1000)
                )

                Text(
                    text = "$codigoProduto",
                    color = Color.White,
                    fontSize = 10.sp,
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Reservado em $dataReserva",
                    color = Color.White,
                    fontSize = 13.sp,
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Quantidade: ${quantidade}",
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "R$ $valor",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                if (status.lowercase() == "recebido") {
                    createButtonWithFunction4(textButton = status, corBotao = GreenKalos) {

                    }
                } else if (status.lowercase() == "cancelado") {
                    createButtonWithFunction4(textButton = status, corBotao = Color.Red) {

                    }
                } else if (status.lowercase() == "em análise") {
                    Column {
                        createButtonWithFunction4(textButton = status, corBotao = Color.Yellow) {

                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        
                        createButtonWithFunction4(textButton = "Cancelar", corBotao = Color.Red) {
                            mutableState.value = true

                            onClick()
                        }
                    }

                } else if (status.lowercase() == "pronto para retirada"){
                    createButtonWithFunction4(textButton = status, corBotao = GreenKalos) {

                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    createButtonWithFunction4(textButton = "Cancelar", corBotao = Color.Red) {
                        mutableState.value = true

                        onClick()

                    }
                }

                var heightSpacer: Dp = if(status.lowercase() == "em análise" || status.lowercase() == "pronto para retirada"){
                    12.dp
                } else {
                    45.dp
                }

                Spacer(modifier = Modifier.height(heightSpacer))

            }
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = GrayKalos
        ) {}
    }

}