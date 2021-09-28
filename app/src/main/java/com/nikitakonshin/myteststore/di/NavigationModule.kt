package com.nikitakonshin.myteststore.di

import com.github.terrakok.cicerone.Cicerone
import com.nikitakonshin.feature_main_screen.presentation.navigation.MainScreenNavigator
import com.nikitakonshin.feature_my_cart.presentation.navigation.MyCartNavigator
import com.nikitakonshin.feature_product_details.presentation.navigation.ProductDetailsNavigator
import com.nikitakonshin.feature_splash_screen.navigation.SplashNavigator
import com.nikitakonshin.myteststore.navigation.Screens
import com.nikitakonshin.myteststore.navigation.*
import org.koin.dsl.module

val ciceroneModule = module {

    val cicerone = Cicerone.create()

    factory { cicerone.router }

    factory { cicerone.getNavigatorHolder() }

    single { Screens() }
}
val navigationModule = module {

    factory<ProductDetailsNavigator> { ProductDetailsNavigatorImpl(get(), get()) }
    factory<MyCartNavigator> { MyCartNavigatorImpl(get(), get()) }
    factory<MainScreenNavigator> { MainScreenNavigatorImpl(get(), get()) }
    factory<MainNavigator> { MainNavigatorImpl(get(), get()) }
    factory<SplashNavigator> { SplashNavigatorImpl(get(), get()) }
}