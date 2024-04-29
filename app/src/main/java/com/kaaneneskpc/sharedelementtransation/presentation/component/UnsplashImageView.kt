package com.kaaneneskpc.sharedelementtransation.presentation.component

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kaaneneskpc.sharedelementtransation.model.UnsplashImage

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.UnsplashImageView(
    animatedVisibilityScope: AnimatedVisibilityScope,
    data: UnsplashImage,
    onClick: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick(data.id) }
            .padding(8.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .sharedElement(
                    state = rememberSharedContentState(key = "image-${data.id}"),
                    animatedVisibilityScope = animatedVisibilityScope
                )
                .size(80.dp)
                .clip(RoundedCornerShape(12.dp)),
            model = data.photo,
            contentDescription = "Unsplash Image",
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = data.location,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight = FontWeight.Medium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier
                    .sharedElement(
                        state = rememberSharedContentState(key = "text-${data.id}"),
                        animatedVisibilityScope = animatedVisibilityScope
                    )
                    .alpha(0.5f),
                text = data.author,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            )
        }
    }
}