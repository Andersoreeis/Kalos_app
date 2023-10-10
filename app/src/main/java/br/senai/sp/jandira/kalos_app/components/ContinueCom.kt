package br.senai.sp.jandira.kalos_app.components

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.LocalStorage
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.screens.telaFazerLogin.LoginScreeViewModel
import br.senai.sp.jandira.kalos_app.service.AlunoService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch


private val auth: FirebaseAuth = Firebase.auth
private val loading = MutableLiveData(false)

@Composable
fun ContinueCom(
    navController: NavController,
    viewModel: LoginScreeViewModel,
    localstorage: Storage,
    lifecycleCoroutineScope: LifecycleCoroutineScope
) {
    val degradeLeft = Brush.horizontalGradient(
        colors = listOf(Color(0xFF000000), Color(0xFF00FE90))
    )

    val degradeRight = Brush.horizontalGradient(
        colors = listOf(Color(0xFF00FE90), Color(0xFF000000))
    )
    val auth = FirebaseAuth.getInstance()
    val currentUser = auth.currentUser
    val providerId = currentUser!!.providerData[0].providerId

    var statusFirebase = remember { mutableStateOf(false) }
    val token = "470985893904-bh5urla6jiaglnbs4p38j5p7k8ehsi6k.apps.googleusercontent.com"
    val context = LocalContext.current
    val user = Firebase.auth.currentUser
    val userEmail = user?.email
    //Login Via Google
    val emailUserFirebase = localstorage.lerValor(context, "email")
    val alunoService: AlunoService = RetrofitHelper.getInstance().create(AlunoService::class.java)

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try {
                val account = task.getResult(ApiException::class.java)
                val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                viewModel.signInWithGoogleCredential(credential) {

                    lifecycleCoroutineScope.launch {
                        val result = alunoService.getAlunoByEmail(userEmail.toString())
                       var idALuno = result.body()?.data?.id

                        if (result.isSuccessful) {
                            localstorage.salvarValor(context, "${userEmail}", "email")
                            localstorage.salvarValor(context, "${idALuno}", "idAluno")

                            navController.navigate("home")

                        }
                        else {
                            navController.navigate("telaInformacoesDoCliente")

                        }
                    }

                }

            } catch (ex: Exception) {
                Log.d("Falhado Login", "Login Falhou")
            }
        }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(brush = degradeLeft)
            )

            Text(
                text = stringResource(R.string.ou_continue_com),
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier.padding(10.dp)
            )

            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(brush = degradeRight)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(
                onClick = {
                    statusFirebase.value = true

                    val opcoes = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(token).requestEmail().build()

                    localstorage.salvarValor(context, user.toString(), "userFirebase")
                    localstorage.salvarValor(context, userEmail.toString(), "userEmailFirebase")
                    localstorage.salvarValor(context, statusFirebase.toString(), "statusFirebase")

                    val googleSingInCliente = GoogleSignIn.getClient(context, opcoes)
                    launcher.launch(googleSingInCliente.signInIntent)
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Imagem do Google",
                    modifier = Modifier.size(30.dp)
                )
            }


        }
    }
}


