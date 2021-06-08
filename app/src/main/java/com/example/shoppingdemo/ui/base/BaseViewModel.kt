package com.example.shoppingdemo.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.common.coroutine.CoroutineContextProvider
import com.example.data.common.utils.Connectivity
import com.example.shoppingdemo.common.extensions.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseViewModel<T : Any> : ViewModel(), KoinComponent {

    protected val coroutineContext: CoroutineContextProvider by inject()
    private val connectivity: Connectivity by inject()

    protected val _viewState = MutableLiveData<ViewState<T>>()
    val viewState: LiveData<ViewState<T>>
        get() = _viewState

    //Just to add View Effects in case any
//    protected val _viewEffects = MutableLiveData<E>()
//    val viewEffects: LiveData<E>
//        get() = _viewEffects

    protected fun executeUseCase(action: suspend () -> Unit, noInternetAction: () -> Unit) {
        _viewState.value = Loading()
        if (connectivity.hasNetworkAccess()) {
            launch { action() }
        } else {
            noInternetAction()
        }
    }

    protected fun executeUseCase(action: suspend () -> Unit) {
        _viewState.value = Loading()
        launch { action() }
    }
}