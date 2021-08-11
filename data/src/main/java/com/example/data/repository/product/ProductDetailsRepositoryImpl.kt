package com.example.data.repository.product

import com.example.data.database.dao.ProductDao
import com.example.data.database.model.DbProduct
import com.example.data.networking.ProductsApi
import com.example.domain.model.ProductInfo
import com.example.domain.model.Result
import com.example.domain.repository.ProductDetailRepository

class ProductDetailsRepositoryImpl(
    private val productsApi: ProductsApi,
    private val productDao: ProductDao
) : BaseRepository<ProductInfo, DbProduct>(), ProductDetailRepository {

    override suspend fun getProductDetails(id: Long): Result<ProductInfo> {
        return fetchData(
            dbDataProvider = {
                productDao.getProductDetails(id)
            }
        )
    }

}