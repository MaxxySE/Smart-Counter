package com.example.smartcounter.fragments.login

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.example.smartcounter.R
import com.example.smartcounter.communicator
import com.example.smartcounter.databinding.FragmentLoginBinding
import com.example.smartcounter.entities.LoginData
import com.example.smartcounter.entities.UserData
import com.example.smartcounter.fragments.login.interfaces.LoginView
import com.example.smartcounter.fragments.login.presenters.LoginFragmentPresenter


class LoginFragment : Fragment(R.layout.fragment_login), LoginView {

    private lateinit var binding : FragmentLoginBinding
    private var loginData = LoginData()
    private val loginFragmentPresenter = LoginFragmentPresenter(this)

    @SuppressLint("FragmentBackPressedCallback")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                communicator().setWelcomeFragment()
            }
        })

        binding = FragmentLoginBinding.bind(view)
        buttonListeners()
    }

    private fun buttonListeners(){
        binding.loginBtn.setOnClickListener {
            loginData = LoginData(
                login = binding.loginUserField.text.toString(),
                password = binding.loginPassField.text.toString()
            )
            if (loginData.login != "" && loginData.password != ""){
                loginFragmentPresenter.login(loginData)
            }
        }
        binding.forgetPassBtn.setOnClickListener {
            communicator().setForgetPassFragment()
        }
    }

    override fun login(userData: UserData) {
        if(userData.name != "" && userData.lastname != "" && userData.payercode != ""){
            communicator().setMainFragment(userData)
        }
    }


}