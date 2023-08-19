package com.example.smartcounter.fragments.archive.fragments.table

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.smartcounter.R
import com.example.smartcounter.databinding.FragmentTableBinding
import com.example.smartcounter.entities.TableData

class TableFragment(
    private val tableData: TableData
) : Fragment(R.layout.fragment_table) {

    private lateinit var binding : FragmentTableBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTableBinding.bind(view)
        setSpinners()
        setData()
    }

    private fun setSpinners(){
        setSpinnerList(binding.tableMonth, R.array.month)
        setSpinnerList(binding.tableYear, R.array.year)
        setSpinnerList(binding.tableType, R.array.records_type)
    }

    private fun setData(){
        binding.textMonthExample.text = tableData.month
        binding.textYearExample.text = tableData.year
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