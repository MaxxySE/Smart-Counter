package com.example.smartcounter.fragments.settings.fragments.payercode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smartcounter.R
import com.example.smartcounter.communicator
import com.example.smartcounter.databinding.FragmentSPayerBinding
import com.example.smartcounter.databinding.FragmentSRecordsBinding


class SPayerFragment : Fragment(R.layout.fragment_s_payer) {

    private lateinit var binding : FragmentSPayerBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSPayerBinding.bind(view)
        buttonListeners()
    }

    private fun buttonListeners(){
        binding.addBtn.setOnClickListener {
            communicator().setAddCodeFragment()
        }
    }

}