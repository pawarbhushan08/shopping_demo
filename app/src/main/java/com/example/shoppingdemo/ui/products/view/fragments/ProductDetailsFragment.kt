package com.example.shoppingdemo.ui.products.view.fragments

import com.example.shoppingdemo.R
import com.example.shoppingdemo.ui.base.BaseFragment

class ProductDetailsFragment : BaseFragment() {
  
  override fun getLayout() = R.layout.fragment_weather_details
  
  override fun viewReady() {

  }
  
  companion object {
    fun newInstance() = ProductDetailsFragment()
  }
}