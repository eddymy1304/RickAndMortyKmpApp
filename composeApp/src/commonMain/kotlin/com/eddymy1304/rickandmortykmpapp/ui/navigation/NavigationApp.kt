package com.eddymy1304.rickandmortykmpapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.eddymy1304.rickandmortykmpapp.feature.home.navigation.Home
import com.eddymy1304.rickandmortykmpapp.feature.home.navigation.home

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
        home()
    }
}