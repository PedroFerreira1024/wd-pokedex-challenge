package com.wd.challenge.pokemon.core.data.model

import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName("official-artwork") val officialArtwork: OfficialArtwork
)