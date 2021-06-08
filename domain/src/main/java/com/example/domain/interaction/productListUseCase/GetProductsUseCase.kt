package com.example.domain.interaction.productListUseCase

import com.example.domain.base.BaseUseCase
import com.example.domain.model.Result
import com.example.domain.model.ProductInfo

interface GetProductsUseCase : BaseUseCase<String, List<ProductInfo>> {

    override suspend operator fun invoke(): Result<List<ProductInfo>>
}