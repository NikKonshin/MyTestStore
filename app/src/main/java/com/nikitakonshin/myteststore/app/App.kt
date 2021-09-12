package com.nikitakonshin.myteststore.app

import androidx.multidex.MultiDexApplication
import com.nikitakonshin.myteststore.di.dataSourceModule
import com.nikitakonshin.myteststore.di.viewModelModule
import com.nikitakonshin.myteststore.di.retrofitModule
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
                viewModelModule
                )
        }
    }
}