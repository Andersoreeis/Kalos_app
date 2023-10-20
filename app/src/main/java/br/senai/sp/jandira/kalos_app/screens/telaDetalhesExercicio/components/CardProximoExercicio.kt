package br.senai.sp.jandira.kalos_app.screens.telaDetalhesExercicio.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import br.senai.sp.jandira.kalos_app.R

@Composable
fun CardProximoExercicio(imagem: String, nome: String, onCLick: () -> Unit) {
    Surface(
        modifier = Modifier
            .height(70.dp)
            .width(360.dp),
        color = Color(255, 255, 255, 60),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 12.dp, end = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){

            Row (modifier = Modifier){
                AsyncImage(
                    model = imagem,
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.treinoerro),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .shadow(2.dp, RoundedCornerShape(5.dp))
                )

                Spacer(modifier = Modifier.width(15.dp))

                Column (
                    modifier = Modifier.height(50.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ){
                    Text(
                        text = "Próximo",
                        color = Color.White,
                        fontSize = 11.sp
                    )
                    Text(
                        text = nome,
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }


            Spacer(modifier = Modifier.width(50.dp))

            Icon(
                painter = painterResource(id = R.drawable.baseline_skip_next_24),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clickable { onCLick() },
                tint = Color.White
            )
        }
    }
}

@Preview()
@Composable
fun CardProximoExercicioPreview() {
    CardProximoExercicio(
        "https://img.freepik.com/fotos-gratis/halteres-no-chao-de-uma-academia-ai-generative_123827-23743.jpg?w=2000&t=st=1697050142~exp=1697050742~hmac=e9061cb6138441930546f5971bf27a77deb352dddb2a45b493370a62232a421b",
                "Aquecimento de músculos"
        ){}
}