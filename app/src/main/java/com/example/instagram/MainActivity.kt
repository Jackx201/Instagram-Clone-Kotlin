package com.example.instagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.instagram.model.Routes
import com.example.instagram.ui.theme.InstagramTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(navController = navigationController, startDestination = Routes.Screen_1.routes){
                        composable("home"){ ScaffoldExample()}
                        composable(Routes.Screen_1.routes){ Screen_First(navigationController) }
                        composable(Routes.Screen_2.routes){ Screen_Second(navigationController) }
                        composable(Routes.Screen_3.routes){ Screen_Third(navigationController) }
                        composable("Screen_4/{name}", arguments = listOf(navArgument("name"){
                            type = NavType.IntType
                        })){
                            navBackStackEntry -> 
                            Screen_Quarter(navigationController = navigationController,
                                name = navBackStackEntry.arguments?.getInt("name")?:0)
                        }
                    }
                }
            }
        }
    }
}