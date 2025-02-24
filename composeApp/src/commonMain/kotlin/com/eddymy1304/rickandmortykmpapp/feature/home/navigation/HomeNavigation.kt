package com.eddymy1304.rickandmortykmpapp.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.eddymy1304.rickandmortykmpapp.feature.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object Home

fun NavController.navigateToHome() = navigate(route = Home)

fun NavGraphBuilder.home() {
    composable<Home> {
        HomeScreen()
    }
}