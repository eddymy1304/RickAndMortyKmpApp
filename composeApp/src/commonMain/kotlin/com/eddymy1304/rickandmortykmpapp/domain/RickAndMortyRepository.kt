package com.eddymy1304.rickandmortykmpapp.domain

import androidx.paging.PagingData
import com.eddymy1304.rickandmortykmpapp.data.database.entity.CharacterEntity
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterModel
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterOfTheDayModel
import com.eddymy1304.rickandmortykmpapp.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {

    suspend fun getSingleCharacter(id: Int): Result<CharacterModel>

    fun getAllCharacters(): Flow<PagingData<CharacterModel>>

    suspend fun getCharacterOfTheDayDb(): CharacterOfTheDayModel?

    suspend fun saveCharacterOfTheDayDb(entity: CharacterEntity)

    fun getAllEpisodes(): Flow<PagingData<EpisodeModel>>
}