package br.senai.sp.jandira.kalos_app.screens.telaDetalhesProduto.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderProduto(
    titulo: String,
    codigo: String,
    categoria: String,
    corAcademia: String,
    descricao: String
) {
    val color = android.graphics.Color.parseColor(corAcademia)
    Column {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(
                    text = titulo,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 24.sp
                )

                Spacer(modifier = Modifier.height(5.dp))

                Surface(
                    color = Color(color),
                    modifier = Modifier
                        .height(17.dp),
                    shape = RoundedCornerShape(5.dp)

                ) {
                    Text(
                        modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                        text = categoria,
                        fontSize = 11.sp,
                        color = if (corAcademia.uppercase() == "#FFFFFF") Color.Black else Color.White
                    )
                }
            }

            Text(
                text = codigo,
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontSize = 14.sp
            )


        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = descricao,
            color = Color.White,
            fontWeight = FontWeight.Light,
            fontSize = 14.sp
        )
    }


}

@Preview
@Composable
fun HeaderProdutoPreview() {
    HeaderProduto(
        "Garrafinha 800ml",
        "#1141",
        "Acessórios",
        "#34439E",
        "A parceira perfeita para se manter hidratado durante seus treinos! Com um design elegante e capacidade generosa, você terá água fresca sempre à mão. Perfeita para te acompanhar onde quer que você vá."
    )
}