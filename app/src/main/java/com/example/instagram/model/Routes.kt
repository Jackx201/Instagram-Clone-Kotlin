package com.example.instagram.model

sealed class Routes(val routes:String){
    object Screen_1:Routes("Screen_1")
    object Screen_2:Routes("Screen_2")
    object Screen_3:Routes("Screen_3")

}
