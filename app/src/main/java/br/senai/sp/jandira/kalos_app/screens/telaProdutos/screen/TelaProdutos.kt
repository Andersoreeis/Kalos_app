package br.senai.sp.jandira.kalos_app.screens.telaProdutos.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.kalos_app.model.ProdutosResponse
import br.senai.sp.jandira.kalos_app.screens.telaBuscarAcademias.components.CampoPesquisa
import br.senai.sp.jandira.kalos_app.screens.telaProdutos.components.BotaoReservas
import br.senai.sp.jandira.kalos_app.screens.telaProdutos.components.CardProduto
import br.senai.sp.jandira.kalos_app.service.ProdutoService
import br.senai.sp.jandira.kalos_app.service.RetrofitHelper
import kotlinx.coroutines.launch

@Composable
fun TelaProdutos(lifecycleCoroutineScope: LifecycleCoroutineScope, corPrimaria: String, navController: NavController, localStorage: br.senai.sp.jandira.kalos_app.Storage) {


    lateinit var produtoService: ProdutoService
    produtoService = RetrofitHelper.getInstance().create(ProdutoService::class.java)

    var listaProdutos by remember {
        mutableStateOf(listOf<ProdutosResponse>())
    }

    val context = LocalContext.current
    var status by remember {
        mutableStateOf(false)
    }

    lifecycleCoroutineScope.launch {
        val result = produtoService.getTodosProdutos(
            localStorage.lerValor(context, "idAcademia").toString()
        )

        if (result.isSuccessful){
            listaProdutos = result.body()!!.produto!!
            Log.e("lista", "TelaProdutos: ${listaProdutos}", )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {
        CampoPesquisa(
            estadoValue = "",
            aoMudar = { },
            funcao = { /*TODO*/ },
            placeholder = "Buscar Produtos"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            BotaoReservas(corPrimariaAcademia = corPrimaria, navController )
        }
        Spacer(modifier = Modifier.height(10.dp))


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            state = rememberLazyGridState(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(listaProdutos) {
                var foto = ""
                var listFoto = it.fotos
                if(listFoto.isEmpty() ){
                    foto = "anexo"
                }else{
                    foto = it.fotos[0].url!!
                }

                CardProduto(corPrimaria, it.nome!!, it.preco , foto ){
                    navController.navigate("detalhesProduto")
                    localStorage.salvarValor(context, it.id!!.toString(), "idProduto")



                }


            }
        }
    }
}