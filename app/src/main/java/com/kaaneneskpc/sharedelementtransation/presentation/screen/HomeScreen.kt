package com.kaaneneskpc.sharedelementtransation.presentation.screen

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kaaneneskpc.sharedelementtransation.model.images
import com.kaaneneskpc.sharedelementtransation.presentation.component.UnsplashImageView

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.HomeScreen(animatedVisibilityScope: AnimatedVisibilityScope, onImageClick: (Int) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = images,
            key = { it.id }
        ) {
            UnsplashImageView(
                animatedVisibilityScope = animatedVisibilityScope,
                data = it,
                onClick = onImageClick
            )
        }
    }
}