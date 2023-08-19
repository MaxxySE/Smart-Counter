package com.example.smartcounter.fragments.settings.fragments.logindata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smartcounter.R
import com.example.smartcounter.databinding.FragmentSLoginDataBinding
import com.example.smartcounter.databinding.FragmentSRecordsBinding


class SLoginDataFragment : Fragment(R.layout.fragment_s_login_data) {

    private lateinit var binding : FragmentSLoginDataBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSLoginDataBinding.bind(view)
    }

}