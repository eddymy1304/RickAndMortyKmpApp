package com.eddymy1304.rickandmortykmpapp.domain.usecase

import com.eddymy1304.rickandmortykmpapp.domain.RickAndMortyRepository
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterModel
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class GetRandomCharacter(
    private val repository: RickAndMortyRepository
) {

    suspend operator fun invoke(): Result<CharacterModel> {
        val random = (1..826).random()
        return repository.getSingleCharacter(random)
    }

    private fun getCurrentDayOfTheYear(): Int {
        val instant = Clock.System.now()
        val localTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        val dayOfYear = localTime.dayOfYear
        return dayOfYear
    }

}