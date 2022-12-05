package com.example.instagram.login.data.network.response

import com.example.instagram.login.data.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api : LoginService){

    suspend fun doLogin():Boolean{
        return api.doLogin()
    }
}