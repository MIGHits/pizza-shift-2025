package com.example.pizza.data.repository

import com.example.pizza.data.local.dao.CartDao
import com.example.pizza.data.local.dbEntity.CartItemEntity
import com.example.pizza.data.mapper.CartMapper
import com.example.pizza.domain.entity.CartItem
import com.example.pizza.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow

class CartRepositoryImpl(private val cartDao: CartDao, private val cartMapper: CartMapper) :
    CartRepository {
    override suspend fun addToCart(cartItem: CartItem) {
        cartDao.addToCart(cartMapper.mapToDbModel(cartItem))
    }

    override suspend fun removeFromCart(cartItem: CartItem) {
        cartDao.removeFromCart(cartMapper.mapToDbModel(cartItem))
    }

    override suspend fun updateCart(cartItem: CartItem) {
        cartDao.updateCart(cartMapper.mapToDbModel(cartItem))
    }

    override suspend fun getCart(): Flow<List<CartItem>> {
        return cartMapper.map(cartDao.getCart())
    }
}