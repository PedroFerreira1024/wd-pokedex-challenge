package com.wd.challenge.pokemon.pokemon_detail.domain.repository

import com.wd.challenge.pokemon.core.domain.model.PokemonDetails

interface PokemonDetailRepository {
    suspend fun getPokemonDetails(pokemonName: String): PokemonDetails
}