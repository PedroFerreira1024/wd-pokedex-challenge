package com.wd.challenge.pokemon.pokemon_list.presenation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.collectAsLazyPagingItems
import com.wd.challenge.pokemon.R
import com.wd.challenge.pokemon.pokemon_list.presenation.component.PokemonListContent
import com.wd.challenge.pokemon.pokemon_list.presenation.state.PokemonListState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen (
    modifier : Modifier = Modifier,
    uiState: PokemonListState,
    navigateToDetail: (String) -> Unit
) {
    val pokemons = uiState.pokemons.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors =
                    TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary)
            )
        },
        content = { paddingValues ->
            PokemonListContent(
                modifier = modifier,
                pagingPokemons = pokemons,
                paddingValues = paddingValues,
                onClick =  { name ->
                    navigateToDetail(name)
                })
        }
    )
}