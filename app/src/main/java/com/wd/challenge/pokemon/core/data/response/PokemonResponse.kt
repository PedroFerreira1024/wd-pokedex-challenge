package com.wd.challenge.pokemon.core.data.response

import com.google.gson.annotations.SerializedName
import com.wd.challenge.pokemon.core.data.model.Ability
import com.wd.challenge.pokemon.core.data.model.Cries
import com.wd.challenge.pokemon.core.data.model.Form
import com.wd.challenge.pokemon.core.data.model.Move
import com.wd.challenge.pokemon.core.data.model.Species
import com.wd.challenge.pokemon.core.data.model.Sprites
import com.wd.challenge.pokemon.core.data.model.Stat
import com.wd.challenge.pokemon.core.data.model.Type

data class PokemonResponse(
    @SerializedName("abilities") val abilities: List<Ability>,
    @SerializedName("cries") val cries: Cries,
    @SerializedName("forms") val forms: List<Form>,
    @SerializedName("height") val height: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("is_default") val isDefault: Boolean,
    @SerializedName("moves") val moves: List<Move>,
    @SerializedName("name") val name: String,
    @SerializedName("order") val order: Int,
    @SerializedName("species") val species: Species,
    @SerializedName("sprites") val sprites: Sprites,
    @SerializedName("stats") val stats: List<Stat>,
    @SerializedName("types") val types: List<Type>,
    @SerializedName("weight") val weight: Int
)