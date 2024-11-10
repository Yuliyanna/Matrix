package com.example.eisenhowermatrix

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.annotation.RequiresApi
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun MainScreen2() {
    val mContext = LocalContext.current
    val mYear: Int
    val mMonth: Int
    val mDay: Int
    val mCalendar = Calendar.getInstance()
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()

    val mDate = remember { mutableStateOf("") }

    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth.${mMonth + 1}.$mYear"
        }, mYear, mMonth, mDay
    )

    val (isChecked, setIsChecked) = remember { mutableStateOf(false) }
    // val (date, setDate) = remember { mutableStateOf(getCurrentDate()) }


    var text by remember { mutableStateOf(false) }
    var text1 by remember { mutableStateOf(false) }
    val checkedState = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.Overlay))
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        //  horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { }) {
                Icon(
                    Icons.Filled.Close,
                    contentDescription = "Закрыть", modifier = Modifier.size(30.dp),
                    tint = Color.Black
                )
            }

            TextButton(
                onClick = { }, modifier = Modifier.align(Alignment.TopEnd),
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color(0xFF007AFF)
                )
            ) {
                Text(text = "Сохранить", fontSize = 20.sp)
            }
        }

        Column(modifier = Modifier.background(colorResource(R.color.white))) {
            val message = remember { mutableStateOf("Введите текст") }
            OutlinedTextField(
                message.value,
                { message.value = it },
                textStyle = TextStyle(fontSize = 20.sp, color = Color(0xFF26000000)),

                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(200.dp)
                    .fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF34C759),
                    unfocusedBorderColor = Color(0xFF26000000)
                )
            )
        }
        Spacer(modifier = Modifier.height(16.dp))


        Column {
            Text(
                text = "Важность",
                fontSize = 20.sp
            )
            TextButton(
                onClick = { text = true },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color(0xFF0F000000)
                )
            ) {
                Text(text = "Нет", fontSize = 20.sp)
            }

            DropdownMenu(
                expanded = text,
                onDismissRequest = { text = false }
            ) {
                Text("Нет", fontSize = 18.sp, modifier = Modifier.padding(10.dp))
                Divider()
                Text("Низкий", fontSize = 18.sp, modifier = Modifier.padding(10.dp))
                Divider()
                Text(
                    "!! Высокий",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp),
                    color = Color(0xFFFF3B30)
                )
            }
        }
        Text(
            text = "_______________________________________",
            fontSize = 20.sp, color = Color(0xFF0F000000)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val checkedState = remember { mutableStateOf(false) }
            val textColor = remember { mutableStateOf(Color(0xFF007AFF)) }
            //var text1 by remember { mutableStateOf(false) }

            Column {
                Text(
                    text = "Сделать до ",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "${mDate.value}",
                    fontSize = 20.sp,
                    color = Color(0xFF007AFF)
                )

            }
            fun onSwitchToggle(checked: Boolean) {
                setIsChecked(checked)
                if (checked) {
                    text1 = true

                    mDatePickerDialog.show()
                } else {
                    text1 = false
                    mDate.value = " "

                }
            }


            Column {
                Switch(
                    checked = isChecked,
                    onCheckedChange = {
                        // mDatePickerDialog.show()
                        onSwitchToggle(it)
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color(0xFF0F000000),
                        uncheckedThumbColor = Color(0xFFFFFFFF),
                        checkedTrackColor = Color(0xFF0F000000),
                        uncheckedTrackColor = Color(0xFF0F000000)
                    )
                )

            }
        }
        Text(
            text = "_______________________________________",
            fontSize = 20.sp, color = Color(0xFF0F000000)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            IconToggleButton(
                checked = text1,
                onCheckedChange = { text1 = it }) {
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = "Удаление", modifier = Modifier.size(30.dp),
                    tint = if (text1) Color(0xFFEC407A) else Color(0xFFB0BEC5)
                )
            }
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = "Удалить",
                    fontSize = 20.sp,
                    color = if (text1) Color(0xFFEC407A) else Color(0xFFB0BEC5)
                )
            }
        }

    }
    fun getCurrentDate(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return sdf.format(Date())
    }
}