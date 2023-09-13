package br.senai.sp.jandira.kalos_app.screens.criarContaComponent.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.app_kalos.components.createButtonWithWidth
import br.senai.sp.jandira.app_kalos.components.createButtonWithWidth2
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.components.ContinueCom
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.CamposCriarConta
import br.senai.sp.jandira.kalos_app.screens.telaCriarConta.components.HeaderCriarConta
import br.senai.sp.jandira.kalos_app.service.AlunoService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

@Composable
fun CriarContaScreen(navController: NavController, lifecycleScope: LifecycleCoroutineScope) {

    lateinit var alunoService:AlunoService
    alunoService = RetrofitHelper.getInstance().create(AlunoService::class.java)

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

    fun auntenticarAluno(email: String, senha: String) {
        lifecycleScope.launch {
            val body = JsonObject().apply{
                addProperty("email", email)
                addProperty("senha", senha)
            }

            Log.e("teste", body.toString())
            val result = alunoService.autenticarAluno(body)

            if(result.isSuccessful){
                Log.e("CREAT-DATA", "${result.body()}")
            }else{
                Log.e("CREAT-DATA", "${result.message()}")
            }
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        HeaderCriarConta(navController)

        Spacer(modifier = Modifier.height(30.dp))
        CamposCriarConta()
        Spacer(modifier = Modifier.height(40.dp))
//        createButtonWithWidth2(
//            textButton = stringResource(R.string.continuar) ,
//            naveController = navController ,
//            aoMudar = {
//                getUserByID()
//                auntenticarAluno()
//                      },
//            corBotao = GreenKalos,
//            width = 350.dp
//        )
        createButtonWithWidth(
            textButton = stringResource(R.string.continuar) ,
            naveController = navController ,
            navName = "telaInformacoesDoCliente",
            corBotao = GreenKalos,
            width = 350.dp
        )

        Column (
            modifier = Modifier.padding(30.dp)
        ){
            ContinueCom()
        }

        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = stringResource(R.string.ja_usuario),
                color = Color.White,
                fontSize = 12.sp
            )


            Text(
                text = stringResource(R.string.faca_login),
                fontSize = 12.sp,
                color = GreenKalos,
                modifier = Modifier.clickable { navController.navigate("fazerLogin") }
            )
        }
    }
    }

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun CriarContaScreenPreview() {
//    CriarContaScreen()
//}