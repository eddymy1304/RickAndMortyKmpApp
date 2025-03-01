package com.eddymy1304.rickandmortykmpapp.di

import com.eddymy1304.rickandmortykmpapp.feature.home.characters.CharactersViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {

    viewModelOf(::CharactersViewModel)

}