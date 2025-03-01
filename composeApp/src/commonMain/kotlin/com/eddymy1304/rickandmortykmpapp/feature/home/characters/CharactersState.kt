package com.eddymy1304.rickandmortykmpapp.feature.home.characters

import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterModel

data class CharactersState(
    val isLoading: Boolean = false,
    val characterOfTheDay: CharacterModel? = null
)
