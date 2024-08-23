package com.wd.challenge.pokemon.core.presentation.components

import androidx.annotation.StringRes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonAppBar(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    backEnabled: Boolean = false,
    backPress: () -> Unit = {},
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    backgroundColor: Color = MaterialTheme.colorScheme.primary
) {

    TopAppBar(title = {
            Text(
                text = stringResource(id = title),
                color = textColor
            )
        },
        navigationIcon = {
            if(backEnabled) {
                IconButton(
                    onClick = backPress
                ) {
                    Icon(
                        modifier = Modifier,
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        tint = textColor,
                        contentDescription = ""
                    )
                }
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = backgroundColor),
        modifier = modifier
    )

}