package com.example.smartcounter.fragments.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smartcounter.R
import com.example.smartcounter.communicator
import com.example.smartcounter.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    private lateinit var binding : FragmentWelcomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWelcomeBinding.bind(view)
        buttonListeners()
    }

    private fun buttonListeners(){
        binding.loginBtn.setOnClickListener {
            communicator().setLoginFragment()
        }
        binding.registerBtn.setOnClickListener {
            communicator().setRegisterFragment()
        }
    }
}