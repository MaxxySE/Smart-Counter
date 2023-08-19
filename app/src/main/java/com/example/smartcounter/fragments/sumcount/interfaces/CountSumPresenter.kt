package com.example.smartcounter.fragments.sumcount.interfaces

import com.example.smartcounter.entities.Tarifs

interface CountSumPresenter {
    fun receiveTarif()
    fun countElectricity(input : Float, tarifs: Tarifs)
    fun countColdwater(input : Float, tarifs: Tarifs)
    fun countHotwater(input : Float, tarifs: Tarifs)
}