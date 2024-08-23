package com.wd.challenge.pokemon.pokemon_detail.data.source

import com.wd.challenge.pokemon.pokemon_detail.domain.source.PokemonDetailDataSource
import com.wd.challenge.pokemon.core.data.PokemonService
import com.wd.challenge.pokemon.core.domain.model.PokemonDetails
import com.wd.challenge.pokemon.pokemon_detail.data.mapper.toPokemonDetails
import javax.inject.Inject

class PokemonDetailDataSourceImp @Inject constructor(
    private val service: PokemonService
) : PokemonDetailDataSource {

    override suspend fun getPokemonDetails(pokemonName: String): PokemonDetails {
        val response = service.getPokemon(pokemonName)
        return response.toPokemonDetails()
    }
}