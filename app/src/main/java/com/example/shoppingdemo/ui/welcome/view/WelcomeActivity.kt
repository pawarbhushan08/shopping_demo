package com.example.shoppingdemo.ui.welcome.view

import android.os.Bundle
import com.example.shoppingdemo.R
import com.example.shoppingdemo.common.extensions.onClick
import com.example.shoppingdemo.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        nextScreen.onClick {
            appNavigator.showShoppingActivity()
            finish()
        }
    }
}