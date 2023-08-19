package com.example.smartcounter.fragments.sumcount.interfaces

import com.example.smartcounter.entities.Tarifs

interface CountSumView {
    fun displayTarifs(tarifs : Tarifs)
    fun addSumElectricity(sum : Float)
    fun addSumColdwater(sum : Float)
    fun addSumHotwater(sum : Float)
}