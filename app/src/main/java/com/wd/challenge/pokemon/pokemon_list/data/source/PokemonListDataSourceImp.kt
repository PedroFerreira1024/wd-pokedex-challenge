package com.wd.challenge.pokemon.pokemon_list.data.source

import com.wd.challenge.pokemon.core.data.PokemonService
import com.wd.challenge.pokemon.core.data.response.PokemonListResponse
import com.wd.challenge.pokemon.core.paging.PokemonPagingSource
import com.wd.challenge.pokemon.pokemon_list.domain.source.PokemonListDataSource

class PokemonListDataSourceImp (
    private val service: PokemonService
): PokemonListDataSource {
    override fun getPokemonListPaginSource(): PokemonPagingSource {
        return PokemonPagingSource(this)
    }

    override suspend fun getPokemonList(offset: Int): PokemonListResponse {
        return service.getPokemonList(offset = offset)
    }
}