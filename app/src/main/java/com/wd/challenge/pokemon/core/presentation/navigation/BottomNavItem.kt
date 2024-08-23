package com.wd.challenge.pokemon.core.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalLibrary
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val title: String, val icon: ImageVector, val route: String) {
    object PokemonList: BottomNavItem(
        title = "Pokemon",
        icon = Icons.Default.LocalLibrary ,
        route = "pokemon_screen"
    )

    object PokemonSearch: BottomNavItem(
        title = "Search",
        icon = Icons.Default.Search,
        route = "pokemon_search_screen"
    )
}