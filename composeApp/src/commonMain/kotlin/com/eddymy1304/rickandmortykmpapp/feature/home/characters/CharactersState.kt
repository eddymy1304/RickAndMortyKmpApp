package com.eddymy1304.rickandmortykmpapp.feature.home.characters

import androidx.paging.PagingData
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class CharactersState(
    val isLoading: Boolean = false,
    val characterOfTheDay: CharacterModel? = null,
    val characters: Flow<PagingData<CharacterModel>> = emptyFlow(),
    val error: String? = null
)
