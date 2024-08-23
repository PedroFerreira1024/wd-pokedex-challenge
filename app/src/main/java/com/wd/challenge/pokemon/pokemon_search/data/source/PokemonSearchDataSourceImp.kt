package com.wd.challenge.pokemon.pokemon_search.data.source

import com.wd.challenge.pokemon.core.data.PokemonService
import com.wd.challenge.pokemon.core.data.response.PokemonResponse
import com.wd.challenge.pokemon.core.paging.PokemonSearchPagingSource
import com.wd.challenge.pokemon.pokemon_search.domain.source.PokemonSearchDataSource
import javax.inject.Inject

class PokemonSearchDataSourceImp @Inject constructor(
    private val service: PokemonService
) : PokemonSearchDataSource {
    override fun getPokemonSearchPagingSource(query: String): PokemonSearchPagingSource {
        return PokemonSearchPagingSource(query = query, dataSource = this)
    }

    override suspend fun getPokemonSearch(page: Int, query: String): PokemonResponse {
        return service.getPokemon(pokemonName = query)
    }

}