package com.eddymy1304.rickandmortykmpapp.data.remote

import com.eddymy1304.rickandmortykmpapp.data.remote.response.CharacterResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService(
    private val client: HttpClient
) {

    suspend fun getSingleCharacter(id: Int): CharacterResponse {
        return client.get("api/character/$id")
            .body()
    }

}