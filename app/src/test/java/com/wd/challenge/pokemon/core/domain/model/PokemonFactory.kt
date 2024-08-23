package com.wd.challenge.pokemon.core.domain.model

class PokemonFactory {

    fun create(pokemon: PokemonFake) = when (pokemon) {
        PokemonFake.Bulbasaur -> {
            Pokemon(
                id = 1,
                name = "bulbasaur"
            )
        }
        PokemonFake.Charmander -> {
            Pokemon(
                id = 4,
                name = "charmander"
            )
        }
        PokemonFake.Squirtle -> {
            Pokemon(
                id = 7,
                name = "squirtle"
            )
        }
    }

    sealed class PokemonFake {
        object Bulbasaur: PokemonFake()
        object Charmander: PokemonFake()
        object Squirtle: PokemonFake()
    }
}