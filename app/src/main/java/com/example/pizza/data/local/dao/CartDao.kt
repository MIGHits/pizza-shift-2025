package com.example.pizza.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.pizza.data.local.dbEntity.CartItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addToCart(cartItemEntity: CartItemEntity)

    @Delete
    suspend fun removeFromCart(cartItemEntity: CartItemEntity)

    @Update
    suspend fun updateCart(cartItemEntity: CartItemEntity)

    @Query("SELECT * FROM CartItemEntity")
    fun getCart(): Flow<List<CartItemEntity>>
}