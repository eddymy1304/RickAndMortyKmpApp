package com.eddymy1304.rickandmortykmpapp.di

import com.eddymy1304.rickandmortykmpapp.domain.usecase.GetRandomCharacter
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {

    factoryOf(::GetRandomCharacter)

}