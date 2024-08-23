package com.wd.challenge.pokemon.pokemon_list.presenation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.wd.challenge.pokemon.R
import com.wd.challenge.pokemon.core.domain.model.Pokemon
import com.wd.challenge.pokemon.core.presentation.components.ErrorScreen
import com.wd.challenge.pokemon.core.presentation.components.LoadingView

@Composable
fun PokemonListContent (
    modifier: Modifier = Modifier,
    pagingPokemons: LazyPagingItems<Pokemon>,
    paddingValues: PaddingValues,
    onClick: (name: String) -> Unit
){
    Box(modifier.background(MaterialTheme.colorScheme.background)) {

        LazyColumn(
            contentPadding = paddingValues,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp)
        ) {
            items(pagingPokemons.itemCount) {index ->
                val pokemon = pagingPokemons[index]
                pokemon?.let {
                    PokemonItem(
                        modifier = Modifier.padding(horizontal = 6.dp),
                        pokemonId = it.id.toString(),
                        name = it.name,
                        image = it.sprite,
                        onClick = { name ->
                            onClick(name)
                        }
                    )
                }
            }
            pagingPokemons.apply {
                when{
                    loadState.refresh is LoadState.Loading -> {
                        item{
                            LoadingView(modifier = Modifier.fillParentMaxSize())
                        }
                    }
                    loadState.append is LoadState.Loading -> {
                        item {
                            LoadingView()
                        }
                    }
                    loadState.refresh is LoadState.Error -> {
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