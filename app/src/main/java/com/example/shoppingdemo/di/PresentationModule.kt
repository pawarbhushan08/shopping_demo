package com.example.shoppingdemo.di

import com.example.shoppingdemo.ui.products.presentation.ProductListViewModel
import com.example.shoppingdemo.ui.products.presentation.ProductsDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
  viewModel { ProductListViewModel(get()) }
  viewModel { ProductsDetailsViewModel() }
}