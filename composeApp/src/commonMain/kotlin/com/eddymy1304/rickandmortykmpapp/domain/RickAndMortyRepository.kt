package com.eddymy1304.rickandmortykmpapp.domain

import androidx.paging.PagingData
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {

    suspend fun getSingleCharacter(id: Int): Result<CharacterModel>

    fun getAllCharacters(): Flow<PagingData<CharacterModel>>

    suspend fun getCharacterOfTheDayDb()
}