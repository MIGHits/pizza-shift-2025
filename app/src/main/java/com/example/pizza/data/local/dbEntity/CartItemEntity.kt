package com.example.pizza.data.local.dbEntity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pizza.domain.entity.Ingredient
import com.example.pizza.domain.entity.PizzaDough
import com.example.pizza.domain.entity.PizzaEntity
import com.example.pizza.domain.entity.PizzaSize

@Entity(tableName = "CartItemEntity")
data class CartItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val pizza: PizzaEntity,
    val amount: Int,
    val selectedToppings: List<Ingredient>,
    val selectedSize: PizzaSize.Size,
    val selectedDough: PizzaDough.Dough
)