package com.dev.democompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev.democompose.ui.Screen
import com.dev.democompose.ui.SecondUI
import com.dev.democompose.ui.ThirdUI
import com.dev.democompose.ui.firstUI
import com.dev.democompose.ui.theme.DemoComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = Screen.FirstUI.route
                    ){
                        composable(
                            route = Screen.FirstUI.route
                        ){
                            firstUI(navController)
                        }
                        composable(
                            route = Screen.SecondUI.route
                        ){
                            SecondUI()
                        }
                        composable(
                            route = Screen.ThirdUI.route
                        ){
                            ThirdUI()
                        }
                    }
                }
            }
        }
    }
}


