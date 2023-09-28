package br.senai.sp.jandira.kalos_app.screens.telaHome.screen

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.model.AlunoResponse
import br.senai.sp.jandira.kalos_app.model.BottomNavigationItem
import br.senai.sp.jandira.kalos_app.screens.telaBuscarAcademias.screens.BuscarAcademias
import br.senai.sp.jandira.kalos_app.screens.telaHome.components.HomeAluno
import br.senai.sp.jandira.kalos_app.screens.telaPerfil.screen.TelaPerfil
import br.senai.sp.jandira.kalos_app.service.AlunoService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalosEscuro
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TelaHome(navController: NavController, lifecycleScope: LifecycleCoroutineScope ,localStorage: Storage) {
    val context = LocalContext.current
    var aluno by remember {
        mutableStateOf(AlunoResponse(1,"","","","",
            "","","","","","",
            "","",""))
    }
    val items = listOf(
        BottomNavigationItem(
            title = "procurar",
            selectedIcon = Icons.Filled.Search,
            unselectedIcon = Icons.Outlined.Search,

            ),
        BottomNavigationItem(
            title = "home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
        ),
        BottomNavigationItem(
            title = "perfil",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,

            ),
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(1)
    }

    Scaffold(
        containerColor = Color.Companion.Black,
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .height(75.dp),
                containerColor = Color.Black
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(GrayKalosEscuro)
                            .height(50.dp)
                            .width(300.dp),

                        ) {
                        Row {
                            items.forEachIndexed { index, item ->
                                this@NavigationBar.NavigationBarItem(
                                    selected = selectedItemIndex == index,
                                    onClick = {
                                        selectedItemIndex = index
                                        // navController.navigate(item.title)
                                    },
                                    alwaysShowLabel = false,
                                    icon = {
                                        Icon(
                                            imageVector = if (index == selectedItemIndex) {
                                                item.selectedIcon
                                            } else item.unselectedIcon,
                                            contentDescription = item.title,
                                            tint = if (index == selectedItemIndex) {
                                                GreenKalos
                                            } else Color.White,
                                            modifier = Modifier.size(30.dp)
                                        )

                                    }
                                )
                            }
                        }

                    }
                }


            }
        }
    ) {
        lateinit var alunoService: AlunoService
        alunoService = RetrofitHelper.getInstance().create(AlunoService::class.java)

        val idALuno = localStorage.lerValor(context, "idAluno")

        var status by remember {
            mutableStateOf(false)
        }

        lifecycleScope.launch {
            val result = alunoService.getAlunoByID(idALuno.toString())

            if (result.isSuccessful) {

                aluno = result.body()?.data!!
                Log.e("aluno", "TelaHome: ${aluno}")
                status = true
            }
        }

        if(status){
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (selectedItemIndex == 1) {
                    HomeAluno(aluno, navController)
                } else if (selectedItemIndex == 2) {
                    TelaPerfil(aluno, navController)
                } else {
                    BuscarAcademias(lifecycleScope)
                }
            }
        }else{
            Column (
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                CircularProgressIndicator(
                    modifier = Modifier.width(64.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                )
            }
        }



    }

}







//@Preview
//@Composable
//fun TelaHomePreview() {
//    TelaHome()
//}