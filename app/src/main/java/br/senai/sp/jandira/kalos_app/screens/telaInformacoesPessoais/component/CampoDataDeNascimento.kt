package br.senai.sp.jandira.kalos_app.screens.telaInformacoesPessoais.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoDataNascimento(
    dia: String,
    mes: String,
    ano: String,
    aoMudarDia: (String) -> Unit,
    aoMudarMes: (String) -> Unit,
    aoMudarAno: (String) -> Unit,
    isErrorDia: Boolean,
    isErrorMes: Boolean,
    isErrorAno: Boolean
) {
    val context = LocalContext.current
    val dias = List(31) { (it + 1).toString().padStart(2, '0') }
    val meses = List(12) { (it + 1).toString().padStart(2, '0') }
    val anos = List(100) { (2023 - it).toString() }

    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    var expandedDia by remember { mutableStateOf(false) }
    var expandedMes by remember { mutableStateOf(false) }
    var expandedAno by remember { mutableStateOf(false) }

    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Campo de Dia
        Column(
            modifier = Modifier
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = {
                        expandedDia = !expandedDia
                        if (expandedDia) {
                            expandedMes = false
                            expandedAno = false
                        }
                    }
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = dia,
                onValueChange = { newText ->
                    if (newText.length <= 2) {
                        aoMudarDia(newText)
                    }
                },
                isError = isErrorDia,
                textStyle = TextStyle(fontSize = 16.sp),
                modifier = Modifier
                    .width(110.dp)
                    .height(55.dp)
                    .onGloballyPositioned { coordinates ->
                        textFieldSize = coordinates.size.toSize()
                    },
                placeholder = {
                    Text(text = "Dia", color = Color(0xFF606060))
                },
                shape = RoundedCornerShape(25.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = GreenKalos,
                    containerColor = Color(0xFF393939),
                    unfocusedBorderColor = Color(0xFF393939),
                    focusedBorderColor = GreenKalos,
                    cursorColor = GreenKalos
                ),
                singleLine = true,
                trailingIcon = {
                    IconButton(
                        onClick = {
                            expandedDia = !expandedDia
                            if (expandedDia) {
                                expandedMes = false
                                expandedAno = false
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.KeyboardArrowDown,
                            contentDescription = "Seta para baixo",
                            tint = GreenKalos
                        )
                    }
                }
            )

            AnimatedVisibility(visible = expandedDia) {
                Card(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .width(100.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    LazyColumn(
                        modifier = Modifier.heightIn(max = 140.dp)
                    ) {
                        items(dias) { day ->
                            OptionItem(
                                text = day,
                                onSelect = {
                                    aoMudarDia(day)
                                    expandedDia = false
                                }
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.width(10.dp))

        // Campo de Mês
        Column(
            modifier = Modifier
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = {
                        expandedMes = !expandedMes
                        if (expandedMes) {
                            expandedDia = false
                            expandedAno = false
                        }
                    }
                ),
                    horizontalAlignment = Alignment.CenterHorizontally

        ) {
            OutlinedTextField(
                value = mes,
                onValueChange = { newText ->
                    if (newText.length <= 2) {
                        aoMudarMes(newText)
                    }
                },
                isError = isErrorMes,
                textStyle = TextStyle(fontSize = 16.sp),
                modifier = Modifier
                    .width(110.dp)
                    .height(55.dp)
                    .onGloballyPositioned { coordinates ->
                        textFieldSize = coordinates.size.toSize()
                    },
                placeholder = {
                    Text(text = "Mês", color = Color(0xFF606060))
                },
                shape = RoundedCornerShape(25.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = GreenKalos,
                    containerColor = Color(0xFF393939),
                    unfocusedBorderColor = Color(0xFF393939),
                    focusedBorderColor = GreenKalos,
                    cursorColor = GreenKalos
                ),
                singleLine = true,
                trailingIcon = {
                    IconButton(
                        onClick = {
                            expandedMes = !expandedMes
                            if (expandedMes) {
                                expandedDia = false
                                expandedAno = false
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.KeyboardArrowDown,
                            contentDescription = "Seta para baixo",
                            tint = GreenKalos
                        )
                    }
                }
            )

            AnimatedVisibility(visible = expandedMes) {
                Card(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .width(100.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    LazyColumn(
                        modifier = Modifier.heightIn(max = 140.dp)
                    ) {
                        items(meses) { month ->
                            OptionItem(
                                text = month,
                                onSelect = {
                                    aoMudarMes(month)
                                    expandedMes = false
                                }
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.width(10.dp))

        // Campo de Ano
        Column(
            modifier = Modifier
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = {
                        expandedAno = !expandedAno
                        if (expandedAno) {
                            expandedDia = false
                            expandedMes = false
                        }
                    }


                ),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            OutlinedTextField(
                value = ano,
                onValueChange = { newText ->
                    if (newText.length <= 4) {
                        aoMudarAno(newText)
                    }
                },
                isError = isErrorAno,
                textStyle = TextStyle(fontSize = 16.sp),
                modifier = Modifier
                    .width(110.dp)
                    .height(55.dp)
                    .onGloballyPositioned { coordinates ->
                        textFieldSize = coordinates.size.toSize()
                    },
                placeholder = {
                    Text(text = "Ano", color = Color(0xFF606060))
                },
                shape = RoundedCornerShape(25.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = GreenKalos,
                    containerColor = Color(0xFF393939),
                    unfocusedBorderColor = Color(0xFF393939),
                    focusedBorderColor = GreenKalos,
                    cursorColor = GreenKalos
                ),
                singleLine = true,
                trailingIcon = {
                    IconButton(
                        onClick = {
                            expandedAno = !expandedAno
                            if (expandedAno) {
                                expandedDia = false
                                expandedMes = false
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.KeyboardArrowDown,
                            contentDescription = "Seta para baixo",
                            tint = GreenKalos
                        )
                    }
                }
            )

            AnimatedVisibility(visible = expandedAno) {
                Card(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .width(100.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    LazyColumn(
                        modifier = Modifier.heightIn(max = 140.dp)
                    ) {
                        items(anos) { year ->
                            OptionItem(
                                text = year,
                                onSelect = {
                                    aoMudarAno(year)
                                    expandedAno = false
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun OptionItem(
    text: String,
    onSelect: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onSelect()
            }
            .padding(10.dp)
    ) {
        Text(text = text, fontSize = 16.sp)
    }
}