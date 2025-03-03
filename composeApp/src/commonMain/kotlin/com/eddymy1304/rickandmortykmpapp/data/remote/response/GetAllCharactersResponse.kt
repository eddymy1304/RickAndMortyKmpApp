package com.eddymy1304.rickandmortykmpapp.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class GetAllCharactersResponse(
    val info: InfoResponse,
    val results: List<CharacterResponse>
)
