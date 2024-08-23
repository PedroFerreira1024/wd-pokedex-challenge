package com.wd.challenge.pokemon.pokemon_search.di

import com.wd.challenge.pokemon.core.data.PokemonService
import com.wd.challenge.pokemon.pokemon_search.data.repository.PokemonSearchRepositoryImp
import com.wd.challenge.pokemon.pokemon_search.data.source.PokemonSearchDataSourceImp
import com.wd.challenge.pokemon.pokemon_search.domain.repository.PokemonSearchRepository
import com.wd.challenge.pokemon.pokemon_search.domain.source.PokemonSearchDataSource
import com.wd.challenge.pokemon.pokemon_search.domain.usecase.GetPokemonSearchUseCase
import com.wd.challenge.pokemon.pokemon_search.domain.usecase.GetPokemonSearchUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module // Contains dependency definitions
@InstallIn(SingletonComponent::class) // As a Singleton to hold the info during the life of the App
object PokemonSearchModule {

    @Provides // Providing the instance of the indicated object
    @Singleton // Marking the above instance should be a Singleton
    fun provideMovieSearchDataSource(service: PokemonService): PokemonSearchDataSource {
        return PokemonSearchDataSourceImp(service = service)
    }
    @Provides // Providing the instance of the indicated object
    @Singleton // Marking the above instance should be a Singleton
    fun provideMovieSearchRepository(dataSource: PokemonSearchDataSource): PokemonSearchRepository {
        return PokemonSearchRepositoryImp(dataSource = dataSource)
    }

    @Provides // Providing the instance of the indicated object
    @Singleton // Marking the above instance should be a Singleton
    fun provideGetMovieSearchUseCase(repository: PokemonSearchRepository): GetPokemonSearchUseCase {
        return GetPokemonSearchUseCaseImp(repository = repository)
    }
}