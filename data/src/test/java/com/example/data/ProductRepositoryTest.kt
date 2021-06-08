package com.example.data

import com.example.data.common.utils.Connectivity
import com.example.data.database.dao.ProductDao
import com.example.data.networking.ProductsApi
import com.example.data.repository.weather.ProductRepositoryImpl
import com.example.data.utils.*
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.Response

class ProductRepositoryTest {

    private val productsTestApi: ProductsApi = mock()
    private val productDao: ProductDao = mock()
    private val connectivity: Connectivity = mock()
    private val productRepository = ProductRepositoryImpl(productsApi =productsTestApi, productDao =productDao)

    @Test
    fun `test getProducts calls api and saves data to db upon success`() {
        runBlocking {
            whenever(connectivity.hasNetworkAccess()).thenReturn(true)
            whenever(productsTestApi.getProducts()).thenReturn(
                Response.success(
                    successProductInfoResponse
                )
            )
            whenever(productDao.updateProductAndReturn(successProductInfoResponse.mapToRoomEntity())).thenReturn(
                fakeProductEntity
            )
            productRepository.getProductList()

            verify(productsTestApi, times(1)).getProducts()
            verify(productDao, times(1)).updateProductAndReturn(fakeProductEntity)
        }
    }

    @Test
    fun `test getProducts calls api and returns cached data from db upon failure`() {
        runBlocking {
            whenever(connectivity.hasNetworkAccess()).thenReturn(true)
            whenever(productsTestApi.getProducts())
                .thenReturn(Response.error(FAKE_FAILURE_ERROR_CODE, failureResponseBody))
            productRepository.getProductList()

            verify(productsTestApi, times(1)).getProducts()
            verify(productDao, never()).updateProductAndReturn(fakeProductEntity)
        }
    }
}