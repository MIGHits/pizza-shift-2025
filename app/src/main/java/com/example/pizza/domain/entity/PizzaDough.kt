package com.example.pizza.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PizzaDough (
    val name:Dough,
    val price:Number
) : Parcelable {
    enum class Dough{
        THIN,THICK
    }
}