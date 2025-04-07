package com.jeanmeza.mycity.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jeanmeza.mycity.R
import com.jeanmeza.mycity.data.Recommendation
import com.jeanmeza.mycity.ui.screen.CategoriesScreen
import com.jeanmeza.mycity.ui.screen.RecommendationDetailsScreen
import com.jeanmeza.mycity.ui.screen.RecommendationsScreen

enum class AppScreens(@StringRes val title: Int) {
    Categories(title = R.string.categories),
    Recommendations(title = R.string.recommendations),
    RecommendationDetails(title = R.string.recommendation_details)
}

@Composable
fun MyCityApp(
    viewModel: AppViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.uiState.collectAsState()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AppScreens.valueOf(
        backStackEntry?.destination?.route ?: AppScreens.Categories.name
    )
    Scaffold(
        topBar = {
            MyCityAppBar(
                uiState = uiState,
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppScreens.Categories.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = AppScreens.Categories.name) {
                CategoriesScreen(
                    onCategoryClick = {
                        viewModel.loadRecommendations(it)
                        navController.navigate(AppScreens.Recommendations.name)
                    },
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(dimensionResource(R.dimen.padding_small)),
                )
            }
            composable(route = AppScreens.Recommendations.name) {
                RecommendationsScreen(
                    onRecommendationClick = {
                        viewModel.setRecommendation(it)
                        navController.navigate(AppScreens.RecommendationDetails.name)
                    },
                    uiState = uiState,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(dimensionResource(R.dimen.padding_small)),
                )
            }
            composable(route = AppScreens.RecommendationDetails.name) {
                RecommendationDetailsScreen(
                    uiState = uiState,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun MyCityAppBar(
    uiState: AppUiState,
    currentScreen: AppScreens,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val titleText = getAppBarTitle(currentScreen, uiState.selectedRecommendation)
    TopAppBar(
        title = { Text(stringResource(titleText)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            }
        }
    )
}

/**
 * If the current screen is the RecommendationDetails screen, then return the name of the selected
 * recommendation. Otherwise return the name of the screen.
 */
private fun getAppBarTitle(currentScreen: AppScreens, recommendation: Recommendation?): Int {
    return if (currentScreen == AppScreens.RecommendationDetails) recommendation!!.name
    else currentScreen.title
}
