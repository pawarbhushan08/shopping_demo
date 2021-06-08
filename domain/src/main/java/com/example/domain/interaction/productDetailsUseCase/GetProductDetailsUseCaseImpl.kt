package com.example.domain.interaction.productDetailsUseCase

import com.example.domain.interaction.productListUseCase.GetProductsUseCase
import com.example.domain.repository.ProductRepository

class GetProductDetailsUseCaseImpl (private val productRepository: ProductRepository) :
    GetProductDetailsUseCase {

    override suspend operator fun invoke() = productRepository.getProductDetails()
}