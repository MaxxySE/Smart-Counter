package com.example.smartcounter.fragments.prediction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.smartcounter.R
import com.example.smartcounter.databinding.FragmentPredictionBinding

class PredictionFragment : Fragment(R.layout.fragment_prediction) {

    private lateinit var binding : FragmentPredictionBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPredictionBinding.bind(view)
        setSpinnerList(binding.predictionMonth, R.array.month)
        setSpinnerList(binding.predictionYear, R.array.year)
        setSpinnerList(binding.predictionType, R.array.records_type)
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