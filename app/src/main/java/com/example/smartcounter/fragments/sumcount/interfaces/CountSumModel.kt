package com.example.smartcounter.fragments.sumcount.interfaces

import com.example.smartcounter.entities.Tarifs

interface CountSumModel {
    fun receiveTarif() : Tarifs
    fun countElectricity(input : Float, tarifs: Tarifs) : Float
    fun countColdwater(input : Float, tarifs: Tarifs) : Float
    fun countHotwater(input : Float, tarifs: Tarifs) : Float
}