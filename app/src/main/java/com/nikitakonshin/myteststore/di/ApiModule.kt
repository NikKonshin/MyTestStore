package com.nikitakonshin.myteststore.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.nikitakonshin.repositories.api.ApiService
import com.nikitakonshin.repositories.api.BaseInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
    single {
        val baseUrl = "https://db2021ecom-edca.restdb.io/"

        val client =
            OkHttpClient
                .Builder()
                .addInterceptor(BaseInterceptor())
                .addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)
                ).build()

        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build()
            .create(ApiService::class.java)
    }
}
