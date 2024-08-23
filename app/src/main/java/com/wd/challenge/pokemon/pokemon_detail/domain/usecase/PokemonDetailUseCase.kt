package com.wd.challenge.pokemon.pokemon_detail.domain.usecase

import com.wd.challenge.pokemon.pokemon_detail.domain.repository.PokemonDetailRepository
import com.wd.challenge.pokemon.core.domain.model.PokemonDetails
import com.wd.challenge.pokemon.core.util.ResultData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface PokemonDetailUseCase {
    suspend operator fun invoke(params: Params): ResultData<PokemonDetails>
    data class Params(
        val pokemonName: String
    )
}

class PokemonDetailUseCaseImp @Inject constructor(
    private val repository: PokemonDetailRepository
) : PokemonDetailUseCase {
    override suspend fun invoke(params: PokemonDetailUseCase.Params): ResultData<PokemonDetails> {
        return withContext(Dispatchers.IO) {
                ResultData.Loading
                try {
                    val pokemonDetails = repository.getPokemonDetails(params.pokemonName)

                    ResultData.Success(pokemonDetails)
                } catch (exception: Exception) {
                    ResultData.Failure(exception)
                }
            }
    }
}