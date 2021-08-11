package com.example.data.di

import com.example.data.common.utils.Connectivity
import com.example.data.common.utils.ConnectivityImpl
import com.example.data.repository.product.ProductDetailsRepositoryImpl
import com.example.data.repository.product.ProductRepositoryImpl
import com.example.domain.repository.ProductDetailRepository
import com.example.domain.repository.ProductRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    factory<ProductRepository> { ProductRepositoryImpl(get(), get()) }
    factory<ProductDetailRepository> { ProductDetailsRepositoryImpl(get(), get()) }

    factory<Connectivity> { ConnectivityImpl(androidContext()) }
}