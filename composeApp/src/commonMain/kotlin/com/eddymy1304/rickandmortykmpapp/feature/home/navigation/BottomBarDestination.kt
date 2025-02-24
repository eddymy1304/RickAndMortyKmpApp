package com.eddymy1304.rickandmortykmpapp.feature.home.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.eddymy1304.rickandmortykmpapp.feature.home.characters.navigation.Characters
import com.eddymy1304.rickandmortykmpapp.feature.home.episodes.navigation.Episodes
import org.jetbrains.compose.resources.StringResource
import kotlin.reflect.KClass

import rickandmortykmpapp.composeapp.generated.resources.Res
import rickandmortykmpapp.composeapp.generated.resources.title_characters
import rickandmortykmpapp.composeapp.generated.resources.title_episodes

enum class BottomBarDestination(
    val route: KClass<*>,
    val icon: ImageVector,
    val title: StringResource
) {
    CHARACTERS(
        route = Characters::class,
        icon = Icons.Outlined.Person,
        title = Res.string.title_characters
    ),

    EPISODES(
        route = Episodes::class,
        icon = Icons.Outlined.Movie,
        title = Res.string.title_episodes
    )

}