package com.example.smartcounter.fragments.register.interfaces

import com.example.smartcounter.entities.UserData

interface RegisterView {
    fun register(userData: UserData)
}