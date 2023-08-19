package com.example.smartcounter.fragments.login.interfaces

import com.example.smartcounter.entities.LoginData

interface LoginPresenter {
    fun login(loginData: LoginData)
}