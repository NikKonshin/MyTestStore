package com.nikitakonshin.myteststore.app

import androidx.multidex.MultiDexApplication
import com.nikitakonshin.myteststore.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:  MultiDexApplication(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                retrofitModule,
                dataSourceModule,
                viewModelModule,
                repositoryModule,
                interactorModule
                )
        }
    }
}