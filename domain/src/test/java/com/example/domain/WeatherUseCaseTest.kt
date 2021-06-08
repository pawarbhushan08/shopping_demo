package com.example.domain


import com.example.domain.interaction.productListUseCase.GetProductsUseCaseImpl
import com.example.domain.repository.ProductRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.Test

class WeatherUseCaseTest {

    private val productRepository: ProductRepository = mock()
    private val getProduct by lazy { GetProductsUseCaseImpl(productRepository) }

    @Test
    fun `test GetWeatherUseCase calls WeatherRepository`() {
        runBlocking {
            getProduct()
            verify(productRepository).getProductList()
        }
    }
}