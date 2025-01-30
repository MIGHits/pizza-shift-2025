package com.example.pizza.domain.repository

import com.example.pizza.domain.entity.PizzasCatalog

interface PizzaRepository {
    suspend fun getCatalog():PizzasCatalog
}