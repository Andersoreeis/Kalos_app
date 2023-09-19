import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import java.util.Calendar
import java.util.Date
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calendario(context: Context) {
    val year: Int
    val month: Int
    val day: Int

    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val selectedDate = remember { mutableStateOf("") }
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            selectedDate.value = "$dayOfMonth/$month/$year"
        }, year, month, day
    )

    val dateParts = selectedDate.value.split("/")
    val dayText = dateParts.getOrNull(0) ?: ""
    val monthText = dateParts.getOrNull(1) ?: ""
    val yearText = dateParts.getOrNull(2) ?: ""

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = dayText,
            onValueChange = { /* Handle day input */ },
        )
        Spacer(modifier = Modifier.size(16.dp))
        OutlinedTextField(
            value = monthText,
            onValueChange = { /* Handle month input */ },
            label = { Text(text = "Mês") }
        )
        Spacer(modifier = Modifier.size(16.dp))
        OutlinedTextField(
            value = yearText,
            onValueChange = { /* Handle year input */ },
            label = { Text(text = "Ano") }
        )

        Spacer(modifier = Modifier.size(16.dp))
        Button(onClick = {
            datePickerDialog.show()
        }) {
            Text(text = "Abrir Seletor de Data")
        }
    }
}
