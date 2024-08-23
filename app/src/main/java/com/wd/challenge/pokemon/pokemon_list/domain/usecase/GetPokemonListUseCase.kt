package com.wd.challenge.pokemon.pokemon_list.domain.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.wd.challenge.pokemon.core.domain.model.Pokemon
import com.wd.challenge.pokemon.pokemon_list.domain.repository.PokemonListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetPokemonListUseCase {
    operator fun invoke(): Flow<PagingData<Pokemon>>
}

class GetPokemonListUseCaseImp @Inject constructor(
    private val repository: PokemonListRepository
): GetPokemonListUseCase{

    override fun invoke(): Flow<PagingData<Pokemon>> {
        return repository.getPokemonList(
            pagingConfig = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20
            )
        )
    }

}