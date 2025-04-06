package com.jeanmeza.mycity.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jeanmeza.mycity.ui.screen.CategoriesScreen

@Composable
fun MyCityApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    CategoriesScreen(
        modifier = modifier
    )
}
