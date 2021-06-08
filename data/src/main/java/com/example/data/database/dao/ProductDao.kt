package com.example.data.database.dao

import androidx.room.*
import com.example.data.database.WEATHER_TABLE_NAME
import com.example.data.database.model.ProductEntity
import com.example.data.networking.model.Product
import com.example.data.networking.model.ProductInfoResponse
import com.example.domain.model.ProductInfo

@Dao
interface ProductDao {

    @Transaction
    suspend fun updateProductAndReturn(product: ProductEntity): ProductEntity {
        saveProducts(product)
        return getProducts()
    }

    @Query("SELECT * FROM $WEATHER_TABLE_NAME")
    suspend fun getProducts(): ProductEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProducts(product: ProductEntity)

    @Query("SELECT * FROM $WEATHER_TABLE_NAME WHERE id = :id")
    fun getProductDetails(id: String) : ProductInfo
}