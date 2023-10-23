package br.senai.sp.jandira.kalos_app

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.kalos_app.screens.InformacoesCliente.screen.TelasInformacoesdoCliente
import br.senai.sp.jandira.kalos_app.screens.criarContaComponent.screen.CriarContaScreen
import br.senai.sp.jandira.kalos_app.screens.telaAlterarSenha.screen.TelaAlterarSenha
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.screen.TelaDetalhesExercicio
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.screen.TelaTreinoConcluido
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesTreino.screen.DetalhesTreinoScreen
import br.senai.sp.jandira.kalos_app.screens.telaEditarPerfil.screen.TelaEditarPerfil
import br.senai.sp.jandira.kalos_app.screens.telaEsqueciSenha.screen.TelaEsqueciSenhaCodigo
import br.senai.sp.jandira.kalos_app.screens.telaEsqueciSenha.screen.TelaEsqueciSenhaEmail
import br.senai.sp.jandira.kalos_app.screens.telaEsqueciSenha.screen.TelaEsqueciSenhaNovaSenha
import br.senai.sp.jandira.kalos_app.screens.telaEsqueciSenha.screen.TelaSenhaRedefinida
import br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.LoginScreeViewModel

import br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.screen.LoginScreen
import br.senai.sp.jandira.kalos_app.screens.telaHome.screen.TelaHome
import br.senai.sp.jandira.kalos_app.screens.telaHomeAcademia.screen.TelaHomeAcademia
import br.senai.sp.jandira.kalos_app.screens.telaInicial.screen.TelaInicial
import br.senai.sp.jandira.kalos_app.screens.telaObjetivo.screen.TelaObjetivo
import br.senai.sp.jandira.kalos_app.screens.telaSaudeLimitacoes.screen.TelaSaudeLimitacoes
import br.senai.sp.jandira.kalos_app.telaP.telaPerfilAcademia.screen.TelaPerfilAcademia
import br.senai.sp.jandira.kalos_app.ui.theme.Kalos_appTheme
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        setContent {

            Kalos_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val localStorage: Storage = Storage()
                    val navController = rememberNavController()
                    NavHost(

                
                        navController = navController,
                        startDestination = "telaInicial"
                    ) {
                        composable(route = "telaInicial") {

                            TelaInicial(navController, lifecycleScope, localStorage)
                        }
                        composable(route = "fazerLogin") {
                            LoginScreen(navController, lifecycleScope, viewModel = LoginScreeViewModel(), localStorage)
                        }
                        composable(route = "criarConta") {

                            CriarContaScreen(navController, lifecycleScope, localStorage, viewModel =  LoginScreeViewModel())
                        }
                        composable(route = "telaInformacoesDoCliente") {
                            TelasInformacoesdoCliente(navController, localStorage, lifecycleScope)
                        }

                        composable(route = "home") {
                            TelaHome(navController, lifecycleScope ,localStorage)
                        }
                        composable(route = "editarPerfil"){
                            TelaEditarPerfil(navController,lifecycleScope ,localStorage)
                        }
                        composable(route = "alterarSenha"){
                            TelaAlterarSenha(navController = navController, lifecycleCoroutineScope = lifecycleScope, localStorage)
                        }
                        composable(route = "perfilAcademia"){
                            TelaPerfilAcademia(navController = navController,  localStorage)
                        }
                        composable(route = "homeAcademia"){
                            TelaHomeAcademia(navController, lifecycleScope, localStorage)
                        }

                        composable(route = "detalhesTreino"){
                            DetalhesTreinoScreen(navController, lifecycleScope, localStorage)
                        }
                        composable(route = "esqueciSenhaEmail"){
                            TelaEsqueciSenhaEmail(navController, lifecycleScope,localStorage)
                        }
                        composable(route = "esqueciSenhaCodigo"){
                            TelaEsqueciSenhaCodigo(navController, lifecycleScope,localStorage)
                        }
                        composable(route = "esqueciSenhaNovaSenha"){
                            TelaEsqueciSenhaNovaSenha(navController, lifecycleScope,localStorage)
                        }
                        composable(route = "senhaRedefinida"){
                            TelaSenhaRedefinida(navController)
                        }

                        composable(route = "detalhesExercicio"){
                            TelaDetalhesExercicio(LocalLifecycleOwner.current, localStorage, navController, lifecycleScope)
                        }

                        composable(route = "treinoConcluido"){
                            TelaTreinoConcluido(navController)
                        }



                    }


                }

            }
        }


    }
}




