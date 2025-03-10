package com.eddymy1304.rickandmortykmpapp.domain.usecase

import com.eddymy1304.rickandmortykmpapp.domain.RickAndMortyRepository
import com.eddymy1304.rickandmortykmpapp.domain.mapper.toEntityFromDomain
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterModel
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterOfTheDayModel
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class GetRandomCharacter(
    private val repository: RickAndMortyRepository
) {

    suspend operator fun invoke(): Result<CharacterModel> {
        val selectedDay = getCurrentDayOfTheYear()
        val characterOfTheDay = repository.getCharacterOfTheDayDb()
        return if (characterOfTheDay != null && characterOfTheDay.selectedDay == selectedDay) {
            Result.success(characterOfTheDay.characterModel)
        } else {
            getRandomCharacterRemote()
                .onSuccess { character ->
                    val characterOfTheDayModel = CharacterOfTheDayModel(
                        characterModel = character,
                        selectedDay = selectedDay
                    )
                    repository.saveCharacterOfTheDayDb(characterOfTheDayModel.toEntityFromDomain())
                }
        }
    }

    private suspend fun getRandomCharacterRemote(): Result<CharacterModel> {
        val random = (1..826).random()
        return repository.getSingleCharacter(random)
    }

    private fun getCurrentDayOfTheYear(): String {
        val instant = Clock.System.now()
        val localTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        val dayOfYear = localTime.dayOfYear
        val year = localTime.year
        return "$year-$dayOfYear"
    }

}