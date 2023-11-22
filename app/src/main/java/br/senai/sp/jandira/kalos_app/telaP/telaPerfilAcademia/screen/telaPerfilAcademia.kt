package br.senai.sp.jandira.kalos_app.telaP.telaPerfilAcademia.screen

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.zIndex
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.components.Espacamento
import br.senai.sp.jandira.kalos_app.components.SetaParaVoltar2
import br.senai.sp.jandira.kalos_app.model.PostagensResponse
import br.senai.sp.jandira.kalos_app.screens.telaPostagens.components.CardPostagem
import br.senai.sp.jandira.kalos_app.service.PostagemService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TelaPerfilAcademia(
    navController: NavController,
    localStorage: br.senai.sp.jandira.kalos_app.Storage,
    lifecycleCoroutineScope: LifecycleCoroutineScope
) {

    val context = LocalContext.current
    var alunoAtivo: String? = localStorage.lerValor(context, "alunoAtivoNaAcademia")
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
    var enderecoAcademia = localStorage.lerValor(context, "enderecoAcademia")

    val corPrimariaAcademia = localStorage.lerValor(context, "corPrimariaAcademia")
    val corPrimaria = Color(android.graphics.Color.parseColor(corPrimariaAcademia ?: "#353535"))

    val corSegundariaAcademia = localStorage.lerValor(context, "corSegundariaAcademia")
    val tagsAcademia = localStorage.lerValor(context, "tagsAcademia")

    val corSegundaria = if (corSegundariaAcademia == corPrimariaAcademia) {
        if (corSegundariaAcademia == "#FFFFFF") {
            Color.Black
        } else {
            Color.White
        }
    } else {
        Color(android.graphics.Color.parseColor(corSegundariaAcademia ?: "#353535"))
    }



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
                tint = corSegundaria,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(262.dp)
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(186.dp)
                    .clip(RoundedCornerShape(0.dp, 0.dp, 50.dp, 50.dp)),
                color = corPrimaria,
            ) {

                SetaParaVoltar2(navController = navController, navName = "home", corSegundaria)


            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 62.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Surface(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .size(200.dp),
                    color = Color(0xFF393939)
                ) {
                    if (fotoAcademia!!.isNotEmpty() || fotoAcademia.isNotBlank()) {
                        AsyncImage(
                            model = fotoAcademia,
                            contentDescription = "foto academia",
                            modifier = Modifier
                                .size(200.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop,
                            error = painterResource(id = R.drawable.defaultimg)
                        )
                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.defaultimg),
                            contentDescription = null,
                            modifier = Modifier
                                .size(110.dp)
                                .clip(CircleShape)
                        )
                    }
                }

            }
        }
        Espacamento(tamanho = 20.dp)

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
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
                colorText = Color.White,
                bold = 400,
                alinhamento = TextAlign.Center,
                modifier = Modifier.padding(20.dp)
            )

            Espacamento(tamanho = 5.dp)
            val tagsList = tagsAcademia?.split(", ") ?: emptyList()
            Spacer(
                modifier = Modifier
                    .width(370.dp)
                    .height(1.dp)
                    .background(Color(0xFF393939))
            )
            if (tagsList.isNotEmpty() && tagsList.any { it.isNotBlank() }) {


                Espacamento(tamanho = 5.dp)


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
                        .width(370.dp)
                        .height(1.dp)
                        .background(Color(0xFF393939))
                )
            }

            Espacamento(tamanho = 20.dp)

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
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {
                    val gmmIntentUri = Uri.parse("geo:0,0?q=$enderecoAcademia")
                    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)

                    // Verifica se o aplicativo do Google Maps está instalado
                    //if (mapIntent.resolveActivity(context.packageManager) != null) {
                        context.startActivity(mapIntent)
                    //}
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_location_on_24),
                        contentDescription = null,
                        tint = corSegundaria
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = enderecoAcademia.toString(),
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
                Row(verticalAlignment = Alignment.CenterVertically, modifier =  Modifier.clickable {
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel: ${telefoneAcademia}")
                    context.startActivity(intent)
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_local_phone_24),
                        contentDescription = null,
                        tint = corSegundaria
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



            Spacer(modifier = Modifier.height(20.dp))

            Spacer(
                modifier = Modifier
                    .width(370.dp)
                    .height(1.dp)
                    .background(Color(0xFF393939))
            )


            Column(
                modifier = Modifier
                    .height(300.dp)
                    .background(Color.Black)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
//                createTextKalos(
//                    content = "Entre em contato com a academia para se matricular nessa academia e ter acesso completo!",
//                    sizeText = 12,
//                    colorText = Color.White,
//                    bold = 400,
//                    alinhamento = TextAlign.Center
//                )

                lateinit var postagemService: PostagemService
                postagemService = RetrofitHelper.getInstance().create(PostagemService::class.java)

                var listaPostagens by remember {
                    mutableStateOf(listOf<PostagensResponse>())
                }


                val context = LocalContext.current
                var status by remember {
                    mutableStateOf(false)
                }

                lifecycleCoroutineScope.launch {
                    val result = postagemService.getTodasPostagens(
                        localStorage.lerValor(context, "idAcademia").toString()
                    )
                    Log.e("result", "TelaPostagens: ${result.body()}")
                    if (result.isSuccessful) {
                        listaPostagens = result.body()!!.postagens!!
                        status = true
                    }
                }
                if (status) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1000.dp)
                            .padding(horizontal = 10.dp)

                    ) {

                        LazyColumn() {
                            items(listaPostagens) {

                                CardPostagem(
                                    titulo = it.titulo!!,
                                    foto = it.anexo,
                                    descricao = it.corpo!!,
                                    data = it.data!!,
                                    hora = it.hora!!
                                )

                                Spacer(modifier = Modifier.height(30.dp))
                            }
                        }


                    }
                }else {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1000.dp)
                            .padding(horizontal = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                    }
                }
            }


        }
    }
}
