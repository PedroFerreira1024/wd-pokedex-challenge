package com.wd.challenge.pokemon.pokemon_detail.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wd.challenge.pokemon.core.presentation.components.AsyncImageUrl

@Composable
fun PokemonDetailBackdropImage (
    artworkImageUrl: String,
    modifier: Modifier = Modifier
){
    Box(modifier = modifier
        .border(
            width = 2.dp,
            color = MaterialTheme.colorScheme.onSurface,
            shape = RoundedCornerShape(8.dp))
    ) {
        AsyncImageUrl(
            imageUrl = artworkImageUrl,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .background(MaterialTheme.colorScheme.surface),
            contentScale = ContentScale.Inside
        )
    }
}

@Preview
@Composable
fun PokemonDetailBackdropImagePreview () {
    PokemonDetailBackdropImage(
        artworkImageUrl = "",
        modifier = Modifier.fillMaxWidth()
    )
}