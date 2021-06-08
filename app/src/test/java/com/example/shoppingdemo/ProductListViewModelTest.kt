package com.cobeisfresh

import com.example.data.common.coroutine.TestCoroutineContextProvider
import com.example.domain.interaction.productListUseCase.GetProductsUseCase
import com.example.domain.model.ProductInfo
import com.example.domain.model.Success
import com.example.shoppingdemo.ui.products.presentation.ProductListViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

class ProductListViewModelTest {

    private val getProducts: GetProductsUseCase = mock()
    private val coroutineContext = TestCoroutineContextProvider()
    private val productListViewModel by lazy { ProductListViewModel(getProducts) }

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Test
    fun `test getProducts sets liveData value when success`() = runBlocking {
        whenever(getProducts()).thenReturn(
            Success(
                listOf(
                    ProductInfo(
                        productName = NAME,
                        productDescription = DESCRIPTION,
                        productImageUrl = IMAGE_URL,
                        productPrice = PRICE,
                        userRating = USER_RATING
                    )
                )
            )
        )
        productListViewModel.getProductsList()
        //assertEquals(ViewState., productListViewModel.getProductsList().value?.status)
    }
}