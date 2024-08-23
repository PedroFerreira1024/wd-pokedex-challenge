package com.wd.challenge.pokemon.core.domain.model

import com.wd.challenge.pokemon.core.data.model.PokemonResult
import com.wd.challenge.pokemon.core.data.response.PokemonListResponse

class PokemonPagingFactory {

    fun create() = PokemonListResponse (
        count = 2,
        next = "",
        previous = "",
        results = listOf (
            PokemonResult(
                name = "bulbasaur",
                url = "https://pokeapi.co/api/v2/pokemon/1"
            ),
            PokemonResult(
                name = "charmander",
                url = "https://pokeapi.co/api/v2/pokemon/4"
            )
        )
    )
}