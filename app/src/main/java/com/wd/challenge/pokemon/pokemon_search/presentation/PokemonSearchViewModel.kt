package com.wd.challenge.pokemon.pokemon_search.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.wd.challenge.pokemon.pokemon_search.domain.usecase.GetPokemonSearchUseCase
import com.wd.challenge.pokemon.pokemon_search.presentation.state.PokemonSearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PokemonSearchViewModel @Inject constructor (
    private val getPokemonSearchUseCase: GetPokemonSearchUseCase
) : ViewModel() {

    var uiState by mutableStateOf(PokemonSearchState())
        private set

    fun fetch(query: String = "") {
        val movies = getPokemonSearchUseCase.invoke(
            params = GetPokemonSearchUseCase.Params(
                query = query,
                pagingConfig = pagingConfig()
            )
        ).cachedIn(viewModelScope)
        uiState = uiState.copy(pokemons = movies)
    }

    fun event(event: PokemonSearchEvent) {
        uiState = when(event) {
            is PokemonSearchEvent.EnteredQuery ->{
                uiState.copy(query = event.value)
            }
        }
    }

    private fun pagingConfig(): PagingConfig {
        return PagingConfig(
            pageSize = 20,
            initialLoadSize = 20
        )
    }
}