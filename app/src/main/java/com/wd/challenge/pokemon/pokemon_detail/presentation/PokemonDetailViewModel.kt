package com.wd.challenge.pokemon.pokemon_detail.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wd.challenge.pokemon.core.util.ResultData
import com.wd.challenge.pokemon.core.util.UtilFunctions
import com.wd.challenge.pokemon.pokemon_detail.domain.usecase.PokemonDetailUseCase
import com.wd.challenge.pokemon.pokemon_detail.presentation.state.PokemonDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: PokemonDetailUseCase
): ViewModel() {

    var uiState by mutableStateOf(PokemonDetailState())
        private set

    fun getPokemonDetail(getPokemonDetail: PokemonDetailEvent.GetPokemonDetail) {
        event(getPokemonDetail)
    }

    private fun event(event: PokemonDetailEvent) {
        when (event) {
            is PokemonDetailEvent.GetPokemonDetail -> {
                viewModelScope.launch {
                    val resultData = getPokemonDetailUseCase.invoke(
                        params = PokemonDetailUseCase.Params(
                            pokemonName = event.pokemonName
                        )
                    )
                        when (resultData) {
                            is ResultData.Success -> {
                                uiState = uiState.copy(
                                    isLoading = false,
                                    pokemonDetails = resultData.data,
                                )
                            }

                            is ResultData.Failure -> {
                                UtilFunctions.logError(
                                    "Pokemon Detail ERROR",
                                    resultData.e.message.toString()
                                )
                            }

                            is ResultData.Loading -> {
                                uiState = uiState.copy(
                                    isLoading = true
                                )
                            }
                        }
                    }
            }
        }
    }
}