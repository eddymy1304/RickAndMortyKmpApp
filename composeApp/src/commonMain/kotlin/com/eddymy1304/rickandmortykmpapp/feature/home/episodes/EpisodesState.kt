package com.eddymy1304.rickandmortykmpapp.feature.home.episodes

import androidx.paging.PagingData
import com.eddymy1304.rickandmortykmpapp.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class EpisodesState(
    val isLoading: Boolean = false,
    val episodes: Flow<PagingData<EpisodeModel>> = emptyFlow(),
    val error: String? = null
)
