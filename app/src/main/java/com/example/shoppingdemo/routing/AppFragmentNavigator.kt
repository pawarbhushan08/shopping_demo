package com.example.shoppingdemo.routing

import androidx.fragment.app.FragmentActivity
import com.example.shoppingdemo.R
import com.example.shoppingdemo.common.extensions.showFragment
import com.example.shoppingdemo.ui.products.view.fragments.ProductDetailsFragment

/**
 * Every activity that holds fragments should name its container "fragmentContainer"
 */

class AppFragmentNavigator(private val activity: FragmentActivity) : FragmentNavigator {

    override fun showProductDetails() =
        activity.showFragment(ProductDetailsFragment.newInstance(), R.id.fragmentContainer, true)
}

