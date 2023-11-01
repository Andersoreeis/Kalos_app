package br.senai.sp.jandira.kalos_app.screens.telaDetalhesProduto.screen

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesProduto.components.HeaderProduto
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesProduto.components.ImagemProduto
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesProduto.components.ModalConfirmarReserva
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesProduto.components.PrecoReserva
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import kotlinx.coroutines.delay

@Composable
fun TelaDetalhesProduto(navController: NavController) {
    var modalConfirmacao by remember {
        mutableStateOf(false)
    }
//    var isVisible by remember { mutableStateOf(true) }
//
//    val alpha by animateFloatAsState(
//        targetValue = if (isVisible) 1f else 0f,
//        animationSpec = tween(durationMillis = 1000), label = ""
//    )

    //clicou no botao
    if (modalConfirmacao) {
        Box(modifier = Modifier.fillMaxSize().clickable { modalConfirmacao = false }) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .padding(8.dp)
                        .clickable { navController.navigate("homeAcademia") }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_chevron_left_24),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                    )
                }



                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.padding(16.dp)
                    ) {
                        items(count = 5) {
                            ImagemProduto(
                                imagem = "https://images.unsplash.com/photo-1519160926177-c64030fde1d6?auto=format&fit=crop&q=80&w=3840&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            ImagemProduto(
                                imagem = "https://images.unsplash.com/photo-1543966357-d5fe7c4211bd?auto=format&fit=crop&q=80&w=3945&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        HeaderProduto(
                            "Garrafinha 800ml",
                            "#1141",
                            "Acessórios",
                            "#34439E",
                            "A parceira perfeita para se manter hidratado durante seus treinos! Com um design elegante e capacidade generosa, você terá água fresca sempre à mão. Perfeita para te acompanhar onde quer que você vá."
                        )

                        PrecoReserva("#34439E", "39,90") {
                            //modalConfirmacao = true
                        }
                    }

                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(16, 16, 16, 210)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ModalConfirmarReserva(
                    nomeProduto = "Garrafinha 800ml",
                    valor = 39.90,
                    cor = "#34439E"
                ){
                    modalConfirmacao = false
                }
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .padding(8.dp)
                    .clickable { navController.navigate("homeAcademia") }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_chevron_left_24),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }



            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(16.dp)
                ) {
                    items(count = 5) {
                        ImagemProduto(
                            imagem = "https://images.unsplash.com/photo-1519160926177-c64030fde1d6?auto=format&fit=crop&q=80&w=3840&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        ImagemProduto(
                            imagem = "https://images.unsplash.com/photo-1543966357-d5fe7c4211bd?auto=format&fit=crop&q=80&w=3945&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    HeaderProduto(
                        "Garrafinha 800ml",
                        "#1141",
                        "Acessórios",
                        "#34439E",
                        "A parceira perfeita para se manter hidratado durante seus treinos! Com um design elegante e capacidade generosa, você terá água fresca sempre à mão. Perfeita para te acompanhar onde quer que você vá."
                    )

                    PrecoReserva("#34439E", "39,90") {
                        modalConfirmacao = true
                        Log.i("valor modal", modalConfirmacao.toString())
                    }
                }

            }
        }

    }

}

@Preview
@Composable
fun TelaDetalhesProdutoPreview() {
    TelaDetalhesProduto(NavController(LocalContext.current))
}