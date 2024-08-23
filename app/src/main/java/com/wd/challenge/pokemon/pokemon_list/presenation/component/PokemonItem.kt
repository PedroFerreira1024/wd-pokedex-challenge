package com.wd.challenge.pokemon.pokemon_list.presenation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.wd.challenge.pokemon.core.presentation.components.AsyncImageUrl
import com.wd.challenge.pokemon.core.util.titlecaseFirstChar

@Composable
fun PokemonItem (
    modifier: Modifier = Modifier,
    pokemonId: String,
    name: String,
    image: String,
    onClick: (name: String) -> Unit
){

    Row(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(8.dp)
            )
            .fillMaxSize()
            .padding(1.dp)
            .clickable {
                onClick(name)
            }
    ) {

        Box (
            modifier = Modifier
                .widthIn(min = 60.dp)
                .padding(start = 10.dp, end = 4.dp)
                .align(Alignment.CenterVertically),
        ){
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "#" + pokemonId,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

        Card(
            modifier = Modifier
                .fillMaxHeight()
                .zIndex(0.5f)
                .padding(6.dp)
        ) {
            Box {
                AsyncImageUrl(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.surface
                        )
                        .size(80.dp)
                        .align(Alignment.Center)
                        .padding(1.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    imageUrl = image
                )
            }
        }
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 20.dp),
            text = name.titlecaseFirstChar(),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Preview
@Composable
fun PokemonItemPreview() {
    PokemonItem(
        pokemonId = "1",
        name = "Pixacu",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"
    ) {

    }
}