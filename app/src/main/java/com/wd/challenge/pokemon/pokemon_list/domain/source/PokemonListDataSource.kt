package com.wd.challenge.pokemon.pokemon_list.domain.source

import com.wd.challenge.pokemon.core.data.response.PokemonListResponse
import com.wd.challenge.pokemon.core.paging.PokemonPagingSource

interface PokemonListDataSource {
    fun getPokemonListPaginSource(): PokemonPagingSource

    suspend fun getPokemonList(offset: Int): PokemonListResponse
}
