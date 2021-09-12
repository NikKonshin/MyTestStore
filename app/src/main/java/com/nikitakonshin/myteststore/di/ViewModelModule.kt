package com.nikitakonshin.myteststore.di

import com.nikitakonshin.myteststore.view_model.MainScreenViewModel
import com.nikitakonshin.myteststore.view_model.MyCartViewModel
import com.nikitakonshin.myteststore.view_model.ProductDetailsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainScreenViewModel(get()) }
    viewModel { ProductDetailsViewModel(get()) }
    viewModel { MyCartViewModel(get()) }
}