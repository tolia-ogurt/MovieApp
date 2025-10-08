package com.example.movieapp

import android.app.Application
import com.example.movieapp.di.mainModule
import com.example.movieapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(mainModule, networkModule)
        }
    }
}