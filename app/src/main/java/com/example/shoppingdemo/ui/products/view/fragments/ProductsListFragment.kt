package com.example.shoppingdemo.ui.products.view.fragments

import androidx.recyclerview.widget.GridLayoutManager
import com.example.domain.model.ProductInfo
import com.example.shoppingdemo.R
import com.example.shoppingdemo.common.adapter.ProductListAdapter
import com.example.shoppingdemo.common.extensions.snackbar
import com.example.shoppingdemo.common.extensions.subscribe
import com.example.shoppingdemo.ui.base.*
import com.example.shoppingdemo.ui.products.presentation.ProductListViewModel
import kotlinx.android.synthetic.main.fragment_weather.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductsListFragment : BaseFragment(), ProductListAdapter {

    private val viewModel: ProductListViewModel by viewModel()

    override fun getLayout() = R.layout.fragment_weather

    override fun viewReady() {
        recyclerView.adapter = viewModel.photosAdapter
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        viewModel.getProductsList()
        subscribeToData()
    }

    private fun subscribeToData() {
        viewModel.viewState.subscribe(this, ::handleViewState)
    }

    private fun handleViewState(viewState: ViewState<List<ProductInfo>>) = when (viewState) {
        is Loading -> showLoading(loadingResults)
        is Success -> showProductList(viewState.data)
        is Error -> handleError(viewState.error.localizedMessage)
        is NoInternetState -> showNoInternetError()
    }

    private fun handleError(error: String) {
        hideLoading(loadingResults)
        showError(error, weatherFragmentContainer)
    }

    private fun showNoInternetError() {
        hideLoading(loadingResults)
        snackbar(getString(R.string.no_internet_error_message), weatherFragmentContainer)
    }

    private fun showProductList(productInfo: List<ProductInfo>) {
        hideLoading(loadingResults)
        with(viewModel.photosAdapter) {
            products.clear()
            products.addAll(productInfo)
            notifyDataSetChanged()
        }
    }

    private fun goToProductDetails(id: String?){
        appFragmentNavigator.showProductDetails()
    }

    override fun onClick(id: String?) {
        goToProductDetails(id?:"")
    }
    companion object {
        fun newInstance() = ProductsListFragment()
    }
}

