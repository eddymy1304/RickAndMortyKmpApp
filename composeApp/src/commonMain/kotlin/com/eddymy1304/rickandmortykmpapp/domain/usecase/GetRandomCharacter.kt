package com.eddymy1304.rickandmortykmpapp.domain.usecase

import com.eddymy1304.rickandmortykmpapp.domain.RickAndMortyRepository
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterModel

class GetRandomCharacter(
    private val repository: RickAndMortyRepository
) {

    suspend operator fun invoke(): Result<CharacterModel> {
        val random = (1..826).random()
        return repository.getSingleCharacter(random)
    }

}