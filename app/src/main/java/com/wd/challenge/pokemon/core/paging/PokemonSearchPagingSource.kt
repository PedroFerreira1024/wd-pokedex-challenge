package com.wd.challenge.pokemon.core.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.wd.challenge.pokemon.core.domain.model.Pokemon
import com.wd.challenge.pokemon.pokemon_search.data.mapper.toPokemonList
import com.wd.challenge.pokemon.pokemon_search.domain.source.PokemonSearchDataSource

class PokemonSearchPagingSource(
    private val query: String,
    private val dataSource: PokemonSearchDataSource
): PagingSource<Int, Pokemon>() {
    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition?.let {anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(LIMIT) ?: anchorPage?.nextKey?.minus(LIMIT)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        return try {
            val offsetNumber = params.key ?: 0
            val response = dataSource.getPokemonSearch(query = query)
            val pokemonSearch = response // No search ability only assertive search

            LoadResult.Page(
                data = pokemonSearch.toPokemonList(),
                prevKey = if (offsetNumber == 0) null else offsetNumber - 20,
                nextKey = if (pokemonSearch.id != 0) null else offsetNumber + 20
            )
        }
        catch ( exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val LIMIT = 40
    }
}