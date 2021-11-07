package com.nikitakonshin.myteststore.di

import com.nikitakonshin.core.remote.RetrofitBuilder
import com.nikitakonshin.repositories.api.ApiService
import org.koin.dsl.module

val retrofitModule = module {
    single { RetrofitBuilder.create(ApiService::class.java) }
}
