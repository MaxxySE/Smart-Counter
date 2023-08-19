package com.example.smartcounter.fragments.settings.fragments.records

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.smartcounter.R
import com.example.smartcounter.communicator
import com.example.smartcounter.databinding.FragmentSRecordsBinding


class SRecordsFragment : Fragment(R.layout.fragment_s_records) {

    private lateinit var binding : FragmentSRecordsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSRecordsBinding.bind(view)
        buttonListeners()
        setSpinnerList(binding.dataSpinnerType, R.array.records_type)
    }

    private fun buttonListeners(){
        binding.showDataBtn.setOnClickListener {
            communicator().setShowDataFragment()
        }
    }

    private fun setSpinnerList(spinner: Spinner, resource: Int) {
        ArrayAdapter.createFromResource(
            requireContext(),
            resource,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

}