package com.eddymy1304.rickandmortykmpapp.data.remote.response

data class GetAllCharactersResponse(
    val info: InfoResponse,
    val results: List<CharacterResponse>
)
