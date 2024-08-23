package com.wd.challenge.pokemon.core.util

import com.wd.challenge.pokemon.BuildConfig

fun String?.toId() =
    this!!.removeSuffix("/")
        .let { it-> substring(it.lastIndexOf('/') + 1, it.length) }
fun Int?.toSpriteUrl() = "${BuildConfig.BASE_URL_SPRITE}${this.toString() + ".png"}"
fun Int?.toArtworkUrl() = "${BuildConfig.BASE_URL_OFF_ARTWORK}${this.toString() + ".png"}"

fun String.titlecaseFirstChar() = replaceFirstChar(Char::titlecase)
fun String.lowercaseFirstChar() = replaceFirstChar(Char::lowercase)
