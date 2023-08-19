package com.example.smartcounter.fragments.register.models

import com.example.smartcounter.entities.RegisterData
import com.example.smartcounter.entities.UserData
import com.example.smartcounter.fragments.register.interfaces.RegisterModel

class RegisterFragmentModel : RegisterModel {

    private var userData = UserData()

    override fun register(registerData: RegisterData): UserData {
        //here i should receive data from server
        userData = UserData(
            name = "Иван",
            lastname = "Андреев",
            payercode = "1337228420"
        )
        return userData
    }
}