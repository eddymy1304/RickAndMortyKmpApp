package com.eddymy1304.rickandmortykmpapp.feature.home.characters.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.eddymy1304.rickandmortykmpapp.feature.home.characters.CharactersScreen
import kotlinx.serialization.Serializable

@Serializable
data object Characters

fun NavController.navigateToCharacters(navOptions: NavOptionsBuilder.() -> Unit = {}) =
    navigate(route = Characters, builder = navOptions)


fun NavGraphBuilder.characters() {
    composable<Characters> {
        CharactersScreen()
    }
}
