package com.wd.challenge.pokemon.pokemon_detail.presentation.state

import com.wd.challenge.pokemon.core.domain.model.PokemonDetails

data class PokemonDetailState (
    val pokemonDetails: PokemonDetails? = null,
    val error: String= "",
    val isLoading: Boolean = false,
    val results: PokemonDetails? = null
)