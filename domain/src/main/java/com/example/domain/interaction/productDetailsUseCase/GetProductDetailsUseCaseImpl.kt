package com.example.domain.interaction.productDetailsUseCase

import com.example.domain.interaction.productListUseCase.GetProductsUseCase
import com.example.domain.model.ProductInfo
import com.example.domain.model.Result
import com.example.domain.repository.ProductDetailRepository
import com.example.domain.repository.ProductRepository

class GetProductDetailsUseCaseImpl (private val productDetailRepository: ProductDetailRepository) :
    GetProductDetailsUseCase {
    override suspend fun invoke(id: Long) = productDetailRepository.getProductDetails(id)
}