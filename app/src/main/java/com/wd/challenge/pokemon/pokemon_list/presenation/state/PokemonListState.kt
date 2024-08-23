package com.wd.challenge.pokemon.pokemon_list.presenation.state

import androidx.paging.PagingData
import com.wd.challenge.pokemon.core.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class PokemonListState(
    val pokemons: Flow<PagingData<Pokemon>> = emptyFlow()
)
