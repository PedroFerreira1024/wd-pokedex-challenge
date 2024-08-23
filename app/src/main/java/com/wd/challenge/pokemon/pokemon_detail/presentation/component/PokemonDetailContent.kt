package com.wd.challenge.pokemon.pokemon_detail.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.wd.challenge.pokemon.R
import com.wd.challenge.pokemon.core.domain.model.PokemonDetails

@Composable
fun PokemonDetailContent(
    modifier: Modifier = Modifier,
    pokemonDetails: PokemonDetails?,
    isLoading: Boolean,
    isError: String
) {

    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .height(270.dp)
                    .fillMaxWidth()
                    .padding(2.dp)
            ) {
                PokemonDetailBackdropImage(
                    artworkImageUrl = pokemonDetails?.artwork ?: "",
                    modifier = Modifier
                        .background(
                            MaterialTheme.colorScheme.surface
                        )
                        .fillMaxWidth(0.55f)
                        .padding(2.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                PokemonDetailBaseValues(
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    name = pokemonDetails?.name ?: "",
                    order = pokemonDetails?.order ?: 0,
                    height = pokemonDetails?.height ?: 0,
                    weight = pokemonDetails?.weight ?: 0
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 6.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.stats),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            PokemonDetailStats(
                modifier = Modifier.height(70.dp),
                stats = pokemonDetails?.stats ?: emptyList()
            )
            Spacer(modifier = Modifier.height(18.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 6.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.types),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            PokemonDetailTypes(
                modifier = Modifier.height(80.dp),
                types = pokemonDetails?.types ?: emptyList()
            )
        }
    }
}