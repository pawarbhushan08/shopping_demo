package com.example.domain.interaction.productDetailsUseCase

import com.example.domain.base.BaseUseCase
import com.example.domain.model.ProductInfo
import com.example.domain.model.Result

interface GetProductDetailsUseCase: BaseUseCase<String, ProductInfo> {
    override suspend fun invoke(): Result<ProductInfo>
}