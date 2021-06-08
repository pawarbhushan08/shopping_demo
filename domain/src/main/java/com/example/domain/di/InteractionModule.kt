package com.example.domain.di

import com.example.domain.interaction.productListUseCase.GetProductsUseCase
import com.example.domain.interaction.productListUseCase.GetProductsUseCaseImpl
import org.koin.dsl.module

val interactionModule = module {
    factory<GetProductsUseCase> { GetProductsUseCaseImpl(get()) }
}