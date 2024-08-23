package com.wd.challenge.pokemon.pokemon_detail.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BaseValuePair (
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    labelSize: TextUnit = 12.sp,
    valueSize: TextUnit = 14.sp
){
    Row (modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){

        Text(
            modifier = Modifier.align(Alignment.Bottom),
            text = label,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.ExtraBold,
            fontSize = labelSize
        )
        Spacer(modifier = Modifier.size(2.dp))
        Text(
            modifier = Modifier.align(Alignment.Bottom),
            text = value,
            maxLines = 1,
            style = MaterialTheme.typography.labelMedium,
            fontSize = valueSize
        )
    }
}

@Preview
@Composable
fun BaseValuePairPreview() {
    BaseValuePair(label = "Height", value = "68")
}