package com.wd.challenge.pokemon.pokemon_search.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.wd.challenge.pokemon.R
import com.wd.challenge.pokemon.core.presentation.components.PokemonAppBar
import com.wd.challenge.pokemon.pokemon_search.presentation.components.PokemonSearchContent
import com.wd.challenge.pokemon.pokemon_search.presentation.state.PokemonSearchState

@Composable
fun PokemonSearchScreen (
    uiState: PokemonSearchState,
    onEvent: (PokemonSearchEvent) -> Unit,
    onFetch: (String) -> Unit,
    navigateToDetails: (String) -> Unit
){

    val pagingPokemon = uiState.pokemons.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            PokemonAppBar(
                title = R.string.search
            )
        },
        content = { paddingValues ->
            PokemonSearchContent(
                modifier = Modifier.padding(paddingValues),
                paddingValues = paddingValues,
                pagingPokemons = pagingPokemon,
                query = uiState.query,
                onSearch = {
                    onFetch(it)
                },
                onEvent = {
                    onEvent(it)
                },
                onDetail = { pokemonName ->
                    navigateToDetails(pokemonName)
                }
            )
        }
    )

}