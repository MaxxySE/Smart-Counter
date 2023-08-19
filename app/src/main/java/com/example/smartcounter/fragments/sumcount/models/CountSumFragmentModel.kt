package com.example.smartcounter.fragments.sumcount.models

import com.example.smartcounter.entities.Tarifs
import com.example.smartcounter.fragments.sumcount.interfaces.CountSumModel

class CountSumFragmentModel : CountSumModel {
    override fun receiveTarif(): Tarifs {

        return Tarifs(
            electricity = 4.68f,
            coldwater = 27.36f,
            hotwater = 161.03f
        )
    }

    override fun countElectricity(input : Float, tarifs: Tarifs): Float {
        return input * tarifs.electricity
    }

    override fun countColdwater(input : Float, tarifs: Tarifs): Float {
        return input * tarifs.coldwater
    }

    override fun countHotwater(input : Float, tarifs: Tarifs): Float {
        return input * tarifs.hotwater
    }
}