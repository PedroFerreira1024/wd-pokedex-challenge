package com.wd.challenge.pokemon.core.domain.model

import com.wd.challenge.pokemon.core.util.toSpriteUrl

data class Pokemon(
    val id: Int,
    val name: String,
    val sprite: String = id.toSpriteUrl()
)
