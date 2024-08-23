package com.wd.challenge.pokemon.pokemon_detail.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.wd.challenge.pokemon.core.data.model.Type
import com.wd.challenge.pokemon.core.util.titlecaseFirstChar

@Composable
fun PokemonDetailTypes(
    modifier: Modifier = Modifier,
    types: List<Type>
) {

    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        items(types.size) {
            with(types[it]) {
                val label = this.type.name
                Text(
                    text = label.titlecaseFirstChar(),
                    style = MaterialTheme.typography.labelLarge,
                    fontSize = 16.sp
                )
            }
        }
    }

}