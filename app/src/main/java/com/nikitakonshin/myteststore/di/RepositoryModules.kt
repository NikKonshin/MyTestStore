package com.nikitakonshin.myteststore.di

import com.nikitakonshin.repositories.data_source.RemoteDataSource
import com.nikitakonshin.repositories.data_source.RemoteDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<RemoteDataSource> {
        RemoteDataSourceImpl(get())
    }
}