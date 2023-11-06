package br.senai.sp.jandira.kalos_app.screens.telaHomeAcademia.screen


import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createTextKalos
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.components.Espacamento
import br.senai.sp.jandira.kalos_app.components.SetaParaVoltar
import br.senai.sp.jandira.kalos_app.components.SetaParaVoltar2
import br.senai.sp.jandira.kalos_app.model.BottomNavigationItem
import br.senai.sp.jandira.kalos_app.model.ExercicioResponse
import br.senai.sp.jandira.kalos_app.model.TreinoComExercicio
import br.senai.sp.jandira.kalos_app.screens.telaBuscarAcademias.screens.BuscarAcademias
import br.senai.sp.jandira.kalos_app.screens.telaHome.components.HomeAluno
import br.senai.sp.jandira.kalos_app.screens.telaHomeAcademia.components.TelaTreinos
import br.senai.sp.jandira.kalos_app.screens.telaPerfil.screen.TelaPerfil
import br.senai.sp.jandira.kalos_app.screens.telaPostagens.screen.TelaPostagens
import br.senai.sp.jandira.kalos_app.screens.telaProdutos.screen.TelaProdutos
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.service.TreinoService
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalosEscuro
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SuspiciousIndentation")
@Composable
fun TelaHomeAcademia(
    navController: NavController,
    lifecycleCoroutineScope: LifecycleCoroutineScope,
    localStorage: Storage
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

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
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
                    color = GrayKalos
                ) {
                    if (fotoAcademia!!.isNotEmpty() || fotoAcademia.isNotBlank()) {
                        AsyncImage(
                            model = fotoAcademia,
                            contentDescription = "foto academia",
                            modifier = Modifier
                                .size(200.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop,
                            error = painterResource(id = R.drawable.ginasio)
                        )
                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.ginasio),
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
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
                alinhamento = TextAlign.Center
            )

            Espacamento(tamanho = 5.dp)
            val tagsList = tagsAcademia?.split(", ") ?: emptyList()

            if (tagsList.isNotEmpty() && tagsList.any { it.isNotBlank() }) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFF393939))
                )

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
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFF393939))
                )
            }

            Espacamento(tamanho = 15.dp)

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
            var cidade = localStorage.lerValor(context, "cidadeAcademia")
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .background(corPrimaria, shape = RoundedCornerShape(40.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_location_on_24),
                        contentDescription = null,
                        tint = corSegundaria
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = " ${logradouroAcademia.toString()}, ${numeroAcademia.toString()} - ${cidade.toString()}",
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
                Row(verticalAlignment = Alignment.CenterVertically) {
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

            Espacamento(tamanho = 26.dp)
            val items = listOf(
                "Posts",
                "Produtos",
                "Treinos",
                "Informações"
            )

                NavigationBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black),
                    containerColor = Color.Black
                ) {
                    Column {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .zIndex(10.0f)
                                .offset(y = 1.dp)
                                .background(Color(0xFF393939))
                                .padding(bottom = 5.dp)
                        )

                        Row(

                        ) {
                            items.forEachIndexed { index, item ->

                                this@NavigationBar.NavigationBarItem(
                                    selected = selectedItemIndex == index,
                                    onClick = {
                                        selectedItemIndex = index
                                        // navController.navigate(item.title)
                                    },
                                    icon = {

                                    },
                                    label = {
                                        Text(text = item)
                                    },
                                    modifier = if(selectedItemIndex==index){
                                        Modifier
                                            .background(Color.Black)
//                                            .border(
//                                                2.dp,
//                                                Color.Gray,
//                                                shape = RoundedCornerShape(20.dp)
//                                            )
                                            .height(40.dp)
                                            .zIndex(11.0f)
                                    } else{
                                        Modifier
                                            .background(Color.Black)
                                            .height(40.dp)     },


                                    colors = NavigationBarItemDefaults.colors(
                                        selectedTextColor = corPrimaria,
                                        indicatorColor = Color.Transparent,
                                        unselectedTextColor = Color.White
                                    )
                                )
                            }
                        }


                    }

                }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (selectedItemIndex == 1) {
                   TelaProdutos(lifecycleCoroutineScope, corPrimariaAcademia!!, navController)
                } else if (selectedItemIndex == 2) {
                    TelaTreinos(lifecycleCoroutineScope, localStorage, navController)
                } else if(selectedItemIndex == 3) {
                    Text(text = "informaçoes", color = Color.White)
                }else{
                    TelaPostagens(lifecycleCoroutineScope,localStorage)
                }
            }







        }
    }

}

