package com.wd.challenge.pokemon.pokemon_list.di

import com.wd.challenge.pokemon.core.data.PokemonService
import com.wd.challenge.pokemon.pokemon_list.data.repository.PokemonListRepositoryImp
import com.wd.challenge.pokemon.pokemon_list.data.source.PokemonListDataSourceImp
import com.wd.challenge.pokemon.pokemon_list.domain.repository.PokemonListRepository
import com.wd.challenge.pokemon.pokemon_list.domain.source.PokemonListDataSource
import com.wd.challenge.pokemon.pokemon_list.domain.usecase.GetPokemonListUseCase
import com.wd.challenge.pokemon.pokemon_list.domain.usecase.GetPokemonListUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokemonListModule {

    @Provides // Providing the instance of the indicated object
    @Singleton // Marking the above instance should be a Singleton
    fun providePokemonListDataSource(service: PokemonService): PokemonListDataSource {
        return PokemonListDataSourceImp(service = service)
    }
    @Provides // Providing the instance of the indicated object
    @Singleton // Marking the above instance should be a Singleton
    fun providePokemonListRepository(dataSource: PokemonListDataSource): PokemonListRepository {
        return PokemonListRepositoryImp(dataSource = dataSource)
    }
    @Provides // Providing the instance of the indicated object
    @Singleton // Marking the above instance should be a Singleton
    fun provideGetPokemonListUseCase(pokemonListRepository: PokemonListRepository): GetPokemonListUseCase {
        return GetPokemonListUseCaseImp(repository = pokemonListRepository)
    }
}