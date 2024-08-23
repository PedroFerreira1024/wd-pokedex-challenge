package com.wd.challenge.pokemon.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.wd.challenge.pokemon.core.util.Constants
import com.wd.challenge.pokemon.pokemon_detail.presentation.PokemonDetailScreen
import com.wd.challenge.pokemon.pokemon_detail.presentation.PokemonDetailViewModel
import com.wd.challenge.pokemon.pokemon_list.presenation.PokemonListScreen
import com.wd.challenge.pokemon.pokemon_list.presenation.PokemonListViewModel
import com.wd.challenge.pokemon.pokemon_search.presentation.PokemonSearchEvent
import com.wd.challenge.pokemon.pokemon_search.presentation.PokemonSearchScreen
import com.wd.challenge.pokemon.pokemon_search.presentation.PokemonSearchViewModel

@Composable
fun NavigationGraph(modifier: Modifier = Modifier,
                    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.PokemonList.route)
    {
        composable(BottomNavItem.PokemonList.route) {

            val viewModel: PokemonListViewModel = hiltViewModel()
            val uiState = viewModel.uiState

            PokemonListScreen(
                uiState = uiState,
                navigateToDetail = {
                    navController.navigate(DetailScreenNav.DetailScreen.passPokemonName(pokemonName = it))
                }
            )
        }
        composable(BottomNavItem.PokemonSearch.route) {

            val viewModel: PokemonSearchViewModel = hiltViewModel()
            val uiState = viewModel.uiState
            val onEvent: (PokemonSearchEvent) -> Unit = viewModel::event
            val onFetch: (String) -> Unit = viewModel::fetch

            PokemonSearchScreen(
                uiState = uiState,
                onEvent = onEvent,
                onFetch = onFetch,
                navigateToDetails = {
                    navController.navigate(DetailScreenNav.DetailScreen.passPokemonName(pokemonName = it))
                }
            )
        }

        composable(
            route = DetailScreenNav.DetailScreen.route,
            arguments = listOf(
                navArgument(Constants.POKEMON_DETAIL_ARG_KEY) {
                    type= NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            val viewModel: PokemonDetailViewModel = hiltViewModel()
            val uiState = viewModel.uiState
            val getPokemonDetail = viewModel::getPokemonDetail

            PokemonDetailScreen(
                name = it.arguments?.getString(Constants.POKEMON_DETAIL_ARG_KEY),
                uiState = uiState,
                backPressNavigation = {
                    navController.popBackStack()
                },
                getPokemonDetail = getPokemonDetail
            )
        }
    }
}