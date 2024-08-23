package com.wd.challenge.pokemon.core.domain.model



class PokemonDetailFactory {

    fun create(pokemon: PokemonDetailFake) = when (pokemon) {
        PokemonDetailFake.Bulbasaur -> {
            PokemonDetails(
                name = "bulbasaur",
                order = 1,
                height = 10,
                weight = 12,
                stats = emptyList(),
                types = emptyList(),
                artwork = ""
            )
        }
        PokemonDetailFake.Charmander -> {
            PokemonDetails(
                name = "charmander",
                order = 4,
                height = 12,
                weight = 10,
                stats = emptyList(),
                types = emptyList(),
                artwork = ""
            )
        }
    }

    sealed class PokemonDetailFake {
        object Bulbasaur: PokemonDetailFake()
        object Charmander: PokemonDetailFake()
    }
}