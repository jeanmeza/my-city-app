package com.jeanmeza.mycity.ui.screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
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
import androidx.compose.ui.unit.dp
import com.jeanmeza.mycity.R
import com.jeanmeza.mycity.data.Recommendation
import com.jeanmeza.mycity.data.local.LocalCategoriesProvider
import com.jeanmeza.mycity.data.local.LocalRecommendationsProvider
import com.jeanmeza.mycity.ui.AppUiState
import com.jeanmeza.mycity.ui.theme.MyCityTheme

@Composable
fun RecommendationsScreen(
    uiState: AppUiState,
    onRecommendationClick: (Recommendation) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        uiState.recommendations.forEach {
            Card(
                onClick = { onRecommendationClick(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RecommendationImage(
                        recommendationImage = it.imageResource,
                        recommendationName = it.name,
                    )
                    RecommendationInfo(
                        recommendationName = it.name,
                    )
                }
            }
        }
    }
}

@Composable
fun RecommendationImage(
    @DrawableRes recommendationImage: Int,
    @StringRes recommendationName: Int,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(recommendationImage),
            contentDescription = stringResource(recommendationName),
            modifier = Modifier
                .size(width = 68.dp, height = 68.dp)
                .aspectRatio(1f),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun RecommendationInfo(
    @StringRes recommendationName: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_small)),
        contentAlignment = Alignment.CenterStart,
    ) {
        Text(
            text = stringResource(recommendationName),
            style = MaterialTheme.typography.headlineSmall,
        )
    }
}

@Preview
@Composable
fun RecommendationsScreenPreview() {
    MyCityTheme {
        RecommendationsScreen(
            onRecommendationClick = {},
            uiState = AppUiState(
                categories = LocalCategoriesProvider.allCategories,
                recommendations = LocalRecommendationsProvider.getAllRecommendations(),
            ),
            modifier = Modifier
                .fillMaxHeight()
                .padding(dimensionResource(R.dimen.padding_small)),
        )
    }
}
