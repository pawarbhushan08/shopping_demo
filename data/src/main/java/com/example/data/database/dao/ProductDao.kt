package com.example.data.database.dao

import androidx.room.*
import com.example.data.database.PRODUCT_LIST_TABLE_NAME
import com.example.data.database.PRODUCT_TABLE_NAME
import com.example.data.database.model.DbProduct
import com.example.data.database.model.ProductEntity

@Dao
interface ProductDao {

    @Transaction
    suspend fun updateProductAndReturn(product: ProductEntity): ProductEntity {
        saveProducts(product)
        return getProducts()
    }

    @Query("SELECT * FROM $PRODUCT_LIST_TABLE_NAME")
    suspend fun getProducts(): ProductEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProducts(product: ProductEntity)

    @Query("SELECT * FROM $PRODUCT_TABLE_NAME WHERE id = :id")
    suspend fun getProductDetails(id: Long): DbProduct
}