package com.wd.challenge.pokemon.pokemon_detail.di

import com.wd.challenge.pokemon.pokemon_detail.domain.repository.PokemonDetailRepository
import com.wd.challenge.pokemon.pokemon_detail.domain.source.PokemonDetailDataSource
import com.wd.challenge.pokemon.pokemon_detail.domain.usecase.PokemonDetailUseCase
import com.wd.challenge.pokemon.pokemon_detail.domain.usecase.PokemonDetailUseCaseImp
import com.wd.challenge.pokemon.core.data.PokemonService
import com.wd.challenge.pokemon.pokemon_detail.data.repository.PokemonDetailRepositoryImp
import com.wd.challenge.pokemon.pokemon_detail.data.source.PokemonDetailDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module // Contains dependency definitions
@InstallIn(SingletonComponent::class) // As a Singleton to hold the info during the life of the App
object PokemonDetailsModule {

    @Provides // Providing the instance of the indicated object
    @Singleton // Marking the above instance should be a Singleton
    fun providePokemonDetailsDataSource(service: PokemonService): PokemonDetailDataSource {
        return PokemonDetailDataSourceImp(service = service)
    }

    @Provides // Providing the instance of the indicated object
    @Singleton // Marking the above instance should be a Singleton
    fun providePokemonDetailsRepository(dataSource: PokemonDetailDataSource): PokemonDetailRepository {
        return PokemonDetailRepositoryImp(dataSource = dataSource)
    }

    @Provides // Providing the instance of the indicated object
    @Singleton // Marking the above instance should be a Singleton
    fun provideGetPokemonDetailsUseCase(repository: PokemonDetailRepository): PokemonDetailUseCase {
        return PokemonDetailUseCaseImp(repository = repository)
    }
}