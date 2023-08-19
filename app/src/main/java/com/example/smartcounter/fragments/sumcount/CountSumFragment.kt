package com.example.smartcounter.fragments.sumcount

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.smartcounter.R
import com.example.smartcounter.databinding.FragmentCountSumBinding
import com.example.smartcounter.entities.Tarifs
import com.example.smartcounter.fragments.sumcount.interfaces.CountSumView
import com.example.smartcounter.fragments.sumcount.presenters.CountSumFragmentPresenter


class CountSumFragment : Fragment(R.layout.fragment_count_sum), CountSumView {

    private lateinit var binding : FragmentCountSumBinding
    private var tarifs = Tarifs()
    private var finalSum : Float = 0f
    private var electricity = 0f
    private var coldwater = 0f
    private var hotwater = 0f
    private val countSumFragmentPresenter = CountSumFragmentPresenter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCountSumBinding.bind(view)
        init()
    }

    private fun init(){
        countSumFragmentPresenter.receiveTarif()
        onChangeListeners()
        buttonListeners()
    }

    private fun onChangeListeners(){

        binding.electricityTextedit.addTextChangedListener{
            val electricityText = binding.electricityTextedit.text.toString()
            val inp = if(electricityText != ""){
                electricityText.toFloat()
            } else {
                0f
            }
            countSumFragmentPresenter.countElectricity(inp, tarifs)
        }
        binding.coldWaterTextedit.addTextChangedListener {
            val coldwaterText = binding.coldWaterTextedit.text.toString()
            val inp = if(coldwaterText != ""){
                coldwaterText.toFloat()
            } else {
                0f
            }
            countSumFragmentPresenter.countColdwater(inp, tarifs)
        }
        binding.hotWaterTextedit.addTextChangedListener {
            val hotwaterText = binding.hotWaterTextedit.text.toString()
            val inp = if(hotwaterText != ""){
                hotwaterText.toFloat()
            } else {
                0f
            }
            countSumFragmentPresenter.countHotwater(inp, tarifs)
        }
    }

    private fun buttonListeners(){
        binding.sendDataBtn.setOnClickListener {
            Toast.makeText(context, "Оплачено", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun displayTarifs(tarifs: Tarifs) {
        this.tarifs = tarifs
        binding.electricityTarif.text = "Тарифный план - " + tarifs.electricity.toString() + " руб кВт/час"
        binding.coldWaterTarif.text = "Тарифный план - " + tarifs.coldwater.toString() + " куб.м"
        binding.hotWaterTarif.text = "Тарифный план - " + tarifs.hotwater.toString() + " куб.м"
    }

    @SuppressLint("SetTextI18n")
    override fun addSumElectricity(sum : Float) {
        this.electricity = sum
        finalSum = electricity + coldwater + hotwater
        binding.countOnSentData.text = "$finalSum руб."
    }

    @SuppressLint("SetTextI18n")
    override fun addSumColdwater(sum : Float) {
        this.coldwater = sum
        finalSum = electricity + coldwater + hotwater
        binding.countOnSentData.text = "$finalSum руб."
    }

    @SuppressLint("SetTextI18n")
    override fun addSumHotwater(sum : Float) {
        this.hotwater = sum
        finalSum = electricity + coldwater + hotwater
        binding.countOnSentData.text = "$finalSum руб."
    }

}