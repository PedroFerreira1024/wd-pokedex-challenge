package com.wd.challenge.pokemon.core.paging

import androidx.paging.PagingSource
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import com.wd.challenge.pokemon.TestDispatcherRule
import com.wd.challenge.pokemon.core.domain.model.PokemonFactory
import com.wd.challenge.pokemon.core.domain.model.PokemonPagingFactory
import com.wd.challenge.pokemon.pokemon_list.domain.source.PokemonListDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PokemonPagingSourceTest {

    // Defining dispatcher as a good practice for testing
    @get:Rule
    val dispatcherRule = TestDispatcherRule()

    @Mock
    lateinit var dataSource: PokemonListDataSource

    private val pokemonFactory = PokemonFactory()

    private val pokemonPagingFactory = PokemonPagingFactory()

    private val pokemonListPagingSource by lazy {
        PokemonPagingSource(dataSource = dataSource)
    }

    @Test
    fun `must return a success load result when load is called`() = runTest {

        //Given
        whenever(dataSource.getPokemonList(any()))
            .thenReturn(pokemonPagingFactory.create())
        //When
        val result = pokemonListPagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 2,
                placeholdersEnabled = false
            )
        )

        val resultExpected = listOf(
            pokemonFactory.create(PokemonFactory.PokemonFake.Bulbasaur),
            pokemonFactory.create(PokemonFactory.PokemonFake.Charmander)
        )

        //Then
        assertThat(PagingSource.LoadResult.Page(
            data = resultExpected,
            prevKey = null,
            nextKey = 20
        )).isEqualTo(result)
    }

}