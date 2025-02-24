package com.eddymy1304.rickandmortykmpapp.feature.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.eddymy1304.rickandmortykmpapp.feature.home.components.HomeNavHost
import com.eddymy1304.rickandmortykmpapp.feature.home.navigation.BottomBarDestination
import com.eddymy1304.rickandmortykmpapp.ui.components.HomeBottomBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            HomeBottomBar(
                navController = navController,
                items = BottomBarDestination.entries.toMutableList()
            )
        }
    ) { paddingValues ->
        HomeNavHost(
            modifier = modifier.padding(paddingValues),
            navController = navController
        )
    }

}