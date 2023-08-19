package com.example.smartcounter.fragments.login.interfaces

import com.example.smartcounter.entities.LoginData
import com.example.smartcounter.entities.UserData

interface LoginModel {
    fun login(loginData: LoginData) : UserData
}