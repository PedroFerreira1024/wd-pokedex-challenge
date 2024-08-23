package com.wd.challenge.pokemon.pokemon_search.presentation

sealed class PokemonSearchEvent {
    data class EnteredQuery(val value: String) : PokemonSearchEvent()
}