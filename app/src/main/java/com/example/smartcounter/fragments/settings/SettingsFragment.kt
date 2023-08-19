package com.example.smartcounter.fragments.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smartcounter.R
import com.example.smartcounter.communicator
import com.example.smartcounter.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private lateinit var binding : FragmentSettingsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)
        buttonListeners()
    }

    private fun buttonListeners(){
        binding.dataBtn.setOnClickListener {
            communicator().setSLoginDataFragment()
        }

        binding.payerBtn.setOnClickListener {
            communicator().setSPayerFragment()
        }

        binding.recordsBtn.setOnClickListener {
            communicator().setSRecordsFragment()
        }
    }

}