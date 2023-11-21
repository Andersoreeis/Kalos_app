package br.senai.sp.jandira.kalos_app.screens.telaChat.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.screens.telaChat.components.MensagemEnviada
import br.senai.sp.jandira.kalos_app.screens.telaChat.components.MensagemRecebida
import br.senai.sp.jandira.kalos_app.ui.theme.GrayKalos
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaChat() {

    var mensagemState by remember {
        mutableStateOf("")
    }

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .fillMaxSize(),
        color = Color.Black
    ){
        Column (modifier = Modifier
            .fillMaxSize()){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(GreenKalos),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painter = painterResource(id = R.drawable.baseline_chevron_left_24),
                    tint = Color.Black,
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {

                        },
                    contentDescription = null
                )

                Text(
                    text = "Vital Bot",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 20.sp
                )
            }

            LazyColumn(){
                items(1){
                    MensagemRecebida(
                        "      Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc interdum malesuada dolor eu vehicula. ",
                        "23:09"
                    )

                    MensagemEnviada(
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc interdum malesuada dolor eu vehicula. ",
                        "23:09"
                    )

                    MensagemEnviada(
                        "ahahahhaha",
                        "23:09"
                    )
                    MensagemRecebida(
                        "      Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc interdum malesuada dolor eu vehicula. ",
                        "23:09"
                    )
                    MensagemRecebida(
                        "      Lorem ipsum dolor sit",
                        "23:09"
                    )

                }
            }

            Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround){
                OutlinedTextField(
                    value = mensagemState,
                    onValueChange = {
                            mensagemState = it
                    },
                    modifier = Modifier
                        .height(51.dp)
                        .width(320.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.White,
                        containerColor = Color(0xFF393939),
                        unfocusedBorderColor = Color(0xFF393939),
                        focusedBorderColor = GreenKalos,
                        cursorColor = GreenKalos,
                        disabledTextColor = GrayKalos
                    )
                )

                Card (
                    modifier = Modifier
                        .size(45.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(containerColor = GreenKalos)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.sendicon),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun TelaChatPreview() {
    TelaChat()
}
