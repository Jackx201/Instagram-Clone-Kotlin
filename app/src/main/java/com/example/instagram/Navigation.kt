package com.example.instagram

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.instagram.model.Routes

@Composable
fun Screen_First(navigationController: NavHostController){
    Box(modifier = Modifier
        .clickable { navigationController.navigate(Routes.Screen_2.routes) }
        .fillMaxSize()
        .background(Color(0xF9886478))){
        Text(text = "This is the first Screen", color = Color(0xF9FFFFFF), fontSize = 24.sp)
    }
}

@Composable
fun Screen_Second(navigationController: NavHostController){
    Box(modifier = Modifier
        .clickable { navigationController.navigate(Routes.Screen_3.routes) }
        .fillMaxSize()
        .background(Color(0xF9886478))){
        Text(text = "This is the second Screen", color = Color(0xF9FFFFFF), fontSize = 24.sp)
    }
}

@Composable
fun Screen_Third(navigationController: NavHostController){
    Box(modifier = Modifier
        .clickable { navigationController.navigate("Screen_4/2001") }
        .fillMaxSize()
        .background(Color(0xF9886478))){
        Text(text = "This is the third Screen", color = Color(0xF9FFFFFF), fontSize = 24.sp)
    }
}

@Composable
fun Screen_Quarter(navigationController: NavHostController, name: Int) {
    Box(modifier = Modifier
        .clickable { navigationController.navigate(Routes.Screen_1.routes) }
        .fillMaxSize()
        .background(Color(0xF9886478))){
        Text(text = "My name is: Misael de Jesús", color = Color(0xF9FFFFFF), fontSize = 24.sp)
    }
}