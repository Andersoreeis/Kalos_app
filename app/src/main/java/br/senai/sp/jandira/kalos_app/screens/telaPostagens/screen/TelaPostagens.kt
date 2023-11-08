package br.senai.sp.jandira.kalos_app.screens.telaPostagens.screen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.model.PostagensResponse
import br.senai.sp.jandira.kalos_app.screens.telaPostagens.components.CardPostagem
import br.senai.sp.jandira.kalos_app.service.AlunoService
import br.senai.sp.jandira.kalos_app.service.PostagemService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TelaPostagens(lifecycleCoroutineScope: LifecycleCoroutineScope, localStorage: Storage) {

    lateinit var postagemService: PostagemService
    postagemService = RetrofitHelper.getInstance().create(PostagemService::class.java)

    var listaPostagens by remember {
        mutableStateOf(listOf<PostagensResponse>())
    }

//    val items = listOf<PostagensResponse>(
//        PostagensResponse(
//            id = 1,
//            anexo = "aaaaa.png",
//            titulo = "Aviso",
//            corpo = "asbfhbdjghsbdlkfhsalbefljkhksgjbgjbxglhjbzkjebflkjsengkjxzbkjh" +
//                    " gjh  sdj gjs jg sjhf sdbfsbdfjhbsjhfbjshbfs",
//            data = "2023-10-18T00:00:00.000Z",
//            hora = "2023-10-18T00:00:00.000Z"
//        ),
//        PostagensResponse(
//            id = 1,
//            anexo = "aaaaa.png",
//            titulo = "Aviso",
//            corpo = "asbfhbdjghsbdlkfhsalbefljkhksgjbgjbxglhjbzkjebflkjsengkjxzbkjh" +
//                    " gjh  sdj gjs jg sjhf sdbfsbdfjhbsjhfbjshbfs",
//            data = "2023-10-18T00:00:00.000Z",
//            hora = "2023-10-18T00:00:00.000Z"
//        ),
//        PostagensResponse(
//            id = 1,
//            anexo = "aaaaa.png",
//            titulo = "Aviso",
//            corpo = "asbfhbdjghsbdlkfhsalbefljkhksgjbgjbxglhjbzkjebflkjsengkjxzbkjh" +
//                    " gjh  sdj gjs jg sjhf sdbfsbdfjhbsjhfbjshbfs",
//            data = "2023-10-18T00:00:00.000Z",
//            hora = "2023-10-18T00:00:00.000Z"
//        )
//    )
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
                .height(700.dp)
                .padding(horizontal = 10.dp)

        ) {

            LazyColumn() {
                items(listaPostagens) {
                    it.anexo?.let { it1 ->
                        CardPostagem(
                            titulo = it.titulo!!,
                            foto = it1,
                            descricao = it.corpo!!,
                            data = it.data!!,
                            hora = it.hora!!
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }


        }
    }else {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 10.dp)
        ) {
            Text(text = "Essa academia não possui postagens", color = Color.White, fontSize = 25.sp)
        }
    }
}