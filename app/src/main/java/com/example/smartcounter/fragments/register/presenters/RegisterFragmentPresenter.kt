package com.example.smartcounter.fragments.register.presenters

import com.example.smartcounter.entities.RegisterData
import com.example.smartcounter.fragments.register.interfaces.RegisterPresenter
import com.example.smartcounter.fragments.register.interfaces.RegisterView
import com.example.smartcounter.fragments.register.models.RegisterFragmentModel

class RegisterFragmentPresenter(
    private val registerView : RegisterView
) : RegisterPresenter {

    private val registerFragmentModel = RegisterFragmentModel()

    override fun register(registerData: RegisterData) {
        registerView.register(registerFragmentModel.register(registerData))
    }
}