package br.senai.sp.jandira.kalos_app.screens.telaDetalhesTreino.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.app_kalos.components.createButtonWithFunction
import br.senai.sp.jandira.app_kalos.components.createButtonWithWidth2
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesTreino.components.BotaoIniciarTreino
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesTreino.components.CardCapaTreino
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesTreino.components.CardExercicio
import br.senai.sp.jandira.kalos_app.screens.telaDetalhesTreino.components.HeaderTreino

@Composable
fun DetalhesTreinoScreen(imagem: String, nome: String, nivel: String, categoria: String, descricao: String, data: String, corAcademia: String) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
        CardCapaTreino(imagem)

        Column (modifier = Modifier.padding(15.dp)){
            HeaderTreino(
                nomeTreino = nome,
                nivelTreino = nivel,
                categoriaTreino = categoria,
                descricao = descricao,
                dataTreino = data
            )

            Spacer(modifier = Modifier.height(15.dp))

            BotaoIniciarTreino(cor = corAcademia)

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Resumo",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            CardExercicio(
                numero = "1",
                imagem = "https://img.freepik.com/fotos-premium/uma-academia-com-muitas-maquinas-e-pesos-no-chao_173770-1295.jpg?w=2000",
                nome = "Aquecimento de musculos",
                series = "5",
                repeticoes = "10",
                duracao = null
            )

            CardExercicio(
                numero = "2",
                imagem = "https://img.freepik.com/fotos-gratis/mulher-loira-apta-com-um-sorriso-perfeito-em-uma-roupa-esportiva-elegante-olhando-para-a-camera-e-segurando-uma-garrafa-de-agua-sobre-a-parede-branca-demonstre-musculos_273443-4534.jpg?w=2000&t=st=1696877871~exp=1696878471~hmac=b695b98926695eee75dfdb1091f6bcfeaf6a9f88ee2a3818e0127f979239348e",
                nome = "Levantamento de peso",
                series = "5",
                repeticoes = "10",
                duracao = null
            )


            CardExercicio(
                numero = "3",
                imagem = "https://img.freepik.com/fotos-gratis/desportista-em-um-treinamento-de-sportswear-em-uma-academia_1157-30349.jpg?w=2000&t=st=1696877895~exp=1696878495~hmac=c6a07f387772ddf33f6344b3c43265a60feb38cda803a545797a00faf958f740",
                nome = "Cardio",
                series = "5",
                repeticoes = null,
                duracao = "00:15:00"
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetalhesTreinoPreview() {
    DetalhesTreinoScreen(
        imagem = "https://img.freepik.com/fotos-gratis/mulher-de-alto-angulo-hidratante-apos-treino_23-2148419818.jpg?w=2000&t=st=1696878003~exp=1696878603~hmac=d3a7b647534867fd6fa1264434c1f62b51e4bddd39461e49497234e8531771c1",
        nome = "Treino Cardiovascular",
        nivel = "Iniciante",
        categoria = "Musculação",
        descricao = "Lorem ipsum dolor sit amet consectetur. Molestie et nam auctor at dis non condimentum leo sodales. Libero quis bibendum nunc lorem lectus...",
        data = "11/04/2023",
        corAcademia = "34439E"
    )
}