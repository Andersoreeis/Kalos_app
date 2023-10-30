package br.senai.sp.jandira.kalos_app.screens.telaBuscarAcademias.components

import android.util.Log
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
import androidx.compose.ui.layout.ContentScale
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
    Log.i("academia", "$academia")
    Card(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .height(150.dp)
            .background(
                GrayKalosEscuroCard
            )
            .border(
                width = 2.dp,
                color = Color(80, 80, 80),
                shape = RoundedCornerShape(20.dp)
            )
            .clickable { onClick() }


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
                    if (academia.foto!!.isNotEmpty()) {
                        AsyncImage(
                            model = academia.foto,
                            contentDescription = "foto academia",
                            modifier = Modifier
                                .width(110.dp)
                                .height(110.dp)
                                .clip(CircleShape),
                            error = painterResource(id = R.drawable.ginasio),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.ginasio),
                            contentDescription = null,
                            modifier = Modifier
                                .size(110.dp)
                                .clip(
                                    CircleShape
                                )
                        )
                    }

                }



                Column(modifier = Modifier.fillMaxWidth()) {
                    createTextKalos(
                        content = academia.nome.toString(),
                        sizeText = 21,
                        colorText = Color.White,
                        bold = 700,
                        alinhamento = TextAlign.Start
                    )
                    Espacamento(tamanho = 5.dp)

                    createTextKalos(
                        content = academia.categoria.toString(),
                        sizeText = 14,
                        colorText = Color.White,
                        bold = 400,
                        alinhamento = TextAlign.Start
                    )
                    Espacamento(tamanho = 15.dp)

                    createTextKalos(
                        content = "${academia.logradouro} - ${academia.numero}, ${academia.bairro}, ${academia.cidade} - ${academia.estado}",
                        sizeText = 10,
                        colorText = Color.White,
                        bold = 400,
                        alinhamento = TextAlign.Start
                    )

                    Espacamento(tamanho = 5.dp)

                    createTextKalos(
                        content = academia.telefone.toString(),
                        sizeText = 10,
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

                    }
                }
            }
        }
    }


