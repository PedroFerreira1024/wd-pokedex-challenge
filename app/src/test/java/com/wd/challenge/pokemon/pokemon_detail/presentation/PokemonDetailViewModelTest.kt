package com.wd.challenge.pokemon.pokemon_detail.presentation

import androidx.lifecycle.SavedStateHandle
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.wd.challenge.pokemon.TestDispatcherRule
import com.wd.challenge.pokemon.core.domain.model.PokemonDetailFactory
import com.wd.challenge.pokemon.core.domain.model.PokemonFactory
import com.wd.challenge.pokemon.core.util.Constants
import com.wd.challenge.pokemon.core.util.ResultData
import com.wd.challenge.pokemon.pokemon_detail.domain.usecase.PokemonDetailUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PokemonDetailViewModelTest {

    // Defining dispatcher as a good practice for testing
    @get:Rule
    val dispatcherRule = TestDispatcherRule()

    @Mock
    lateinit var getPokemonDetailsUseCase: PokemonDetailUseCase

    @Mock
    lateinit var savedStateHandle: SavedStateHandle

    private var pokemonDetailFactory =
        PokemonDetailFactory().create(pokemon = PokemonDetailFactory.PokemonDetailFake.Bulbasaur)

    private var pokemonFake = PokemonFactory().create(pokemon = PokemonFactory.PokemonFake.Bulbasaur)

    private val viewModel by lazy {
        PokemonDetailViewModel(
            getPokemonDetailUseCase = getPokemonDetailsUseCase,
            savedStateHandle = savedStateHandle.apply {
                whenever(savedStateHandle.get<String>(Constants.POKEMON_DETAIL_ARG_KEY)).thenReturn(pokemonFake.name)
            }
        )
    }

    @Test
    fun `must notify uiState with success when get pokemon details returns success`() = runTest {

        //Given
        whenever(getPokemonDetailsUseCase.invoke(any()))
            .thenReturn(flowOf(ResultData.Success(pokemonDetailFactory)))

        val argumentCaptor = argumentCaptor<PokemonDetailUseCase.Params>()

        //When
        viewModel.uiState.isLoading

        //Then
        verify(getPokemonDetailsUseCase.invoke(argumentCaptor.capture()))
        assertThat(pokemonDetailFactory.name).isEqualTo(argumentCaptor.firstValue.pokemonName)
        val pokemonDetails = viewModel.uiState.pokemonDetails
        assertThat(pokemonDetails).isNotNull()
    }
}