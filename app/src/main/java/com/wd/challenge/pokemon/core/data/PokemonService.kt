package com.wd.challenge.pokemon.core.data

import com.wd.challenge.pokemon.core.data.response.PokemonListResponse
import com.wd.challenge.pokemon.core.data.response.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon/{pokemon_name}")
    suspend fun getPokemon(
        @Path("pokemon_name") pokemonName: String
    ): PokemonResponse

    @GET("pokemon/")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int
    ): PokemonListResponse
}