package com.example.smartcounter.fragments.sumcount.presenters

import com.example.smartcounter.entities.Tarifs
import com.example.smartcounter.fragments.sumcount.interfaces.CountSumPresenter
import com.example.smartcounter.fragments.sumcount.interfaces.CountSumView
import com.example.smartcounter.fragments.sumcount.models.CountSumFragmentModel

class CountSumFragmentPresenter(
    private val countSumView : CountSumView
) : CountSumPresenter {

    private val countSumFragmentModel = CountSumFragmentModel()

    override fun receiveTarif() {
        countSumView.displayTarifs(countSumFragmentModel.receiveTarif())
    }

    override fun countElectricity(input : Float, tarifs: Tarifs) {
        countSumView.addSumElectricity(countSumFragmentModel.countElectricity(input, tarifs))
    }

    override fun countColdwater(input : Float, tarifs: Tarifs) {
        countSumView.addSumColdwater(countSumFragmentModel.countColdwater(input, tarifs))
    }

    override fun countHotwater(input : Float, tarifs: Tarifs) {
        countSumView.addSumHotwater(countSumFragmentModel.countHotwater(input, tarifs))
    }
}