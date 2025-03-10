package com.eddymy1304.rickandmortykmpapp.feature.home.episodes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun EpisodesScreen(
    modifier: Modifier = Modifier
) {
    val viewModel = koinViewModel<EpisodesViewModel>()

    val state by viewModel.uiState.collectAsStateWithLifecycle()



}