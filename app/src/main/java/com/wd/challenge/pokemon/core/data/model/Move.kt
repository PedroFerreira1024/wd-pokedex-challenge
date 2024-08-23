package com.wd.challenge.pokemon.core.data.model

import com.google.gson.annotations.SerializedName

data class Move(
    @SerializedName("move") val move: MoveX,
)
