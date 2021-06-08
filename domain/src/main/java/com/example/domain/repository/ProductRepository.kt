package com.example.domain.repository

import com.example.domain.model.ProductInfo
import com.example.domain.model.Result

interface ProductRepository {
    suspend fun getProductList(): Result<List<ProductInfo>>
    suspend fun getProductDetails(): Result<ProductInfo>
}