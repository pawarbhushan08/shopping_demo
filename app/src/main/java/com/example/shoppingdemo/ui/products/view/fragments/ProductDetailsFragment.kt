package com.example.shoppingdemo.ui.products.view.fragments

import android.os.Bundle
import com.example.domain.model.ProductInfo
import com.example.shoppingdemo.R
import com.example.shoppingdemo.common.extensions.snackbar
import com.example.shoppingdemo.common.extensions.subscribe
import com.example.shoppingdemo.ui.base.*
import com.example.shoppingdemo.ui.products.presentation.ProductsDetailsViewModel
import kotlinx.android.synthetic.main.fragment_weather.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailsFragment : BaseFragment() {

  private val viewModel: ProductsDetailsViewModel by viewModel()

  override fun getLayout() = R.layout.fragment_weather_details

  private var productId = 0L

  override fun viewReady() {
    arguments?.let {
      productId = it.getLong("PRODUCT_ID")
    }
    viewModel.getProduct(productId)
    subscribeToData()
  }

  private fun subscribeToData() {
    viewModel.viewState.subscribe(this, ::handleViewState)
  }

  private fun handleViewState(viewState: ViewState<ProductInfo>) = when (viewState) {
    is Loading -> showLoading(loadingResults)
    is Success -> showProductDetails(viewState.data)
    is Error -> handleError(viewState.error.localizedMessage)
    is NoInternetState -> showNoInternetError()
  }

  private fun handleError(error: String) {
    hideLoading(loadingResults)
    showError(error, shoppingFragmentContainer)
  }

  private fun showNoInternetError() {
    hideLoading(loadingResults)
    snackbar(getString(R.string.no_internet_error_message), shoppingFragmentContainer)
  }

  private fun showProductDetails(productInfo: ProductInfo) {
    hideLoading(loadingResults)
  }
  
  companion object {
    fun newInstance(id: Long) = ProductDetailsFragment().apply {
      arguments = Bundle().apply {
        putLong("PRODUCT_ID", id)
      }
    }
  }
}