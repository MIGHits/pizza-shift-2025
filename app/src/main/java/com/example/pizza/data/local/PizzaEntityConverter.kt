package com.example.pizza.data.local

import androidx.room.TypeConverter
import com.example.pizza.domain.entity.Ingredient
import com.example.pizza.domain.entity.PizzaDough
import com.example.pizza.domain.entity.PizzaEntity
import com.example.pizza.domain.entity.PizzaSize
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PizzaEntityConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromPizzaEntity(pizzaEntity: PizzaEntity): String {
        return gson.toJson(pizzaEntity)
    }

    @TypeConverter
    fun toPizzaEntity(json: String): PizzaEntity {
        val type = object : TypeToken<PizzaEntity>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromToppingsEntity(toppings: List<Ingredient>): String {
        return gson.toJson(toppings)
    }

    @TypeConverter
    fun toToppings(json: String): List<Ingredient> {
        val type = object : TypeToken<List<Ingredient>>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromPizzaSizeEntity(size: PizzaSize): String {
        return gson.toJson(size)
    }

    @TypeConverter
    fun toPizzaSize(json: String): PizzaSize {
        val type = object : TypeToken<PizzaSize>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromPizzaDough(dough: PizzaDough): String {
        return gson.toJson(dough)
    }

    @TypeConverter
    fun toPizzaDough(json: String): PizzaDough {
        val type = object : TypeToken<PizzaDough>() {}.type
        return gson.fromJson(json, type)
    }
}