package com.example.shoppingdemo.di

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.data.common.coroutine.CoroutineContextProvider
import com.example.shoppingdemo.routing.AppFragmentNavigator
import com.example.shoppingdemo.routing.AppNavigator
import org.koin.dsl.module

val appModule = module {
  single { CoroutineContextProvider() }
  single { (activity: AppCompatActivity) -> AppNavigator(activity) }
  single { (activity: FragmentActivity) -> AppFragmentNavigator(activity) }
}