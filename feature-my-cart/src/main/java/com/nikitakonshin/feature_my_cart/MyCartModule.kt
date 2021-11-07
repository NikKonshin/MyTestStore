package com.nikitakonshin.feature_my_cart

import com.nikitakonshin.core.remote.RetrofitBuilder
import com.nikitakonshin.feature_my_cart.data.MyCartRemoteDataSource
import com.nikitakonshin.feature_my_cart.data.MyCartRemoteDataSourceImpl
import com.nikitakonshin.feature_my_cart.data.MyCartRepositoryImpl
import com.nikitakonshin.feature_my_cart.data.MyCartService
import com.nikitakonshin.feature_my_cart.domain.MyCartInteractor
import com.nikitakonshin.feature_my_cart.domain.MyCartInteractorImpl
import com.nikitakonshin.feature_my_cart.domain.MyCartRepository
import com.nikitakonshin.feature_my_cart.presentation.view_model.MyCartViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myCartModule = module {
    single { RetrofitBuilder.create(MyCartService::class.java) }
    factory<MyCartRemoteDataSource> { MyCartRemoteDataSourceImpl(get()) }
    factory<MyCartRepository> { MyCartRepositoryImpl(get()) }
    factory<MyCartInteractor> { MyCartInteractorImpl(get()) }

    viewModel { MyCartViewModel(get(), get()) }
}