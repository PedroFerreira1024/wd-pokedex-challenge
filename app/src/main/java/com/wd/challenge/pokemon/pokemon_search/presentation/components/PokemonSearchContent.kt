package com.wd.challenge.pokemon.pokemon_search.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.wd.challenge.pokemon.R
import com.wd.challenge.pokemon.core.domain.model.Pokemon
import com.wd.challenge.pokemon.core.presentation.components.EmptyResult
import com.wd.challenge.pokemon.core.presentation.components.ErrorScreen
import com.wd.challenge.pokemon.core.presentation.components.LoadingView
import com.wd.challenge.pokemon.core.util.lowercaseFirstChar
import com.wd.challenge.pokemon.pokemon_list.presenation.component.PokemonItem
import com.wd.challenge.pokemon.pokemon_search.presentation.PokemonSearchEvent

@Composable
fun PokemonSearchContent(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    pagingPokemons: LazyPagingItems<Pokemon>,
    query: String,
    onSearch: (String) -> Unit,
    onEvent: (PokemonSearchEvent) -> Unit,
    onDetail: (pokemonName: String) -> Unit
) {
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        SearchComponent(
            query = query,
            onSearch = {
                isLoading = true
                onSearch(query.lowercaseFirstChar())
            },
            onQueryChangeEvent = {
                onEvent(it)
            },
            modifier = Modifier.padding(all = 8.dp )
        )


        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp)
        ) {
            items(pagingPokemons.itemCount) { index ->
                val pokemon = pagingPokemons[index]
                pokemon?.let {
                    PokemonItem(
                        modifier = Modifier
                            .padding(horizontal = 6.dp),
                        pokemonId = it.id.toString(),
                        name = it.name,
                        image = it.sprite,
                        onClick =  { pokemonName ->
                            onDetail(pokemonName)
                        }
                    )
                }
                isLoading = false
            }
            pagingPokemons.apply {
                when {
                    query.isNotEmpty() && isLoading && this.itemCount == 0 -> {
                        isLoading = false
                        item {
                            EmptyResult(
                                modifier = Modifier.padding(top = 24.dp).align(Alignment.CenterHorizontally),
                                message = stringResource(id = R.string.empty_msg)   
                            )
                        }
                    }
                    isLoading -> {
                        item {
                            LoadingView()
                        }
                    }
                    loadState.refresh is LoadState.Error -> {
                        isLoading = false
                        item {
                            ErrorScreen(
                                modifier = Modifier.fillParentMaxSize(),
                                message = stringResource(id = R.string.error_msg),
                                retry = {
                                    retry()
                                }
                            )
                        }
                    }
                    loadState.append is LoadState.Error -> {
                        isLoading = false
                        item {
                            ErrorScreen(
                                message = stringResource(id = R.string.error_msg),
                                retry = {
                                    retry()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
