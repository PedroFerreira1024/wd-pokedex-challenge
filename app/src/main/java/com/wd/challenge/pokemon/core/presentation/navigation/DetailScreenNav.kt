package com.wd.challenge.pokemon.core.presentation.navigation

import com.wd.challenge.pokemon.core.util.Constants


sealed class DetailScreenNav(val route: String) {
    object DetailScreen : DetailScreenNav(
        route = "pokemon_detail_screen?${Constants.POKEMON_DETAIL_ARG_KEY}=" +
                "{${Constants.POKEMON_DETAIL_ARG_KEY}}"
    ) {
        fun passPokemonName(pokemonName: String) =
            "pokemon_detail_screen?${Constants.POKEMON_DETAIL_ARG_KEY}=$pokemonName"
    }
}