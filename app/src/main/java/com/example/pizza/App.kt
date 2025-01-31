package com.example.pizza

import android.app.Application
import android.content.Context
import com.example.pizza.di.appModule
import com.example.pizza.di.dataModule
import com.example.pizza.di.domainModule
import com.example.pizza.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {
    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this;
        startKoin {
            androidContext(this@App)
            modules(networkModule, dataModule, domainModule, appModule)
        }

    }
}