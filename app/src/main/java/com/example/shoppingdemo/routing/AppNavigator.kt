package com.example.shoppingdemo.routing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.shoppingdemo.ui.base.BaseActivity
import com.example.shoppingdemo.ui.products.view.activities.ShoppingActivity
import java.io.Serializable

class AppNavigator(private val activity: AppCompatActivity) : Navigator {
  
  companion object {
    const val SCREEN_TYPE = "screen_type"
  }
  
  override fun showShoppingActivity() = navigateTo(getIntent<ShoppingActivity>().apply {
    putExtra(SCREEN_TYPE, ScreenType.PRODUCTS)
  })
  
  private fun navigateTo(intent: Intent) = activity.startActivity(intent)
  
  private inline fun <reified T : BaseActivity> getIntent() = Intent(activity, T::class.java)
}

enum class ScreenType : Serializable {
  PRODUCTS
}
