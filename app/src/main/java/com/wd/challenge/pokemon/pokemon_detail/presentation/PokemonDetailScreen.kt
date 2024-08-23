package com.wd.challenge.pokemon.pokemon_detail.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.wd.challenge.pokemon.R
import com.wd.challenge.pokemon.core.presentation.components.PokemonAppBar
import com.wd.challenge.pokemon.pokemon_detail.presentation.component.PokemonDetailContent
import com.wd.challenge.pokemon.pokemon_detail.presentation.state.PokemonDetailState

@Composable
fun PokemonDetailScreen (
    name: String?,
    uiState: PokemonDetailState,
    getPokemonDetail: (PokemonDetailEvent.GetPokemonDetail) -> Unit,
    backPressNavigation: () -> Unit,
){

    LaunchedEffect(true) {
        if (name != null) {
            getPokemonDetail(PokemonDetailEvent.GetPokemonDetail(pokemonName = name))
        }
    }

    Scaffold(
        topBar = {
            PokemonAppBar(
                title = R.string.details,
                backEnabled = true,
                backPress = backPressNavigation
            )
        },
        content = { paddingValues ->
            PokemonDetailContent(
                modifier = Modifier.padding(paddingValues),
                pokemonDetails = uiState.pokemonDetails,
                isLoading = uiState.isLoading,
                isError = uiState.error
                )
        }
    )
}