package com.eddymy1304.rickandmortykmpapp.data.remote

import com.eddymy1304.rickandmortykmpapp.data.remote.response.CharacterResponse
import com.eddymy1304.rickandmortykmpapp.data.remote.response.GetAllCharactersResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService(
    private val client: HttpClient
) {

    suspend fun getSingleCharacter(id: Int): CharacterResponse {
        return client.get("api/character/$id")
            .body()
    }

    suspend fun getAllCharacters(page: Int): GetAllCharactersResponse {
        return client.get("https://rickandmortyapi.com/api/character") {
            parameter("page", page)
        }.body()
    }

}