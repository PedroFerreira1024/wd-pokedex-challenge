package com.wd.challenge.pokemon.pokemon_search.domain.repository

import androidx.paging.PagingSource
import com.wd.challenge.pokemon.core.domain.model.Pokemon

interface PokemonSearchRepository {
    fun getSearchedPokemon(query : String): PagingSource<Int, Pokemon>
}