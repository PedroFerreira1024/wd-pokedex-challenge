package com.wd.challenge.pokemon.pokemon_search.data.repository

import androidx.paging.PagingSource
import com.wd.challenge.pokemon.core.domain.model.Pokemon
import com.wd.challenge.pokemon.core.paging.PokemonSearchPagingSource
import com.wd.challenge.pokemon.pokemon_search.domain.repository.PokemonSearchRepository
import com.wd.challenge.pokemon.pokemon_search.domain.source.PokemonSearchDataSource
import javax.inject.Inject

class PokemonSearchRepositoryImp @Inject constructor(
    private val dataSource: PokemonSearchDataSource
) : PokemonSearchRepository {

    override fun getSearchedPokemon(
        query: String
    ): PagingSource<Int,Pokemon> {
        return PokemonSearchPagingSource(query = query ,dataSource = dataSource)
    }

}