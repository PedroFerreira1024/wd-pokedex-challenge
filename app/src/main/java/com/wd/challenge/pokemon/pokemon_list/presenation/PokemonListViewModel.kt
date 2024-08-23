package com.wd.challenge.pokemon.pokemon_list.presenation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.wd.challenge.pokemon.pokemon_list.domain.usecase.GetPokemonListUseCase
import com.wd.challenge.pokemon.pokemon_list.presenation.state.PokemonListState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {

    var uiState by mutableStateOf(PokemonListState())
        private set

    init {
        val pokemons = getPokemonListUseCase.invoke()
            .cachedIn(viewModelScope)
        uiState = uiState.copy(pokemons = pokemons)
    }
}