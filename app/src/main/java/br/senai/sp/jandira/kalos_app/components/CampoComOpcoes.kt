package br.senai.sp.jandira.kalos_app.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import br.senai.sp.jandira.kalos_app.Storage
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun CampoGenero(localStorage: Storage, isError: Boolean, categoria: MutableState<String>) {
    val context = LocalContext.current
    val categories = listOf(
        "Masculino",
        "Feminino",
        "Outros",
    )

    var category by remember {
        mutableStateOf(categoria)
    }

    var textFieldSize by remember {
        mutableStateOf(Size.Zero)
    }

    var expanded by remember {
        mutableStateOf(false)
    }
    val interactionSource = remember {
        MutableInteractionSource()
    }

    // Category Field
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    expanded = !expanded // Toggle the dropdown
                }
            )
    ) {


        Column(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = categoria.value,
                onValueChange = {
                    categoria.value = it
                    expanded = true

                },
                isError = isError,
                textStyle = TextStyle(fontSize = 16.sp),

                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .onGloballyPositioned { coordinates ->
                        textFieldSize = coordinates.size.toSize()
                    },
                placeholder = {
                    Text(text = "Genero", color = Color(0xFF606060))
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
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = Icons.Rounded.KeyboardArrowDown,
                            contentDescription = "arrow",
                            tint = GreenKalos
                        )
                    }
                }

            )

            AnimatedVisibility(visible = expanded) {
                Card(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .width(textFieldSize.width.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    LazyColumn(
                        modifier = Modifier.heightIn(max = 150.dp)
                    ) {
                        items(
                            categories.filter {
                                it.lowercase().contains(categoria.value.lowercase()) || it.lowercase()
                                    .contains("others")
                            }
                                .sorted()
                        ) { title ->
                            CategoryItem(title = title) {
                                categoria.value = title
                                localStorage.salvarValor(context, categoria.value, "genero")
                                expanded = false
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun CampoGenero2(isError: Boolean, categoria: String) {
    val context = LocalContext.current
    val categories = listOf(
        "Masculino",
        "Feminino",
        "Outros",
    )

    var category by remember {
        mutableStateOf(categoria)
    }

    var textFieldSize by remember {
        mutableStateOf(Size.Zero)
    }

    var expanded by remember {
        mutableStateOf(false)
    }
    val interactionSource = remember {
        MutableInteractionSource()
    }

    // Category Field
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    expanded = !expanded // Toggle the dropdown
                }
            )
    ) {


        Column(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = category,
                onValueChange = {
                    category= it
                    expanded = true

                },
                isError = isError,
                textStyle = TextStyle(fontSize = 16.sp),

                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .onGloballyPositioned { coordinates ->
                        textFieldSize = coordinates.size.toSize()
                    },
                placeholder = {
                    Text(text = "Genero", color = Color(0xFF606060))
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
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = Icons.Rounded.KeyboardArrowDown,
                            contentDescription = "arrow",
                            tint = GreenKalos
                        )
                    }
                }

            )

            AnimatedVisibility(visible = expanded) {
                Card(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .width(textFieldSize.width.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    LazyColumn(
                        modifier = Modifier.heightIn(max = 150.dp)
                    ) {
                        items(
                            categories.filter {
                                it.lowercase().contains(category.lowercase()) || it.lowercase()
                                    .contains("others")
                            }
                                .sorted()
                        ) { title ->
                            CategoryItem(title = title) {
                                category = title
                                expanded = false
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryItem(
    title: String,
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
        Text(text = title, fontSize = 16.sp)
    }
}
