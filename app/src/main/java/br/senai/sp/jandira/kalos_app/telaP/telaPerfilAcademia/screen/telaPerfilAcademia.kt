package br.senai.sp.jandira.kalos_app.telaP.telaPerfilAcademia.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.components.Espacamento
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.transform.CircleCropTransformation
import com.google.android.gms.auth.api.signin.internal.Storage

@Composable
fun TelaPerfilAcademia(
    navController: NavController,
    localStorage: br.senai.sp.jandira.kalos_app.Storage
) {

    val context = LocalContext.current
    var nomeAcademia = localStorage.lerValor(context, "nomeAcademia")
    var telefoneAcademia = localStorage.lerValor(context, "telefoneAcademia")
    var emailAcademia = localStorage.lerValor(context, "emailAcademia")
    var instagramAcademia = localStorage.lerValor(context, "instagramAcademia")
    var facebookAcademia = localStorage.lerValor(context, "facebookAcademia")
    var whatsappAcademia = localStorage.lerValor(context, "whatsappAcademia")
    var fotoAcademia = localStorage.lerValor(context, "fotoAcademia")
    var descricaoAcademia = localStorage.lerValor(context, "descricaoAcademia")
    var logradouroAcademia = localStorage.lerValor(context, "logradouroAcademia")
    var numeroAcademia = localStorage.lerValor(context, "numeroAcademia")

    val corPrimariaAcademia = localStorage.lerValor(context, "corPrimariaAcademia")
    val corPrimaria = Color(android.graphics.Color.parseColor(corPrimariaAcademia ?: "#353535"))

    val corSegundariaAcademia = localStorage.lerValor(context, "corSegundariaAcademia")
    val corSegundaria = Color(android.graphics.Color.parseColor(corSegundariaAcademia ?: "#353535"))
    val tagsAcademia = localStorage.lerValor(context, "tagsAcademia")

    @Composable
    fun TagItem(text: String) {
        Box(
            modifier = Modifier
                .padding(4.dp)
                .height(36.dp)
                .background(corPrimaria, shape = RoundedCornerShape(8.dp))
                .padding(horizontal = 8.dp, vertical = 4.dp),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = text,
                color = corSegundaria,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
        }
    }

    @Composable
    fun SocialIcon(
        resourceId: Int,
        contentDescription: String,
        onClick: () -> Unit
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(corPrimaria)
                .padding(8.dp)
                .clickable { onClick.invoke() }
        ) {
            Icon(
                painter = painterResource(id = resourceId),
                contentDescription = contentDescription,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(186.dp)
                .clip(shape = RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp))
                .background(corPrimaria)
        ) {


        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = -110.dp), contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    model = fotoAcademia,
                    contentDescription = "foto academia",
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,

                    )
                Espacamento(tamanho = 20.dp)
                createTextKalos(
                    content = nomeAcademia.toString(),
                    sizeText = 24,
                    colorText = corPrimaria,
                    bold = 700,
                    alinhamento = TextAlign.Center
                )

                Espacamento(tamanho = 10.dp)

                createTextKalos(
                    content = descricaoAcademia.toString(),
                    sizeText = 12,
                    colorText = corSegundaria,
                    bold = 400,
                    alinhamento = TextAlign.Center
                )
                Espacamento(tamanho = 5.dp)

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.Gray)
                )
                Espacamento(tamanho = 5.dp)

                val tagsList = tagsAcademia?.split(", ") ?: emptyList()

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    items(tagsList) { tag ->
                        TagItem(text = tag)
                    }
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.Gray)
                )
                Espacamento(tamanho = 5.dp)


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (instagramAcademia!!.isNotEmpty()) {
                        SocialIcon(
                            resourceId = R.drawable.instagram,
                            contentDescription = "Instagram",
                            onClick = {
                                // Redirecione para o Instagram aqui
                            }
                        )
                    }

                    if (facebookAcademia!!.isNotEmpty()) {
                        SocialIcon(
                            resourceId = R.drawable.facebook,
                            contentDescription = "Facebook",
                            onClick = {
                                // Redirecione para o Facebook aqui
                            }
                        )
                    }

                    if (whatsappAcademia!!.isNotEmpty()) {
                        SocialIcon(
                            resourceId = R.drawable.whatsapp,
                            contentDescription = "WhatsApp",
                            onClick = {
                                // Redirecione para o WhatsApp aqui
                            }
                        )
                    }
                }




                Espacamento(tamanho = 20.dp)


                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .background(corPrimaria, shape = RoundedCornerShape(40.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_location_on_24),
                            contentDescription = null,
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = logradouroAcademia.toString(),
                            color = corSegundaria,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                    }
                }

                Espacamento(tamanho = 5.dp)

                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .background(corPrimaria, shape = RoundedCornerShape(40.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_local_phone_24),
                            contentDescription = null,
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = telefoneAcademia.toString(),
                            color = corSegundaria,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                    }


                }

                Column(
                    modifier = Modifier
                        .height(300.dp)
                        .background(Color.Black)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    createTextKalos(
                        content = "Entre em contato com a academia para se matricular nessa academia e ter acesso completo!",
                        sizeText = 12,
                        colorText = Color.White,
                        bold = 400,
                        alinhamento = TextAlign.Center
                    )
                }

            }


        }

    }


}








