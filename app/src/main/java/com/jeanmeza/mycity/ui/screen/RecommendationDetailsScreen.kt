package com.jeanmeza.mycity.ui.screen

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jeanmeza.mycity.R
import com.jeanmeza.mycity.data.Recommendation
import com.jeanmeza.mycity.data.local.LocalRecommendationsProvider
import com.jeanmeza.mycity.ui.AppUiState
import com.jeanmeza.mycity.ui.theme.MyCityTheme

@Composable
fun RecommendationDetailsScreen(
    uiState: AppUiState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        RecommendationImage(recommendation = uiState.selectedRecommendation!!)
        RecommendationDetails(details = uiState.selectedRecommendation.details)
    }
}

@Composable
fun RecommendationImage(
    recommendation: Recommendation,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(recommendation.imageResource),
            contentDescription = stringResource(recommendation.name),
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(R.dimen.image_height)),
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
fun RecommendationDetails(
    @StringRes details: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(details),
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RecommendationDetailsScreenPreview() {
    MyCityTheme {
        RecommendationDetailsScreen(
            uiState = AppUiState(selectedRecommendation = LocalRecommendationsProvider.getAllRecommendations()[0])
        )
    }
}
