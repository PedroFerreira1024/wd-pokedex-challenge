package com.wd.challenge.pokemon.pokemon_list.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.wd.challenge.pokemon.core.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonListRepository {

    fun getPokemonList(pagingConfig: PagingConfig): Flow<PagingData<Pokemon>>
}