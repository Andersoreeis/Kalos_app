package br.senai.sp.jandira.kalos_app.screens.telaBuscarAcademias.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.components.Espacamento
import br.senai.sp.jandira.kalos_app.model.AcademiaResponse
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalosEscuroCard
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AcademiaCard(
    academia: AcademiaResponse,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .height(150.dp)
            .background(
                GrayKalosEscuroCard
            ).border(
                width = 2.dp,
                color = Color(80, 80, 80),
                shape = RoundedCornerShape(20.dp)
            ).clickable { onClick() }


    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    GrayKalosEscuroCard
                ),


            ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.padding(10.dp)) {
                    AsyncImage(
                        model = academia.foto,
                        contentDescription = "foto academia",
                        modifier = Modifier
                            .width(110.dp)
                            .height(110.dp)
                            .clip(CircleShape)
                    )
                }



                Column(modifier = Modifier.width(100.dp)) {
                    createTextKalos(
                        content = academia.nome.toString(),
                        sizeText = 21,
                        colorText = Color.White,
                        bold = 700,
                        alinhamento = TextAlign.Start
                    )
                    Espacamento(tamanho = 5.dp)

                    createTextKalos(
                        content = "Academia",
                        sizeText = 14,
                        colorText = Color.White,
                        bold = 400,
                        alinhamento = TextAlign.Start
                    )
                    Espacamento(tamanho = 15.dp)

                    createTextKalos(
                        content = academia.numero_endereco.toString(),
                        sizeText = 10,
                        colorText = Color.White,
                        bold = 400,
                        alinhamento = TextAlign.Start
                    )

                    Espacamento(tamanho = 2.dp)

                    createTextKalos(
                        content = academia.telefone.toString(),
                        sizeText = 5,
                        colorText = Color.White,
                        bold = 400,
                        alinhamento = TextAlign.Start
                    )
                }

                Row(
                    modifier = Modifier.width(100.dp),

                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    var teste1 = 1
                    var teste2 = 2
                    var teste3 = 3

                    if (teste1 == 1) {
                        Image(
                            painter = painterResource(id = R.drawable.brainle_icone),
                            contentDescription = "",
                            modifier = Modifier
                                .size(30.dp)
                                .padding(3.dp)
                        )

                    }
                    if (teste2 == 2) {
                        Image(
                            painter = painterResource(id = R.drawable.cadeirante_icone),
                            contentDescription = "",
                            modifier = Modifier
                                .size(30.dp)
                                .padding(3.dp)
                        )


                    }
                    if (teste3 == 3) {
                        Image(
                            painter = painterResource(id = R.drawable.libras_icone),
                            contentDescription = "",
                            modifier = Modifier
                                .size(30.dp)
                                .padding(3.dp)
                        )
                    }
                }
            }
        }
    }
}

