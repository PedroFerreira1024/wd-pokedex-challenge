package com.wd.challenge.pokemon.pokemon_search.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.wd.challenge.pokemon.core.domain.model.Pokemon
import com.wd.challenge.pokemon.pokemon_search.domain.repository.PokemonSearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

interface GetPokemonSearchUseCase {
    operator fun invoke(params: Params): Flow<PagingData<Pokemon>>
    data class Params(val query: String, val pagingConfig: PagingConfig)
}
class GetPokemonSearchUseCaseImp @Inject constructor(
    private val repository: PokemonSearchRepository
): GetPokemonSearchUseCase {

    override fun invoke(params: GetPokemonSearchUseCase.Params): Flow<PagingData<Pokemon>> {
        return try {
            val pagingSource = repository.getSearchedPokemon(query = params.query)
            return Pager(
                config = params.pagingConfig,
                pagingSourceFactory = {
                    pagingSource
                }
            ).flow
        } catch (e: Exception) {
            emptyFlow()
        }
    }
}