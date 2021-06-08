package com.example.domain.interaction.productListUseCase

import com.example.domain.repository.ProductRepository

class GetProductsUseCaseImpl(private val productRepository: ProductRepository) :
    GetProductsUseCase {

    override suspend operator fun invoke() = productRepository.getProductList()
}