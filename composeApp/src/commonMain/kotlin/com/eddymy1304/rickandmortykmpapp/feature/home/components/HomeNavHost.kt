package com.eddymy1304.rickandmortykmpapp.feature.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.eddymy1304.rickandmortykmpapp.feature.home.characters.navigation.Characters
import com.eddymy1304.rickandmortykmpapp.feature.home.characters.navigation.characters
import com.eddymy1304.rickandmortykmpapp.feature.home.episodes.navigation.episodes

@Composable
fun HomeNavHost(
    modifier: Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Characters,
        modifier = modifier
    ) {
        characters()

        episodes()
    }

}