package com.example.eisenhowermatrix


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.Delete

@Composable
fun MainScreen1() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.Overlay))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            Text(text = "Мои планы", fontSize = 28.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = "Выполнено", fontSize = 20.sp, color = colorResource(R.color.Tertiary))
                /* Spacer(modifier = Modifier.height(50.dp))
                Image(
                    painter = painterResource(id = R.drawable.icon),
                    contentDescription = "Переход на другую тему",
                    modifier = Modifier.size(30.dp),
                )*/
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .background(colorResource(R.color.white))
                .padding(3.dp)
        ) {
            Row{
                var checked: Boolean by
                remember { mutableStateOf(false) }
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Green,
                        uncheckedColor = Color.Gray
                    )
                )
                Button(
                    onClick = { /* действие */ },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.White
                    ),
                    shape = RectangleShape,
                    // modifier = Modifier.fillMaxWidth(),
                ) {
                    Text("Купить мясо",
                        fontSize = 20.sp,
                        textDecoration = if (checked) TextDecoration.LineThrough else null)
                }
                Spacer(Modifier.weight(1f, true))
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Filled.Info,
                        contentDescription = "Информация о приложении", modifier = Modifier.size(30.dp),
                        tint = Color.Gray
                    )
                }
                var expanded by remember { mutableStateOf(false) }
                IconButton(
                    onClick = { expanded = !expanded },
                    modifier = Modifier
                        .background(if (expanded) Color.Red else Color.White)
                        .width(if (expanded) 500.dp else 56.dp)
                        .height(56.dp)

                ) {
                    Icon(Icons.Filled.Delete, contentDescription = "Удалить",tint = if (expanded) Color.White else Color.Black)
                }
            }

            Row {
                var checked: Boolean by
                remember { mutableStateOf(false) }
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Green,
                        uncheckedColor = Color.Gray
                    )
                )

                Button(
                    onClick = { /* действие */ },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.White
                    ),
                    shape = RectangleShape,
                    // modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        "Купить хлеб",
                        // modifier = Modifier.weight(1f),

                        fontSize = 20.sp,
                        textDecoration = if (checked) TextDecoration.LineThrough else null
                    )
                }

                Spacer(Modifier.weight(1f, true))
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Filled.Info,
                        contentDescription = "Информация о приложении", modifier = Modifier.size(30.dp),
                        tint = Color.Gray
                    )
                }
                var expanded by remember { mutableStateOf(false) }
                IconButton(
                    onClick = { expanded = !expanded },
                    modifier = Modifier
                        .background(if (expanded) Color.Red else Color.White)
                        .width(if (expanded) 500.dp else 56.dp)
                        .height(56.dp)

                ) {
                    Icon(Icons.Filled.Delete, contentDescription = "Удалить",tint = if (expanded) Color.White else Color.Black)
                }
            }
            Row {
                var checked: Boolean by
                remember { mutableStateOf(false) }
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Green,
                        uncheckedColor = Color.Gray
                    )
                )
                Button(
                    onClick = { /* действие */ },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.White
                    ),
                    shape = RectangleShape,
                    // modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        "Купить яйца",


                        fontSize = 20.sp,
                        textDecoration = if (checked) TextDecoration.LineThrough else null
                    )
                }
                Spacer(Modifier.weight(1f, true))
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Filled.Info,
                        contentDescription = "Информация о приложении", modifier = Modifier.size(30.dp),
                        tint = Color.Gray
                    )
                }
                var expanded by remember { mutableStateOf(false) }
                IconButton(
                    onClick = { expanded = !expanded },
                    modifier = Modifier
                        .background(if (expanded) Color.Red else Color.White)
                        .width(if (expanded) 500.dp else 56.dp)
                        .height(56.dp)

                ) {
                    Icon(Icons.Filled.Delete, contentDescription = "Удалить",tint = if (expanded) Color.White else Color.Black)
                }



            }


            // Spacer(modifier = Modifier.width(0.dp))
            Button(
                onClick = { /* Действие при нажатии */ },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Gray,
                    containerColor = Color.White
                ),
                shape = RectangleShape,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Новое",fontSize = 20.sp)
            }
        }


        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            Button(
                onClick = { /* Действие при нажатии */ },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Blue
                ),
                shape = CircleShape,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.BottomEnd)
                    .padding(15.dp)
            ) {
                Text(text = "+", fontSize = 28.sp)
            }

        }

    }

}
