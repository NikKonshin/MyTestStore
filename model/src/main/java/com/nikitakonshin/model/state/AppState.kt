package com.nikitakonshin.model.state

sealed class AppState<out T> {
    data class Success<out T>(val data: T) : AppState<T>()
    class Loading<out T>() : AppState<T>()
    data class Error<out T>(val error: Throwable) : AppState<T>()
}