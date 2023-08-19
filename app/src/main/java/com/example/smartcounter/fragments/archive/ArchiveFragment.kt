package com.example.smartcounter.fragments.archive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.smartcounter.R
import com.example.smartcounter.communicator
import com.example.smartcounter.databinding.FragmentArchiveBinding
import com.example.smartcounter.entities.TableData


class ArchiveFragment : Fragment(R.layout.fragment_archive) {

    private lateinit var binding : FragmentArchiveBinding
    private var tableData = TableData()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArchiveBinding.bind(view)
        setSpinners()
        setButtonListeners()
    }

    private fun setSpinners(){
        setSpinnerList(binding.archiveMonth, R.array.month)
        setSpinnerList(binding.archiveYear, R.array.year)
        setSpinnerList(binding.archiveType, R.array.records_type)
    }

    private fun setButtonListeners(){
        binding.showTableBtn.setOnClickListener {
            tableData = TableData(
                month = binding.archiveMonth.selectedItem.toString(),
                year = binding.archiveYear.selectedItem.toString()
            )
            communicator().setTableFragment(tableData)
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