package com.wd.challenge.pokemon.pokemon_search.domain.source

import com.wd.challenge.pokemon.core.data.response.PokemonResponse
import com.wd.challenge.pokemon.core.paging.PokemonSearchPagingSource


interface PokemonSearchDataSource {
    fun getPokemonSearchPagingSource(query: String): PokemonSearchPagingSource
    suspend fun getPokemonSearch(page: Int = 0, query: String): PokemonResponse
}