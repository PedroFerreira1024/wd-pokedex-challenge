package com.wd.challenge.pokemon.pokemon_search.data.mapper

import com.wd.challenge.pokemon.core.data.response.PokemonResponse
import com.wd.challenge.pokemon.core.domain.model.Pokemon

fun PokemonResponse.toPokemonList() = listOf (
    Pokemon(
        id = this.id,
        name = this.name,
    )
)

