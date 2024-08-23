package com.wd.challenge.pokemon.pokemon_detail.data.repository

import com.wd.challenge.pokemon.pokemon_detail.domain.repository.PokemonDetailRepository
import com.wd.challenge.pokemon.pokemon_detail.domain.source.PokemonDetailDataSource
import com.wd.challenge.pokemon.core.domain.model.PokemonDetails
import javax.inject.Inject

class PokemonDetailRepositoryImp @Inject constructor(
    private val dataSource: PokemonDetailDataSource
) : PokemonDetailRepository {

    override suspend fun getPokemonDetails(pokemonName: String): PokemonDetails {
        return dataSource.getPokemonDetails(pokemonName = pokemonName)
    }
}