package com.example.pizza.data.mapper

import com.example.pizza.data.local.dbEntity.CartItemEntity
import com.example.pizza.domain.entity.CartItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CartMapper {
    private fun map(cartItem: CartItemEntity): CartItem {
        return CartItem(
            id = cartItem.id,
            amount = cartItem.amount,
            pizza = cartItem.pizza,
            toppings = cartItem.selectedToppings,
            selectedSize = cartItem.selectedSize,
            selectedDough = cartItem.selectedDough
        )
    }

    fun map(cartList: Flow<List<CartItemEntity>>): Flow<List<CartItem>> {
        return cartList.map { data -> data.map { map(it) } }
    }

    fun mapToDbModel(cartItem: CartItem): CartItemEntity {
        return CartItemEntity(
            id = cartItem.id,
            amount = cartItem.amount,
            pizza = cartItem.pizza,
            selectedToppings = cartItem.toppings,
            selectedSize = cartItem.selectedSize,
            selectedDough = cartItem.selectedDough
        )
    }
}