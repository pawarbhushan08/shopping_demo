package com.example.shoppingdemo.ui.products.presentation

import com.example.domain.interaction.productListUseCase.GetProductsUseCase
import com.example.domain.model.ProductInfo
import com.example.domain.model.onFailure
import com.example.domain.model.onSuccess
import com.example.shoppingdemo.ui.base.BaseViewModel
import com.example.shoppingdemo.ui.base.Error
import com.example.shoppingdemo.ui.base.Success

class ProductsDetailsViewModel (private val getProducts: GetProductsUseCase) :
    BaseViewModel<List<ProductInfo>>() {

    fun getProductDetails() = executeUseCase {
        getProducts()
            .onSuccess { _viewState.value = Success(it) }
            .onFailure { _viewState.value = Error(it.throwable) }
    }
}