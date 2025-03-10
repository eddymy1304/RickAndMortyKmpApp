package com.eddymy1304.rickandmortykmpapp.domain.mapper

import com.eddymy1304.rickandmortykmpapp.data.database.entity.CharacterEntity
import com.eddymy1304.rickandmortykmpapp.data.remote.response.CharacterResponse
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterModel
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterOfTheDayModel

object CharacterMapper :
    ResponseToDomainMapper<CharacterResponse, CharacterModel>,
    EntityToDomainMapper<CharacterEntity, CharacterOfTheDayModel> {
    override fun toDomainFromResponse(response: CharacterResponse): CharacterModel {
        return CharacterModel(
            id = response.id ?: -1,
            name = response.name.orEmpty(),
            isAlive = response.status?.lowercase().orEmpty() == "alive",
            image = response.image.orEmpty()
        )
    }

    override fun toDomainFromEntity(entity: CharacterEntity): CharacterOfTheDayModel {
        return CharacterOfTheDayModel(
            characterModel = CharacterModel(
                id = entity.id,
                name = entity.name,
                isAlive = entity.isAlive,
                image = entity.image
            ),
            selectedDay = entity.selectedDay
        )
    }

    override fun toEntityFromDomain(domain: CharacterOfTheDayModel): CharacterEntity {
        return CharacterEntity(
            id = domain.characterModel.id,
            name = domain.characterModel.name,
            isAlive = domain.characterModel.isAlive,
            image = domain.characterModel.image,
            selectedDay = domain.selectedDay
        )
    }

}

fun CharacterResponse.toDomainFromResponse() = CharacterMapper.toDomainFromResponse(this)

fun List<CharacterResponse>.toDomainFromResponse() = map { it.toDomainFromResponse() }

fun CharacterOfTheDayModel.toEntityFromDomain() = CharacterMapper.toEntityFromDomain(this)

fun CharacterEntity.toDomainFromEntity() = CharacterMapper.toDomainFromEntity(this)