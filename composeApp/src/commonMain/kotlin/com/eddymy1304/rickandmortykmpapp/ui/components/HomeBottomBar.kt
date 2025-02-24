package com.eddymy1304.rickandmortykmpapp.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.currentBackStackEntryAsState
import com.eddymy1304.rickandmortykmpapp.feature.home.characters.navigation.navigateToCharacters
import com.eddymy1304.rickandmortykmpapp.feature.home.episodes.navigation.navigateToEpisodes
import com.eddymy1304.rickandmortykmpapp.feature.home.navigation.BottomBarDestination
import com.eddymy1304.rickandmortykmpapp.feature.home.navigation.BottomBarDestination.*
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeBottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    items: List<BottomBarDestination>
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(modifier = modifier) {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(item.title)
                    )
                },
                label = { Text(text = stringResource(item.title)) },
                selected = currentDestination?.hierarchy?.any { it.hasRoute(item.route) } == true,
                onClick = {

                    val navOptions: NavOptionsBuilder.() -> Unit = {
                        navController.graph.findStartDestination().id.let { id ->
                            popUpTo(id) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                    when (item) {
                        EPISODES -> navController.navigateToEpisodes(navOptions)
                        CHARACTERS -> navController.navigateToCharacters(navOptions)
                    }

                }
            )
        }
    }
}