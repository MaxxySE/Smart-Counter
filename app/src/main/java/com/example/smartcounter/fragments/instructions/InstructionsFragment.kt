package com.example.smartcounter.fragments.instructions

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.smartcounter.R
import com.example.smartcounter.communicator
import com.example.smartcounter.databinding.FragmentInstructionsBinding
import com.example.smartcounter.entities.UserData

class InstructionsFragment : Fragment(R.layout.fragment_instructions) {

    private lateinit var binding : FragmentInstructionsBinding

    private val urlWork = "https://vk.com/umnieschetchiki?z=video-221223510_456239017%2Fvideos-221223510"
    private val urlWater = "https://vk.com/umnieschetchiki?z=video-221223510_456239019%2Fvideos-221223510%2Fpl_-221223510_-2"
    private val urlElectricity = "https://vk.com/umnieschetchiki?z=video-221223510_456239018%2Fvideos-221223510%2Fpl_-221223510_-2"

    @SuppressLint("FragmentBackPressedCallback")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                communicator().setMainFragment(UserData())
            }
        })

        binding = FragmentInstructionsBinding.bind(view)

        buttonListeners()
    }

    private fun buttonListeners(){
        binding.watchWorkBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(urlWork))
            startActivity(intent)
        }
        binding.watchWaterBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(urlWater))
            startActivity(intent)
        }
        binding.watchElectricityBtn.setOnClickListener {
            Log.d("log", "hello")
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(urlElectricity))
            startActivity(intent)
        }
    }

}