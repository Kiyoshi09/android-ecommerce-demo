package com.tealiumlabs.ecommercec.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.tealiumlabs.ecommercec.R

@Composable
fun OutfitImage(
    imageUrl: String,
    contentDescription: String? = null,
    modifier: Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = 0.dp,
    contentScale: ContentScale = ContentScale.Fit
) {
    ECommcSurface(
        elevation = elevation,
        shape = shape,
        modifier = modifier
    ) {
        Image(
            painter = rememberImagePainter(
                data = imageUrl,
                builder = {
                    crossfade(true)
                    placeholder(drawableResId = R.drawable.plate_placeholder)
                }
            ),
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize(),
            contentScale = contentScale
        )
    }
}
