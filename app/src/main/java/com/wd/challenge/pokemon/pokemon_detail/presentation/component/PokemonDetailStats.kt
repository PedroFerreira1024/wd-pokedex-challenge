package com.wd.challenge.pokemon.pokemon_detail.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wd.challenge.pokemon.core.data.model.Stat
import com.wd.challenge.pokemon.core.util.titlecaseFirstChar

@Composable
fun PokemonDetailStats(
    modifier: Modifier = Modifier,
    stats: List<Stat>
) {

    LazyHorizontalGrid(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        rows = GridCells.Fixed(2)
    ) {
        items(stats.size) {
            with(stats[it]) {
                val label = this.stat.name
                val value = this.baseStat
                BaseValuePair(
                    Modifier
                        .fillMaxWidth(.5f)
                        .padding(start = 4.dp),
                    label = label.titlecaseFirstChar(),
                    value = value.toString()
                )
            }
        }
    }
}