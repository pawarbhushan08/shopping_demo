package com.example.domain.repository

import com.example.domain.model.ProductInfo
import com.example.domain.model.Result

interface ProductDetailRepository {
    suspend fun getProductDetails(id: Long): Result<ProductInfo>
}