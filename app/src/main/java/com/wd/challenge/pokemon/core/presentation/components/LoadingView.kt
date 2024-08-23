package com.wd.challenge.pokemon.core.presentation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wd.challenge.pokemon.R

@Composable
fun LoadingView(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val animation = remember {Animatable(0f)}
        LaunchedEffect(true) {
            animation.animateTo(
                targetValue = 359f,
                animationSpec = infiniteRepeatable(
                    animation = tween(1300, easing = LinearEasing),
                    repeatMode = RepeatMode.Restart
                )
            )
        }
        Image(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(vertical = 12.dp)
                .size(60.dp)
                .rotate(animation.value),
            painter = painterResource(id = R.drawable.unown_loader),
            contentDescription = "Loader")
    }
}

@Preview
@Composable
fun LoadingViewPreview() {
    LoadingView()
}