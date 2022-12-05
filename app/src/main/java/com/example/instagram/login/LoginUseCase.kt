package com.example.instagram.login

//import com.example.instagram.login.data.network.response.LoginRepository
import com.example.instagram.login.data.network.response.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository) {

    suspend operator fun invoke():Boolean{
        return repository.doLogin()
    }
}