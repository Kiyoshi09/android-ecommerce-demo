package com.tealiumlabs.ecommercec.ui.components

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tealiumlabs.ecommercec.ui.theme.*

@Composable
fun QuantitySelector(
    count: Int,
    decreaseItemCount: () -> Unit,
    increaseItemCount: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = "Qty",
                style = MaterialTheme.typography.subtitle1,
                color = colorTextBodyLight,
                modifier = Modifier
                    .padding(end = 18.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        IconButton(
            onClick = decreaseItemCount
        ) {
            Icon(
                imageVector = Icons.Default.Remove,
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        Crossfade(
            targetState = count,
            modifier = Modifier
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = "$it",
                style = MaterialTheme.typography.subtitle2,
                fontSize = 18.sp,
                color = Lavender11,
                textAlign = TextAlign.Center,
                modifier = Modifier.widthIn(min = 24.dp)
            )
        }
        IconButton(
            onClick = increaseItemCount
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun QuantitySelectorSmall(
    count: Int,
    decreaseItemCount: () -> Unit,
    increaseItemCount: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Qty :",
            style = EcommTypography.h5.copy(
                fontSize = 12.sp,
            ),
        )

        IconButton(
            onClick = decreaseItemCount
        ) {
            Icon(
                imageVector = Icons.Default.Remove,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(16.dp)
                    .border(1.dp, color = Color.DarkGray, shape = RoundedCornerShape(5.dp))
            )
        }

        Crossfade(
            targetState = count,
            modifier = Modifier
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = "$it",
                style = MaterialTheme.typography.subtitle2,
                fontSize = 14.sp,
                color = Lavender11,
                textAlign = TextAlign.Center,
                modifier = Modifier.widthIn(min = 8.dp)
            )
        }

        IconButton(
            onClick = increaseItemCount
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(16.dp)
                    .border(1.dp, color = Color.DarkGray, shape = RoundedCornerShape(5.dp))
            )
        }
    }
}
