package com.nikitakonshin.core.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nikitakonshin.model.entities.local.ILocalData
import com.nikitakonshin.model.state.AppState
import kotlinx.coroutines.*

abstract class BaseViewModel<T: ILocalData> : ViewModel() {

    protected val _liveData = MutableLiveData<AppState<T>>()
    val liveData: LiveData<AppState<T>> = _liveData

    private val viewModelCoroutineScope =
        CoroutineScope(
            Dispatchers.Main
                    + SupervisorJob()
                    + CoroutineExceptionHandler { _, error ->
            }
        )

    fun cancelJob(){
        viewModelCoroutineScope.coroutineContext.cancelChildren()
    }

    protected fun runAsync(block: suspend () -> Unit){
        viewModelCoroutineScope.launch {
            block()
        }
    }

    protected fun showLoading(){
        _liveData.value = AppState.Loading()
    }

    override fun onCleared() {
        super.onCleared()
        cancelJob()
    }
}