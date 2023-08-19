package com.example.smartcounter.fragments.main

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import com.example.smartcounter.R
import com.example.smartcounter.communicator
import com.example.smartcounter.databinding.FragmentMainBinding
import com.example.smartcounter.entities.UserData


class MainFragment(
    private val userData: UserData
) : Fragment(R.layout.fragment_main) {

    private lateinit var binding : FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        buttonListeners()
    }

    private fun buttonListeners(){
        binding.mainRecordsBtn.setOnClickListener {
            communicator().setCountSumFragment()
        }
        binding.mainPayBtn.setOnClickListener {
            showPayDialog()
        }
    }

    private fun showPayDialog(){
        val dialog = activity?.let { Dialog(it) }
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(false)
        dialog?.setContentView(R.layout.pay_dialog)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog?.findViewById<Button>(R.id.pay_dialog_button)?.setOnClickListener{
            dialog.hide()
        }
        dialog?.show()
    }

}