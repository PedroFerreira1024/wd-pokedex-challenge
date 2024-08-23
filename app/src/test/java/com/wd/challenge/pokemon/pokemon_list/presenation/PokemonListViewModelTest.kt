package com.wd.challenge.pokemon.pokemon_list.presenation

import androidx.paging.PagingData
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.whenever
import com.wd.challenge.pokemon.TestDispatcherRule
import com.wd.challenge.pokemon.core.domain.model.PokemonFactory
import com.wd.challenge.pokemon.pokemon_list.domain.usecase.GetPokemonListUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PokemonListViewModelTest {

    // Defining dispatcher as a good practice for testing
    @get:Rule
    val dispatcherRule = TestDispatcherRule()

    @Mock
    lateinit var getPokemonListUseCase: GetPokemonListUseCase

    private val viewModel by lazy {
        PokemonListViewModel(getPokemonListUseCase)
    }

    private val fakePagingDataPokemon = PagingData.from(
        listOf(
            PokemonFactory().create(pokemon = PokemonFactory.PokemonFake.Bulbasaur),
            PokemonFactory().create(pokemon = PokemonFactory.PokemonFake.Charmander),
            PokemonFactory().create(pokemon = PokemonFactory.PokemonFake.Squirtle)
        )
    )

    @Test
    fun `must validate paging data object values when calling paging data from pokemons list`() = runTest {

        //Given
        whenever(getPokemonListUseCase.invoke()).thenReturn(
            flowOf(fakePagingDataPokemon)
        )

        //When
        val result = viewModel.uiState.pokemons.first()

        //Then
        assertThat(result).isNotNull()
    }

    @Test(expected = RuntimeException::class)
    fun `must throw an exception when the calling to the use case returns an exception`() = runTest {

        //Given
        whenever(getPokemonListUseCase.invoke())
            .thenThrow(RuntimeException())

        //When
        val result = viewModel.uiState.pokemons.first() // trigger init()

        //Then
        assertThat(result).isNull() //redundant as it will throw exception
    }

}