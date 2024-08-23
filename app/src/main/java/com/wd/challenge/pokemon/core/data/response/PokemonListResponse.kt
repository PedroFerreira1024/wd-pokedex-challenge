package com.wd.challenge.pokemon.core.data.response

import com.google.gson.annotations.SerializedName
import com.wd.challenge.pokemon.core.data.model.PokemonResult

data class PokemonListResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<PokemonResult>
)