package br.senai.sp.jandira.kalos_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.kalos_app.screens.criarContaComponent.screen.CriarContaScreen
import br.senai.sp.jandira.kalos_app.screens.criarContaComponent.screen.LoginScreen
import br.senai.sp.jandira.kalos_app.screens.telaInicialComponent.screen.TelaInicial
import br.senai.sp.jandira.kalos_app.ui.theme.Kalos_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                        startDestination = "criarConta" ){
                        composable(route = "telaInicial"){
                            TelaInicial(navController)
                        }
                        composable(route = "fazerLogin"){
                        LoginScreen(navController)
                        }
                        composable(route = "criarConta"){
                            CriarContaScreen(navController)
                        }

                    }
                }
            }
        }
    }
}

