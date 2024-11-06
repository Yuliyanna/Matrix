package com.example.eisenhowermatrix


import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.material3.*

import androidx.compose.material.icons.filled.Star


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen2(onClose: () -> Unit, onSave: () -> Unit) {
    TopAppBar(
        title = { Text(" ") },
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF0F000000)),

        navigationIcon = {
            IconButton(onClick = onClose) {
                Icon(Icons.Filled.Close, contentDescription = "Закрыть", tint = Color.Black)
            }
        },
        actions = {
            IconButton(onClick = onSave) {
                Icon(Icons.Filled.Star, contentDescription = "Сохранить", tint = Color.Blue)
            }
            Text(
                text = "Coхранить",
                modifier = Modifier.padding(6.dp)

            )
            /*Button(
                onClick = { /* действие */ },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color(0xFF007AFF),
                    containerColor = Color(0xFF0F000000)
                ),
                shape = RectangleShape,
                // modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    "Coхранить",

                    fontSize = 20.sp,

                )
            }*/
        },

        )
}

@Composable
fun MyScreen() {
    Scaffold(
        topBar = {
            MainScreen2(
                onClose = {
                    // Логика закрытия экрана
                },
                onSave = {
                    // Логика сохранения данных
                }
            )
        }
    ) { innerPadding ->
        // Основное содержимое вашего экрана
        Text(
            text = "Содержимое вашего экрана",
            modifier = Modifier.padding(innerPadding)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMyScreen() {
    MyScreen()
}