package com.example.instagram.login.data.network.response

import com.example.instagram.login.core.network.RetrofitHelper
import com.example.instagram.login.data.LoginClient
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

data class LoginResponse(@SerializedName("success") val success: Boolean)

class LoginService{
    val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin():Boolean{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(LoginClient::class.java).doLogin()
                response.body()?.success ?: false
        }
    }
}