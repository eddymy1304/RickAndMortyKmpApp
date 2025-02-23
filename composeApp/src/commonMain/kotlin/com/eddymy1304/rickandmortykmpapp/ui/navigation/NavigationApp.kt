package com.eddymy1304.rickandmortykmpapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eddymy1304.rickandmortykmpapp.feature.home.HomeScreen
import com.eddymy1304.rickandmortykmpapp.feature.home.navigation.Home

@Composable
fun NavHostApp(
    modifier: Modifier,
    navController: NavHostController
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Home
    ) {

        composable<Home> {
            HomeScreen()
        }

    }

}