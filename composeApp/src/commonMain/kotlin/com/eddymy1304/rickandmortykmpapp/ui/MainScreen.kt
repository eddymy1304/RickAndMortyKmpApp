package com.eddymy1304.rickandmortykmpapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.eddymy1304.rickandmortykmpapp.ui.navigation.NavHostApp
import com.eddymy1304.rickandmortykmpapp.ui.theme.RickAndMortyKmpAppTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val mainNavController = rememberNavController()

    RickAndMortyKmpAppTheme {
        Scaffold { paddingValues ->
            NavHostApp(
                modifier = modifier.padding(paddingValues),
                navController = mainNavController
            )
        }
    }

}