package com.wd.challenge.pokemon.pokemon_detail.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.wd.challenge.pokemon.R
import com.wd.challenge.pokemon.core.util.titlecaseFirstChar

@Composable
fun PokemonDetailBaseValues (
    modifier: Modifier = Modifier,
    name: String,
    order: Int,
    height: Int,
    weight: Int,
    baackgroundColor: Color = MaterialTheme.colorScheme.surface
){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 4.dp)
            .background(baackgroundColor),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Spacer(modifier
            .background(MaterialTheme.colorScheme.onBackground)
            .height(6.dp)
        )
        BaseValuePair(
            label = stringResource(id = R.string.name),
            value = name.titlecaseFirstChar()
        )
        Spacer(modifier
            .background(MaterialTheme.colorScheme.onBackground)
            .height(12.dp)
        )
        BaseValuePair(
            label = stringResource(id = R.string.number),
            value = order.toString()
        )
        Spacer(modifier
            .background(MaterialTheme.colorScheme.onBackground)
            .height(12.dp)
        )
        BaseValuePair(
            label = stringResource(id = R.string.height),
            value = height.toString()
        )
        Spacer(modifier
            .background(MaterialTheme.colorScheme.onBackground)
            .height(12.dp)
        )
        BaseValuePair(
            label = stringResource(id = R.string.weight),
            value = weight.toString()
        )
        Spacer(modifier
            .background(MaterialTheme.colorScheme.onBackground)
            .height(6.dp)
        )
    }
}