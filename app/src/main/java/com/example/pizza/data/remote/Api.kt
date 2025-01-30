package com.example.pizza.data.remote

import com.example.pizza.common.URL.GET_PIZZAS
import com.example.pizza.data.entity.PizzasResponse
import retrofit2.http.GET

interface Api {
    @GET(GET_PIZZAS)
    suspend fun getPizzasCatalog():PizzasResponse
}