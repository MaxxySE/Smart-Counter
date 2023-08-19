package com.example.smartcounter.fragments.analyse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smartcounter.R
import com.example.smartcounter.databinding.FragmentAnalyseBinding


class AnalyseFragment : Fragment(R.layout.fragment_analyse) {

    private lateinit var binding : FragmentAnalyseBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAnalyseBinding.bind(view)
    }

}