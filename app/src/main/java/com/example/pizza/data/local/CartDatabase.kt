package com.example.pizza.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pizza.App
import com.example.pizza.data.local.dao.CartDao
import com.example.pizza.data.local.dbEntity.CartItemEntity


@Database(version = 3, exportSchema = false, entities = [CartItemEntity::class])
@TypeConverters(PizzaEntityConverter::class)
abstract class CartDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao

    companion object {
        fun getDatabase(): CartDatabase {
            return Room.databaseBuilder(
                context = App.instance,
                CartDatabase::class.java,
                "CartDb"
            ).fallbackToDestructiveMigration()
                .build()
        }
    }
}