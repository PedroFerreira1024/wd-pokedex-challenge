package com.wd.challenge.pokemon.core.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.wd.challenge.pokemon.R

@Composable
fun AsyncImageUrl(
    modifier: Modifier = Modifier,
    imageUrl: String,
    crossFadeEnable: Boolean = true,
    @DrawableRes errorImage: Int = R.drawable.error_missigno,
    @DrawableRes placeholderImage: Int = R.drawable.pokeball_placeholder,
    contentScale: ContentScale = ContentScale.FillHeight
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(crossFadeEnable)
            .crossfade(500)
            .error(errorImage)
            .placeholder(placeholderImage)
            .build(),
        contentDescription = "",
        contentScale = contentScale,
        modifier = modifier.fillMaxHeight()
            .graphicsLayer(
                scaleX = 1f,
                scaleY = 1f,
        )
    )
}