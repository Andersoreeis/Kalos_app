package br.senai.sp.jandira.kalos_app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.kalos_app.screens.InformacoesCliente.screen.TelasInformacoesdoCliente
import br.senai.sp.jandira.kalos_app.screens.criarContaComponent.screen.CriarContaScreen

import br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.screen.LoginScreen
import br.senai.sp.jandira.kalos_app.screens.telaInicial.screen.TelaInicial
import br.senai.sp.jandira.kalos_app.screens.telaObjetivo.screen.TelaObjetivo
import br.senai.sp.jandira.kalos_app.screens.telaSaudeLimitacoes.screen.TelaSaudeLimitacoes
import br.senai.sp.jandira.kalos_app.service.AlunoService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.ui.theme.Kalos_appTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var alunoService:AlunoService
        alunoService = RetrofitHelper.getInstance().create(AlunoService::class.java)
        setContent {

            Kalos_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavHost(
                        navController =  navController,
                        startDestination = "telaInicial" ){
                        composable(route = "telaInicial"){
                            TelaInicial(navController)
                        }
                        composable(route = "fazerLogin"){
                            LoginScreen(navController)
                        }
                        composable(route = "criarConta"){
                            CriarContaScreen(navController)
                        }
                        composable(route = "telaInformacoesDoCliente"){
                            TelasInformacoesdoCliente(navController)
                        }
                        composable(route = "saudeLimitacoes"){
                            TelaSaudeLimitacoes(navController = navController)
                        }
                        composable(route = "objetivo"){
                            TelaObjetivo(navController = navController)
                        }
                    }
                }

            }
        }

        fun getUserByID() {
            lifecycleScope.launch {
                val result = alunoService.getAlunoByID("1")

                if(result.isSuccessful){
                    Log.e("GETTING-DATA", "${result.body()?.data}")
                }else{
                    Log.e("GETTING-DATA", "${result.message()}")
                }
            }
        }
        getUserByID()
    }
}


