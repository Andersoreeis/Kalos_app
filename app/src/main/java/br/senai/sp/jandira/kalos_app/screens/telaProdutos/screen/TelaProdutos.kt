package br.senai.sp.jandira.kalos_app.screens.telaProdutos.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import br.senai.sp.jandira.kalos_app.screens.telaBuscarAcademias.components.CampoPesquisa
import br.senai.sp.jandira.kalos_app.screens.telaProdutos.components.BotaoReservas
import br.senai.sp.jandira.kalos_app.screens.telaProdutos.components.CardProduto

@Composable
fun TelaProdutos(lifecycleCoroutineScope: LifecycleCoroutineScope, corPrimaria: String) {
    val list = listOf<Color>(
        Color.White,
        Color.Red,
        Color.Green,
        Color.Yellow, Color.White,
        Color.Red,
        Color.Green,
        Color.Yellow
    )
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
            BotaoReservas(corPrimariaAcademia = corPrimaria)
        }
        Spacer(modifier = Modifier.height(10.dp))


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            state = rememberLazyGridState(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(6) {

                CardProduto()


            }
        }
    }
}