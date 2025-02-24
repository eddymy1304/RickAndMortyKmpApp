package com.eddymy1304.rickandmortykmpapp

import android.app.Application
import com.eddymy1304.rickandmortykmpapp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class RickAndMortyKmpApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@RickAndMortyKmpApp)
        }

    }
}