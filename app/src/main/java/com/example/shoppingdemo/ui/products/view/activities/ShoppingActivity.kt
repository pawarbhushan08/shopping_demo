package com.example.shoppingdemo.ui.products.view.activities

import android.os.Bundle
import com.example.shoppingdemo.R
import com.example.shoppingdemo.routing.AppNavigator
import com.example.shoppingdemo.routing.ScreenType
import com.example.shoppingdemo.ui.base.BaseActivity
import com.example.shoppingdemo.ui.products.view.fragments.ProductsListFragment

class ShoppingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)
        when (intent.getSerializableExtra(AppNavigator.SCREEN_TYPE)) {
            ScreenType.PRODUCTS -> addFragment(
                ProductsListFragment.newInstance(),
                R.id.fragmentContainer,
                true
            )
            else -> finish()
        }
    }
}
