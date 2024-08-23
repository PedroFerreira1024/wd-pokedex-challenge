package com.wd.challenge.pokemon.pokemon_detail.domain.source

import com.wd.challenge.pokemon.core.domain.model.PokemonDetails

interface PokemonDetailDataSource {
    suspend fun getPokemonDetails(pokemonName: String): PokemonDetails
}