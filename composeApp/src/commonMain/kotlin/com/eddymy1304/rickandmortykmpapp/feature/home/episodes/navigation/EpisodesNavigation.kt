package com.eddymy1304.rickandmortykmpapp.feature.home.episodes.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.eddymy1304.rickandmortykmpapp.feature.home.episodes.EpisodesScreen
import kotlinx.serialization.Serializable

@Serializable
data object Episodes

fun NavController.navigateToEpisodes(navOptions: NavOptionsBuilder.() -> Unit = {}) =
    navigate(route = Episodes, builder = navOptions)


fun NavGraphBuilder.episodes() {
    composable<Episodes> {
        EpisodesScreen()
    }
}
