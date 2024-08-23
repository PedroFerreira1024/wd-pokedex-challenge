package com.wd.challenge.pokemon.pokemon_detail.presentation

sealed class PokemonDetailEvent {
    data class GetPokemonDetail(val pokemonName: String) : PokemonDetailEvent()
}