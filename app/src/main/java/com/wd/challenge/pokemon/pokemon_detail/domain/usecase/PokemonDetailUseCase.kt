package com.wd.challenge.pokemon.pokemon_detail.domain.usecase

import com.wd.challenge.pokemon.pokemon_detail.domain.repository.PokemonDetailRepository
import com.wd.challenge.pokemon.core.domain.model.PokemonDetails
import com.wd.challenge.pokemon.core.util.ResultData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface PokemonDetailUseCase {
    suspend operator fun invoke(params: Params): Flow<ResultData<PokemonDetails>>
    data class Params(
        val pokemonName: String
    )
}

class PokemonDetailUseCaseImp @Inject constructor(
    private val repository: PokemonDetailRepository
) : PokemonDetailUseCase {
    override suspend fun invoke(params: PokemonDetailUseCase.Params): Flow<ResultData<PokemonDetails>> {
        return withContext(Dispatchers.IO) {
                    flowOf(ResultData.Loading)
                    try {
                        val pokemonDetails = repository.getPokemonDetails(params.pokemonName)
                        /** Delayed just to force some Loading State */
                        delay(1000)
                        flowOf(ResultData.Success(pokemonDetails))
                    } catch (exception: Exception) {
                        flowOf(ResultData.Failure(exception))
                    }
                }
    }
}