package com.eddymy1304.rickandmortykmpapp.feature.home.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eddymy1304.rickandmortykmpapp.domain.usecase.GetRandomCharacter
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.update

class CharactersViewModel(
    private val getRandomCharacter: GetRandomCharacter
) : ViewModel() {

    private val _uiState = MutableStateFlow(CharactersState())
    val uiState: StateFlow<CharactersState> = _uiState.asStateFlow()

    init {
        getRandomCharacterInit()
    }

    private fun getRandomCharacterInit() {
        viewModelScope.launch {
            getRandomCharacter()
                .onSuccess { success ->
                    _uiState.update { state ->
                        state.copy(
                            characterOfTheDay = success
                        )
                    }
                }
                .onFailure {

                }

        }
    }

}