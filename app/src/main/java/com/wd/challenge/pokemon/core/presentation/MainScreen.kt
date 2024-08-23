package com.wd.challenge.pokemon.core.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.wd.challenge.pokemon.core.presentation.navigation.BottomNavigationBar
import com.wd.challenge.pokemon.core.presentation.navigation.DetailScreenNav
import com.wd.challenge.pokemon.core.presentation.navigation.NavigationGraph
import com.wd.challenge.pokemon.core.presentation.navigation.currentRoute

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(modifier: Modifier = Modifier,
               navController: NavHostController
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Scaffold(modifier = modifier.systemBarsPadding(),
            bottomBar = {
                if (
                    currentRoute(navController = navController) != DetailScreenNav.DetailScreen.route
                )
                BottomNavigationBar(navController = navController)
            },
            content = { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    NavigationGraph(navController = navController)
                }
            }
        )
    }
}