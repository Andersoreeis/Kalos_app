package br.senai.sp.jandira.kalos_app.screens.telaBuscarAcademias.components

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import br.senai.sp.jandira.kalos_app.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun CampoPesquisa(
    estadoValue: String,
    aoMudar: (String) -> Unit,
    funcao: () -> Unit,
    lifecycleScope: LifecycleCoroutineScope
) {

    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val view = LocalView.current


    OutlinedTextField(
        value = estadoValue,
        onValueChange = { novoValor ->
            aoMudar(novoValor)
        },
        trailingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.baseline_search_24),
                contentDescription = "Icon de Phone",
                tint = Color.White,
                modifier = Modifier.clickable {

                    funcao()
                    hideKeyboard(context, view)


                }
            )
        },
        keyboardActions = KeyboardActions(
            onDone = {

                funcao()
                hideKeyboard(context, view)


            }
        ),
        placeholder = {
            Text(text = "Buscar Academias", color = Color(0xFF606060))
        },
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth(),
        shape = RoundedCornerShape(25.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.White,
            containerColor = Color(0xFF393939),
            cursorColor = Color.White,
            focusedBorderColor = Color.Transparent
        ),
        singleLine = true
    )

}


private fun hideKeyboard(context: Context, view: View) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.hideSoftInputFromWindow(view.windowToken, 0)
}