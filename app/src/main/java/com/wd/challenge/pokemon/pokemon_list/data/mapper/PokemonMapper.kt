package com.wd.challenge.pokemon.pokemon_list.data.mapper

import com.wd.challenge.pokemon.core.data.model.PokemonResult
import com.wd.challenge.pokemon.core.domain.model.Pokemon
import com.wd.challenge.pokemon.core.util.toId

fun List<PokemonResult>.toPokemon() = map { pokemonResult ->
    Pokemon(
        id = pokemonResult.url.toId().toInt(),
        name = pokemonResult.name
    )
}