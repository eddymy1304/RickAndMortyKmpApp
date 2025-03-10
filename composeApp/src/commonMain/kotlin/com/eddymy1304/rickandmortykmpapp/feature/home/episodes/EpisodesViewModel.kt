package com.eddymy1304.rickandmortykmpapp.feature.home.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.eddymy1304.rickandmortykmpapp.domain.RickAndMortyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class EpisodesViewModel(
    private val repository: RickAndMortyRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(EpisodesState())
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.update { state->
            state.copy(
                episodes = repository.getAllEpisodes().cachedIn(viewModelScope)
            )
        }
    }
}