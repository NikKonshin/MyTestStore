package com.nikitakonshin.myteststore.di

import com.nikitakonshin.repositories.data_source.RemoteDataSource
import com.nikitakonshin.repositories.data_source.RemoteDataSourceImpl
import com.nikitakonshin.repositories.interactors.*
import com.nikitakonshin.repositories.repositories.*
import org.koin.dsl.module

val dataSourceModule = module {
    single<RemoteDataSource> {
        RemoteDataSourceImpl(get())
    }
}

val repositoryModule = module {
    single<MainRepository> { MainRepositoryImpl(get()) }
    single<MyCartRepository> { MyCartRepositoryImpl(get()) }
    single<ProductDetailsRepository> { ProductDetailsRepositoryImpl(get()) }
}

val interactorModule = module {
    single<MainInteractor> { MainInteractorImpl(get()) }
    single<MyCartInteractor> { MyCartInteractorImpl(get()) }
    single<ProductDetailsInteractor> { ProductDetailsInteractorImpl(get()) }
}