package com.eddymy1304.rickandmortykmpapp.domain

import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterModel

interface RickAndMortyRepository {

    suspend fun getSingleCharacter(id: Int): CharacterModel

}