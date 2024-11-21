package com.example.eisenhowermatrix.presentation.screen

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eisenhowermatrix.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun NoteCreat(mainViewModel: MainViewModel){
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
            mDate.value = "$mDayOfMonth.${mMonth+1}.$mYear"
        }, mYear, mMonth, mDay
    )
    val (isChecked, setIsChecked) = remember { mutableStateOf(false) }
    var text by remember { mutableStateOf(false) }
    var text1 by remember { mutableStateOf(false) }
    val checkedState = remember { mutableStateOf(false) }
    Column(modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.Overlay))
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Close,
                    contentDescription = "Закрыть", modifier = Modifier.size(30.dp),
                    tint = Color.Black)
            }
            TextButton (onClick = { mainViewModel.postCreatPosts()}, modifier = Modifier.align(Alignment.TopEnd),
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color(0xFF007AFF))
            ) {
                Text(text = "Сохранить", fontSize = 20.sp)
            }
        }
        Column(modifier = Modifier.background(colorResource(R.color.white))){
            val message = remember{ mutableStateOf("Введите текст") }
            OutlinedTextField(
                message.value,
                {message.value = it},
                textStyle = TextStyle(fontSize =  20.sp, color = Color(0xFF26000000)),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(200.dp)
                    .fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor= Color(0xFF34C759),
                    unfocusedBorderColor = Color(0xFF26000000)))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            Text(text = "Важность",
                fontSize = 20.sp)
            TextButton (
                onClick = { text = true },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color(0xFF0F000000))
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
                Text("!! Высокий", fontSize = 18.sp, modifier = Modifier.padding(10.dp), color = Color(0xFFFF3B30))
            }
        }
        Text(text = "_______________________________________",
            fontSize = 20.sp, color = Color(0xFF0F000000))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "Сделать до ",
                    fontSize = 20.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "${mDate.value}",
                    fontSize = 20.sp,
                    color = Color(0xFF007AFF))
            }
            fun onSwitchToggle(checked: Boolean) {
                setIsChecked(checked)
                if (checked) {
                    text1 = true
                    mDatePickerDialog.show()
                }else{
                    text1 = false
                    mDate.value = " "
                }
            }
            Column {
                Switch(checked = isChecked,
                    onCheckedChange = {
                        onSwitchToggle(it)
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color(0xFF0F000000),
                        uncheckedThumbColor = Color(0xFFFFFFFF),
                        checkedTrackColor = Color(0xFF0F000000),
                        uncheckedTrackColor = Color(0xFF0F000000)))
            }
        }
        Text(text = "_______________________________________",
            fontSize = 20.sp, color = Color(0xFF0F000000)
        )
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            fun onButtonClick(){
                mainViewModel.deletePosts()
                text1 = !text1
            }
            IconToggleButton(checked = text1,
                onCheckedChange = { onButtonClick() }) {
                Icon(Icons.Filled.Delete,
                    contentDescription = "Удаление", modifier = Modifier.size(30.dp),
                    tint = if (text1) Color(0xFFEC407A) else Color(0xFFB0BEC5))
            }
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = "Удалить",
                    fontSize = 20.sp,
                    color = if (text1) Color(0xFFEC407A) else Color(0xFFB0BEC5))
            }
        }
    }
    fun getCurrentDate(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return sdf.format(Date())
    }
}

