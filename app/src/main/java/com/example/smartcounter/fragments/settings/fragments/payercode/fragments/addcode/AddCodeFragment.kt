package com.example.smartcounter.fragments.settings.fragments.payercode.fragments.addcode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smartcounter.R
import com.example.smartcounter.communicator
import com.example.smartcounter.databinding.FragmentAddCodeBinding


class AddCodeFragment : Fragment(R.layout.fragment_add_code) {

    private lateinit var binding : FragmentAddCodeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddCodeBinding.bind(view)
        buttonListeners()
    }

    private fun buttonListeners(){
        binding.saveBtn.setOnClickListener {
            communicator().setSPayerFragment()
        }
    }

}