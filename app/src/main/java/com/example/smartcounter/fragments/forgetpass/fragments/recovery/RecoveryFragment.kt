package com.example.smartcounter.fragments.forgetpass.fragments.recovery

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.smartcounter.R
import com.example.smartcounter.communicator
import com.example.smartcounter.databinding.FragmentRecoveryBinding


class RecoveryFragment : Fragment(R.layout.fragment_recovery) {

    private lateinit var binding : FragmentRecoveryBinding

    @SuppressLint("FragmentBackPressedCallback")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                communicator().setForgetPassFragment()
            }
        })

        binding = FragmentRecoveryBinding.bind(view)
        buttonListeners()
    }

    private fun buttonListeners(){
        binding.recoveryBtn.setOnClickListener {
            communicator().setWelcomeFragment()
        }
    }

}