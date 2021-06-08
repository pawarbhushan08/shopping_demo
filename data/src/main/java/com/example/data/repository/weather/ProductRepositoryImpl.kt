package com.example.data.repository.weather

import com.example.data.database.dao.ProductDao
import com.example.data.database.model.ProductEntity
import com.example.data.networking.ProductsApi
import com.example.data.networking.base.getData
import com.example.domain.model.ProductInfo
import com.example.domain.model.Result
import com.example.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val productsApi: ProductsApi,
    private val productDao: ProductDao
) : BaseRepository<List<ProductInfo>, ProductEntity>(), ProductRepository {

    override suspend fun getProductList(): Result<List<ProductInfo>> {
        return fetchData(
            apiDataProvider = {
                productsApi.getProducts().getData(
                    fetchFromCacheAction = { productDao.getProducts() },
                    cacheAction = { productDao.saveProducts(it) })
            },
            dbDataProvider = { productDao.getProducts() }
        )
    }

    override suspend fun getProductDetails(): Result<ProductInfo> {
        return fetchData({ productDao.getProductDetails(id)})
    }
}