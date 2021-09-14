package com.nikitakonshin.myteststore.di

import com.github.terrakok.cicerone.Cicerone
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

}