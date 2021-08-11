package com.example.shoppingdemo.ui.products.view.fragments

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.example.domain.model.ProductInfo
import com.example.shoppingdemo.R
import com.example.shoppingdemo.common.adapter.ProductListAction
import com.example.shoppingdemo.common.extensions.snackbar
import com.example.shoppingdemo.common.extensions.subscribe
import com.example.shoppingdemo.common.helper.ProductAdapter
import com.example.shoppingdemo.ui.base.*
import com.example.shoppingdemo.ui.products.presentation.ProductListViewModel
import kotlinx.android.synthetic.main.fragment_weather.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductsListFragment : BaseFragment(), ProductListAction {

    private val viewModel: ProductListViewModel by viewModel()

    override fun getLayout() = R.layout.fragment_weather

    var productList = arrayListOf<ProductInfo>()
    val productListAdapter = ProductAdapter(arrayListOf(),this)

    var isCartDataSubscribed = false
    var isWishListSubscribed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }
    override fun viewReady() {
        recyclerView.adapter = productListAdapter
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
        showError(error, shoppingFragmentContainer)
    }

    private fun showNoInternetError() {
        hideLoading(loadingResults)
        snackbar(getString(R.string.no_internet_error_message), shoppingFragmentContainer)
    }

    private fun showProductList(productInfo: List<ProductInfo>) {
        hideLoading(loadingResults)
        productList.addAll(productInfo)
        with(productListAdapter) {
            products.clear()
            products.addAll(productInfo)
            notifyDataSetChanged()
        }
    }

    private fun goToProductDetails(id: Long){
        appFragmentNavigator.showProductDetails(id)
    }

    override fun onClick(id: Long?) {
        //goToProductDetails(id?:0L)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shopping_menu, menu)
    }

    @SuppressLint("ResourceAsColor")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_cart -> {
                if (!isCartDataSubscribed){
                    subscribeToCartData()
                    isWishListSubscribed = false
                } else {
                    subscribeToData()
                    isCartDataSubscribed = false
                }
            }
            R.id.menu_wish_list -> {
                if (!isWishListSubscribed){
                    subscribeToWishListData()
                    isCartDataSubscribed = false
                } else {
                    subscribeToData()
                    isWishListSubscribed = false
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun subscribeToCartData() {
        with(productListAdapter) {
            products.clear()
            products.addAll(productList.filter { it.addedToCart })
            notifyDataSetChanged()
        }
        isCartDataSubscribed = true
    }

    fun subscribeToWishListData(){
        with(productListAdapter) {
            products.clear()
            products.addAll(productList.filter { it.addedToWishList })
            notifyDataSetChanged()
        }
        isWishListSubscribed = true
    }

    companion object {
        fun newInstance() = ProductsListFragment()
    }
}

