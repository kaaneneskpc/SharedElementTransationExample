package com.kaaneneskpc.sharedelementtransation.presentation.screen

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kaaneneskpc.sharedelementtransation.model.images

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.DetailsScreen(
    animatedVisibilityScope: AnimatedVisibilityScope,
    imageId: Int,
    onClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            modifier = Modifier
                .sharedElement(
                    state = rememberSharedContentState(key = "image-${imageId}"),
                    animatedVisibilityScope = animatedVisibilityScope
                )
                .fillMaxWidth()
                .height(350.dp)
                .clickable { onClick() },
            model = images[imageId - 1].photo,
            contentDescription = "Unsplash Image",
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Text(
                modifier = Modifier.sharedElement(
                    state = rememberSharedContentState(key = "text-${imageId}"),
                    animatedVisibilityScope = animatedVisibilityScope
                ),
                text = images[imageId - 1].author,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight = FontWeight.Medium
            )
        }
    }
}