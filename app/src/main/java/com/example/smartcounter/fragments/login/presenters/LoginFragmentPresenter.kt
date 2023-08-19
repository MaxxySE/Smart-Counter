package com.example.smartcounter.fragments.login.presenters

import com.example.smartcounter.entities.LoginData
import com.example.smartcounter.fragments.login.interfaces.LoginPresenter
import com.example.smartcounter.fragments.login.interfaces.LoginView
import com.example.smartcounter.fragments.login.models.LoginFragmentModel

class LoginFragmentPresenter(
    private val loginView: LoginView
) : LoginPresenter {

    private val loginFragmentModel = LoginFragmentModel()

    override fun login(loginData: LoginData) {
        loginView.login(loginFragmentModel.login(loginData))
    }
}