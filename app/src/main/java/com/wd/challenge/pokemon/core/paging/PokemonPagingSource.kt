package com.wd.challenge.pokemon.core.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.wd.challenge.pokemon.core.domain.model.Pokemon
import com.wd.challenge.pokemon.pokemon_list.data.mapper.toPokemon
import com.wd.challenge.pokemon.pokemon_list.domain.source.PokemonListDataSource

class PokemonPagingSource (
    private val dataSource: PokemonListDataSource
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
            val response = dataSource.getPokemonList(offset = offsetNumber)
            val pokemons = response.results

            LoadResult.Page(
                data = pokemons.toPokemon(),
                prevKey = if (offsetNumber == 0) null else offsetNumber - 20,
                nextKey = if (pokemons.isEmpty()) null else offsetNumber + 20
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