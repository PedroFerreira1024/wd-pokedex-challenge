package com.wd.challenge.pokemon.pokemon_list.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.wd.challenge.pokemon.core.domain.model.Pokemon
import com.wd.challenge.pokemon.pokemon_list.domain.repository.PokemonListRepository
import com.wd.challenge.pokemon.pokemon_list.domain.source.PokemonListDataSource
import kotlinx.coroutines.flow.Flow

class PokemonListRepositoryImp (
    private val dataSource: PokemonListDataSource
): PokemonListRepository {
    override fun getPokemonList(pagingConfig: PagingConfig): Flow<PagingData<Pokemon>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                dataSource.getPokemonListPaginSource()
            }
        ).flow
    }
}