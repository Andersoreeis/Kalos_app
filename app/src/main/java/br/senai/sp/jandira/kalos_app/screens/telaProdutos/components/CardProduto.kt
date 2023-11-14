package br.senai.sp.jandira.kalos_app.screens.telaProdutos.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalosEscuro
import coil.compose.AsyncImage

@Composable
fun CardProduto(
    corPrimariaAcademia: String, nome: String,
    preco: String,
    onClick: () -> Unit) {
    val corPrimaria = Color(android.graphics.Color.parseColor(corPrimariaAcademia ?: "#353535"))
    Surface(
        modifier = Modifier
//            .height(260.dp)
            .width(180.dp),
        color = GrayKalosEscuro,
        shape = RoundedCornerShape(20.dp),

        ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(6.dp))
            Surface(
                modifier = Modifier.size(170.dp),
                shape = RoundedCornerShape(15.dp)
            ) {
                AsyncImage(
                    model = "",
                    contentDescription = stringResource(R.string.foto_do_produto),
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    error = painterResource(id = R.drawable.produto)
                )
            }
            Text(
                text = "R$ ${preco}",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 10.dp)
            )

            Text(
                text = nome,
                color = Color.White,
                fontSize = 13.sp,

                )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { onClick() },
                modifier = Modifier
                    .height(35.dp)
                    .width(150.dp),
                colors = ButtonDefaults.buttonColors(corPrimaria)
            ) {
                Text(
                    text = stringResource(R.string.ver_detalhes),
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

        }

    }
}

//@Preview
//@Composable
//fun CardPreview() {
//    CardProduto()
//}