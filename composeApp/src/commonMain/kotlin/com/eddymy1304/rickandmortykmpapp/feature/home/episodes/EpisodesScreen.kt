package com.eddymy1304.rickandmortykmpapp.feature.home.episodes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.cash.paging.compose.collectAsLazyPagingItems
import com.eddymy1304.rickandmortykmpapp.domain.model.EpisodeModel
import com.eddymy1304.rickandmortykmpapp.domain.model.SeasonEpisode
import com.eddymy1304.rickandmortykmpapp.ui.components.PagingType
import com.eddymy1304.rickandmortykmpapp.ui.components.PagingWrapper
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import rickandmortykmpapp.composeapp.generated.resources.Res
import rickandmortykmpapp.composeapp.generated.resources.season1
import rickandmortykmpapp.composeapp.generated.resources.season2
import rickandmortykmpapp.composeapp.generated.resources.season3
import rickandmortykmpapp.composeapp.generated.resources.season4
import rickandmortykmpapp.composeapp.generated.resources.season5
import rickandmortykmpapp.composeapp.generated.resources.season6
import rickandmortykmpapp.composeapp.generated.resources.season7
import rickandmortykmpapp.composeapp.generated.resources.season8

@Composable
fun EpisodesScreen(
    modifier: Modifier = Modifier
) {
    val viewModel = koinViewModel<EpisodesViewModel>()

    val state by viewModel.uiState.collectAsStateWithLifecycle()

    val episodes = state.episodes.collectAsLazyPagingItems()

    Box(modifier = modifier.fillMaxSize()) {
        PagingWrapper(
            pagingType = PagingType.Row(),
            items = episodes
        ) {
            ItemListEpisode(episode = it)
        }
    }

}

@Composable
fun ItemListEpisode(
    modifier: Modifier = Modifier,
    episode: EpisodeModel
) {

    Column(
        modifier = modifier
            .width(120.dp)
            .height(200.dp)
            .padding(horizontal = 8.dp)
            .clickable { }
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(getEpisodeImage(episode.season)),
            contentScale = ContentScale.Inside,
            contentDescription = null
        )
    }

}

fun getEpisodeImage(season: SeasonEpisode): DrawableResource {
    return when (season) {
        SeasonEpisode.SEASON_1 -> Res.drawable.season1
        SeasonEpisode.SEASON_2 -> Res.drawable.season2
        SeasonEpisode.SEASON_3 -> Res.drawable.season3
        SeasonEpisode.SEASON_4 -> Res.drawable.season4
        SeasonEpisode.SEASON_5 -> Res.drawable.season5
        SeasonEpisode.SEASON_6 -> Res.drawable.season6
        SeasonEpisode.SEASON_7 -> Res.drawable.season7
        SeasonEpisode.SEASON_8 -> Res.drawable.season8
        SeasonEpisode.UNKNOWN -> Res.drawable.season1
    }
}