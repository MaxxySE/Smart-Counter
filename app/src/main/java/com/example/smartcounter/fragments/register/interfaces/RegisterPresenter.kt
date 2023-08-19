package com.example.smartcounter.fragments.register.interfaces

import com.example.smartcounter.entities.RegisterData

interface RegisterPresenter {
    fun register(registerData: RegisterData)
}