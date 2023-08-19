package com.example.smartcounter.fragments.forgetpass

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.smartcounter.R
import com.example.smartcounter.communicator
import com.example.smartcounter.databinding.FragmentForgetPassBinding


class ForgetPassFragment : Fragment(R.layout.fragment_forget_pass) {

    private lateinit var binding : FragmentForgetPassBinding

    @SuppressLint("FragmentBackPressedCallback")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                communicator().setLoginFragment()
            }
        })

        binding = FragmentForgetPassBinding.bind(view)
        buttonsListener()
    }

    private fun buttonsListener(){
        binding.sendAppealBtn.setOnClickListener {
            communicator().setRecoveryFragment()
        }
    }

}