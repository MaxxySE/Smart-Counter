package com.example.smartcounter.fragments.register.interfaces

import com.example.smartcounter.entities.RegisterData
import com.example.smartcounter.entities.UserData

interface RegisterModel {
    fun register(registerData: RegisterData) : UserData
}