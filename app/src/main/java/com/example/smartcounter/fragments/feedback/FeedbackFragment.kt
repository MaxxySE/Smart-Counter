package com.example.smartcounter.fragments.feedback

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smartcounter.R
import com.example.smartcounter.databinding.FragmentFeedbackBinding


class FeedbackFragment : Fragment(R.layout.fragment_feedback) {

    private lateinit var binding : FragmentFeedbackBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFeedbackBinding.bind(view)
    }

}