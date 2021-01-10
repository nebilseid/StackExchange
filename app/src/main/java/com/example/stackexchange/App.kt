package com.example.stackexchange

import android.app.Application
import com.example.stackexchange.di.networkModule
import com.example.stackexchange.di.repo
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, viewModels, repo))
        }
    }
}
