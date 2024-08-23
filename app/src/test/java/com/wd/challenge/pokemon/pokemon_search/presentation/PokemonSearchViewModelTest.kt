package com.wd.challenge.pokemon.pokemon_search.presentation

import androidx.paging.PagingData
import com.google.common.truth.Truth
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import com.wd.challenge.pokemon.TestDispatcherRule
import com.wd.challenge.pokemon.core.domain.model.PokemonFactory
import com.wd.challenge.pokemon.pokemon_search.domain.usecase.GetPokemonSearchUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PokemonSearchViewModelTest {

    // Defining dispatcher as a good practice for testing
    @get:Rule
    val dispatcherRule = TestDispatcherRule()

    @Mock
    lateinit var getPokemonSearchUseCase: GetPokemonSearchUseCase

    private val viewModel by lazy {
        PokemonSearchViewModel(getPokemonSearchUseCase)
    }

    private val fakePagingDataPokemon = PagingData.from(
        listOf(
            PokemonFactory().create(pokemon = PokemonFactory.PokemonFake.Bulbasaur),
            PokemonFactory().create(pokemon = PokemonFactory.PokemonFake.Charmander),
            PokemonFactory().create(pokemon = PokemonFactory.PokemonFake.Squirtle)
        )
    )


    @Test
    fun `must validate paging data object values when calling paging data from pokemon search`() = runTest {

        //Given
        whenever(getPokemonSearchUseCase.invoke(any())).thenReturn(
            flowOf(fakePagingDataPokemon)
        )

        //When
        viewModel.fetch("")
        val result = viewModel.uiState.pokemons.first()

        //Then
        Truth.assertThat(result).isNotNull()
    }

    @Test(expected = RuntimeException::class)
    fun `must throw an exception when the calling to the use case returns an exception`() = runTest {

        //Given
        whenever(getPokemonSearchUseCase.invoke(any()))
            .thenThrow(RuntimeException())

        //When
        val result = viewModel.uiState.pokemons.first() // trigger init()

        //Then
        Truth.assertThat(result).isNull() //redundant as it will throw exception
    }
}