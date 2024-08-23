package com.wd.challenge.pokemon.core.data.model

import com.google.gson.annotations.SerializedName

data class PokemonResult(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
