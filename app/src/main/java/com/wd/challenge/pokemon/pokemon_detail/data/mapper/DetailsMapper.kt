package com.wd.challenge.pokemon.pokemon_detail.data.mapper

import com.wd.challenge.pokemon.core.data.response.PokemonResponse
import com.wd.challenge.pokemon.core.domain.model.PokemonDetails

fun PokemonResponse.toPokemonDetails() = this.let {
    PokemonDetails (
        name = it.name,
        order = it.order,
        height = it.height,
        weight = it.weight,
        stats = it.stats,
        types = it.types,
        artwork = it.sprites.other.officialArtwork.frontDefault
    )
}