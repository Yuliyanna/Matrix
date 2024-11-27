package com.example.eisenhowermatrix.presentation


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eisenhowermatrix.presentation.screen.MainScreen
import com.example.eisenhowermatrix.presentation.screen.MainViewModel
import com.example.eisenhowermatrix.presentation.screen.SuccessScreen
import com.example.eisenhowermatrix.presentation.theme.EisenhowerMatrixTheme

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EisenhowerMatrixTheme{
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreen(viewModel)
                   // MyApp()

                }
            }
        }
    }
/* @Composable
 fun MyApp(viewModel: MainViewModel = viewModel()){
     val currentScreen by viewModel.currentScreen.observeAsState("first_screen")
     NavHost(navController = rememberNavController(), startDestination = "first_screen") {
         composable("first_screen"){
             SuccessScreen(viewModel,mainViewModel)

         }
     }
 }*/


}
