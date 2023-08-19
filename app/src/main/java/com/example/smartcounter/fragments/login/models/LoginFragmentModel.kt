package com.example.smartcounter.fragments.login.models

import com.example.smartcounter.entities.LoginData
import com.example.smartcounter.entities.UserData
import com.example.smartcounter.fragments.login.interfaces.LoginModel

class LoginFragmentModel : LoginModel {

    private var userdata = UserData()

    override fun login(loginData: LoginData): UserData {
        userdata = UserData(
            name = "Никита",
            lastname = "Авдеев",
            payercode = "88005553535"
        )
        return userdata
    }
}