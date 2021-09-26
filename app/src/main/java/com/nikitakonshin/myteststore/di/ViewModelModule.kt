package com.nikitakonshin.myteststore.di

import com.nikitakonshin.myteststore.view_model.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainScreenViewModel(get(), get()) }
    viewModel { ProductDetailsViewModel(get(), get()) }
    viewModel { MyCartViewModel(get(), get()) }
    viewModel { MainViewModel(get()) }
    viewModel { SplashViewModel(get()) }
}