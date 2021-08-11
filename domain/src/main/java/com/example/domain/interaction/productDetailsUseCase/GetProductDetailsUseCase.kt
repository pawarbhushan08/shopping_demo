package com.example.domain.interaction.productDetailsUseCase

import com.example.domain.base.BaseParameterUseCase
import com.example.domain.base.BaseUseCase
import com.example.domain.model.ProductInfo
import com.example.domain.model.Result

interface GetProductDetailsUseCase{
    suspend operator fun invoke(param: Long): Result<ProductInfo>
}