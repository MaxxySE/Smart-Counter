package com.example.smartcounter.fragments.register

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.smartcounter.R
import com.example.smartcounter.communicator
import com.example.smartcounter.databinding.FragmentRegisterBinding
import com.example.smartcounter.entities.RegisterData
import com.example.smartcounter.entities.UserData
import com.example.smartcounter.fragments.register.interfaces.RegisterView
import com.example.smartcounter.fragments.register.presenters.RegisterFragmentPresenter


class RegisterFragment : Fragment(R.layout.fragment_register), RegisterView {

    private var registerData = RegisterData()
    private var userData = UserData()
    private val registerFragmentPresenter = RegisterFragmentPresenter(this)
    private lateinit var binding : FragmentRegisterBinding

    @SuppressLint("FragmentBackPressedCallback")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                communicator().setWelcomeFragment()
            }
        })

        binding = FragmentRegisterBinding.bind(view)
        buttonsListeners()
    }

    private fun buttonsListeners(){
        binding.registerBtn.setOnClickListener {
            registerData = RegisterData(
                login = binding.registerUsername.text.toString(),
                password = binding.registerPassword.text.toString(),
                payercode = binding.registerPayercode.text.toString()
            )
            if (registerData.login != "" && registerData.password != "" && registerData.payercode != ""
                && registerData.password == binding.registerPasswordRepeat.text.toString()){
                registerFragmentPresenter.register(registerData)
            }
        }
    }

    override fun register(userData: UserData) {
        this.userData = userData
        if (userData.name != "" && userData.lastname != "" && userData.payercode != ""){
            communicator().setMainFragment(userData)
            Log.d("UserData", "name: " + userData.name + ", lastname: " + userData.lastname + ", payercode: " + userData.payercode)
        }
    }
}