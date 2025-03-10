package com.eddymy1304.rickandmortykmpapp.di

import com.eddymy1304.rickandmortykmpapp.data.database.RickAndMortyDatabase
import com.eddymy1304.rickandmortykmpapp.data.database.getDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module {
    return module {
        single<RickAndMortyDatabase> { getDatabase() }
    }
}