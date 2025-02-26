package com.eddymy1304.rickandmortykmpapp.domain.mapper

import com.eddymy1304.rickandmortykmpapp.data.remote.response.CharacterResponse
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterModel

object CharacterMapper : ResponseToDomainMapper<CharacterResponse, CharacterModel> {
    override fun toDomain(response: CharacterResponse): CharacterModel {
        return CharacterModel(
            id = response.id ?: -1,
            name = response.name.orEmpty(),
            isAlive = response.status?.lowercase().orEmpty() == "alive",
            image = response.image.orEmpty()
        )
    }

}

fun CharacterResponse.toDomain() = CharacterMapper.toDomain(this)