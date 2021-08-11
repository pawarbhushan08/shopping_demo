package com.example.shoppingdemo.ui.products.presentation

import com.example.domain.interaction.productDetailsUseCase.GetProductDetailsUseCase
import com.example.domain.model.ProductInfo
import com.example.domain.model.onFailure
import com.example.domain.model.onSuccess
import com.example.shoppingdemo.ui.base.BaseViewModel
import com.example.shoppingdemo.ui.base.Error
import com.example.shoppingdemo.ui.base.Success

class ProductsDetailsViewModel (private val getProductDetails: GetProductDetailsUseCase) :
    BaseViewModel<ProductInfo>() {

    fun getProduct(productId: Long) = executeUseCase {
        getProductDetails(productId)
            .onSuccess { _viewState.value = Success(it) }
            .onFailure { _viewState.value = Error(it.throwable) }
    }
}