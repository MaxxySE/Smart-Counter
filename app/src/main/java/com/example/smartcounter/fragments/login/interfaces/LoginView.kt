package com.example.smartcounter.fragments.login.interfaces

import com.example.smartcounter.entities.UserData


interface LoginView {
    fun login(userData: UserData)
}