package com.wd.challenge.pokemon.core.domain.model

import com.wd.challenge.pokemon.core.data.model.Stat
import com.wd.challenge.pokemon.core.data.model.Type

data class PokemonDetails (
    val name: String,
    val order: Int,
    val height: Int,
    val weight: Int,
    val stats: List<Stat>,
    val types: List<Type>,
    val artwork: String
)

