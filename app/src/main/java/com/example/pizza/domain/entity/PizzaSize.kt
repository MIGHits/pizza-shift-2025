package com.example.pizza.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PizzaSize(
    val name: Size,
    val price: Number
) : Parcelable {
    enum class Size {
        SMALL, MEDIUM, LARGE
    }
}