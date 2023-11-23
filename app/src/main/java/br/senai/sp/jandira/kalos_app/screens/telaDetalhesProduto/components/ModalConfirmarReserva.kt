package br.senai.sp.jandira.kalos_app.screens.telaDetalhesProduto.components

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.LifecycleCoroutineScope
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.service.ReservaService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import java.text.DecimalFormat

@Composable
fun ModalConfirmarReserva(nomeProduto: String, valor: Double, cor: String,  lifecycleCoroutineScope: LifecycleCoroutineScope, localStorage: Storage, onClick: () -> Unit,) {
    val color = android.graphics.Color.parseColor(cor)

    lateinit var reservaService: ReservaService
    reservaService = RetrofitHelper.getInstance().create(ReservaService::class.java)

    var quantidade by remember {
        mutableStateOf(1)
    }

    var confirmarModal by remember {
        mutableStateOf(false)
    }

    var statusConfirmacao by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    val idAluno = localStorage.lerValor(context, "idAluno")?.toInt()
    val idProduto = localStorage.lerValor(context, "idProduto")?.toInt()


//    var isVisible by remember { mutableStateOf(true) }
//
//    val alpha by animateFloatAsState(
//        targetValue = if (isVisible) 1f else 0f,
//        animationSpec = tween(durationMillis = 1000), label = ""
//    )

    if(statusConfirmacao){
        lifecycleCoroutineScope.launch {
            val body = JsonObject().apply {
                addProperty("quantidade" , quantidade.toString())
                addProperty("total", DecimalFormat("0.00").format(valor * quantidade).replace('.', ',').toString())
                addProperty("id_produto", idProduto)
                addProperty("id_aluno", idAluno)
                addProperty("id_status_reserva", 3 )
            }

            var result = reservaService.fazerReserva(body)
            if(result.isSuccessful){

            }else{
                Toast.makeText(context, "Reserva deu erro " ,Toast.LENGTH_LONG ).show()
            }

        }
    }

    if (confirmarModal) {
        Surface(
            modifier = Modifier
                .height(150.dp)
                .width(320.dp)
            //.background(Color.Black)
            ,
            color = Color(96, 96, 96),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Produto reservado com sucesso!", //fazer verificacao pra se deu certo
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Você pode conferir mais detalhes sobre sua reserva na aba de 'Reservas'!", //fazer verificacao pra se deu certo
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    } else {
        Surface(
            modifier = Modifier
                .height(190.dp)
                .width(320.dp)
            //.background(Color.Black)
            ,
            color = Color(96, 96, 96),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Confirmar reserva",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                    Image(
                        painter = painterResource(id = R.drawable.x),
                        contentDescription = null,
                        modifier = Modifier
                            .size(15.dp)
                            .clickable {
                                onClick()
                            },
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                }




                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.White)
                )

                Text(
                    text = nomeProduto,
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp
                )

                Surface(
                    modifier = Modifier
                        .width(130.dp)
                        .height(33.dp),
                    border = BorderStroke(1.dp, Color.White),
                    color = Color.Transparent,
                    shape = RoundedCornerShape(30.dp)
                ) {

                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "-",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(start = 2.dp, bottom = 3.dp)
                                .clickable {
                                    if (quantidade == 1) {
                                        quantidade
                                    } else {
                                        quantidade -= 1
                                    }
                                }
                        )


                        Box(
                            modifier = Modifier
                                .width(1.dp)
                                .height(33.dp)
                                .background(Color.White)
                        )

                        Text(
                            text = "${quantidade}",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(start = 7.dp, end = 7.dp)
                        )

                        Box(
                            modifier = Modifier
                                .width(1.dp)
                                .height(33.dp)
                                .background(Color.White)
                        )

                        Text(
                            text = "+",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(end = 2.dp, bottom = 3.dp)
                                .clickable {
                                    quantidade = quantidade + 1
                                }
                        )


                    }


                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "R$ ${
                            DecimalFormat("0.00").format(valor * quantidade).replace('.', ',')
                        }",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Button(
                        onClick = {
                            confirmarModal = true
                            statusConfirmacao = true
                        },
                        colors = ButtonDefaults.buttonColors(Color(color))
                    ) {
                        Text(
                            text = "Confirmar",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Modal() {
    Dialog(onDismissRequest = { }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(
                text = "This is a minimal dialog",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center,
            )
        }
    }
}

//@Preview
//@Composable
//fun ModalConfirmarReservaPreview() {
//    ModalConfirmarReserva("Garrafinha 800ml", 17.99, "#34439E") {}
//}