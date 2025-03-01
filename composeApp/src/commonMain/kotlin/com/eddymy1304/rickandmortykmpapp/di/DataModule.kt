package com.eddymy1304.rickandmortykmpapp.di

import com.eddymy1304.rickandmortykmpapp.data.RickAndMortyRepositoryImpl
import com.eddymy1304.rickandmortykmpapp.data.remote.ApiService
import com.eddymy1304.rickandmortykmpapp.data.remote.paging.CharactersPagingSource
import com.eddymy1304.rickandmortykmpapp.domain.RickAndMortyRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {

    single {
        HttpClient {

            install(ContentNegotiation) {
                json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }

            install(DefaultRequest) {
                url {

                    protocol = URLProtocol.HTTPS

                    /*
                    * @Information
                    * Para iOS sin slash al final
                    * */
                    host = "rickandmortyapi.com"

                    //parameters.append("","")
                }
            }

        }
    }

    factoryOf(::ApiService)

    //factory<RickAndMortyRepository> { RickAndMortyRepositoryImpl(get()) }

    factoryOf(::RickAndMortyRepositoryImpl) bind RickAndMortyRepository::class

    factoryOf(::CharactersPagingSource)
}