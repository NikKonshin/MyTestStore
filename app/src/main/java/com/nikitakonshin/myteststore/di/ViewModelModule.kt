package com.nikitakonshin.myteststore.di

import com.nikitakonshin.feature_main_screen.presentation.view_model.MainScreenViewModel
import com.nikitakonshin.feature_my_cart.presentation.view_model.MyCartViewModel
import com.nikitakonshin.feature_product_details.presentation.view_moldel.ProductDetailsViewModel
import com.nikitakonshin.feature_splash_screen.view_model.SplashViewModel
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