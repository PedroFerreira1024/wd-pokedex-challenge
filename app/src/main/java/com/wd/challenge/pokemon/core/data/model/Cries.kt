package com.wd.challenge.pokemon.core.data.model

import com.google.gson.annotations.SerializedName

data class Cries(
    @SerializedName("latest") val latest: String,
    @SerializedName("legacy") val legacy: String
)