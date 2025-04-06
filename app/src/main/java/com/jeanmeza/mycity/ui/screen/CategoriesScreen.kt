package com.jeanmeza.mycity.ui.screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jeanmeza.mycity.R
import com.jeanmeza.mycity.ui.AppViewModel
import com.jeanmeza.mycity.ui.theme.MyCityTheme

@Composable
fun CategoriesScreen(viewModel: AppViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    LazyColumn(contentPadding = PaddingValues(dimensionResource(R.dimen.padding_small))) {
        items(uiState.categories) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    CategoryImage(image = it.imageResource, name = it.name)
                    CategoryInfo(categoryName = it.name)
                }
            }
        }
    }
}

@Composable
fun CategoryImage(
    @DrawableRes image: Int,
    @StringRes name: Int,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(image),
            contentDescription = stringResource(name),
            modifier = Modifier
                .size(width = 68.dp, height = 68.dp)
                .aspectRatio(1f),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun CategoryInfo(@StringRes categoryName: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_small)),
        contentAlignment = Alignment.CenterStart,
    ) {
        Text(
            text = stringResource(categoryName),
            style = MaterialTheme.typography.headlineSmall,
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun CategoriesScreenPreview() {
    MyCityTheme {
        CategoriesScreen()
    }
}