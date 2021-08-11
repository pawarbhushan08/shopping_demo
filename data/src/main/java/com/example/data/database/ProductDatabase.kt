package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.database.dao.ProductDao
import com.example.data.database.model.DbProduct
import com.example.data.database.model.ProductEntity

@Database(entities = [ProductEntity::class, DbProduct::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun weatherDao(): ProductDao
}