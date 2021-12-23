package com.tealiumlabs.ecommercec.ui.components

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.tealiumlabs.ecommercec.ui.theme.*

@OptIn(ExperimentalUnitApi::class)
@Composable
fun FavoriteButton(
    height: Dp,
    width: Dp,
    textSize: Float,
    isFavorite: Boolean = false,
    onclick: (state: Boolean) -> Boolean,
) {
    var favState by remember {
        mutableStateOf(isFavorite)
    }

    var transition = updateTransition(targetState = favState, label = "Favorite Transition")

    val buttonWidth by transition.animateDp(label = "Favorite Button width") { state ->
        when (state){
            true -> 32.dp
            else -> width
        }
    }

    Row {
        Box(
            modifier = Modifier
                .height(height)
                .width(buttonWidth)
                .border(0.5.dp, colorDesc, RoundedCornerShape(5.dp))
                .clickable {
                           favState = onclick(favState)
                },
            contentAlignment = Alignment.Center,
        ){
            if(favState){
                Surface {
                    Icon(
                        imageVector = Icons.Outlined.Favorite,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color.LightGray
                    )
                }
            }
            else{
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = null,
                        tint = Color.LightGray,
                        modifier = Modifier
                            .padding(start = 4.dp, top = 2.dp, end = 4.dp)
                            .size(16.dp),
                    )

                    Text(
                        text = "ADD TO FAVORITE",
                        style = MaterialTheme.typography.h5.copy(fontSize = TextUnit(textSize, TextUnitType.Sp)),
                        color = colorDesc,
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun FavoriteButtonPreview() {
   FavoriteButton(
       height = 24.dp,
       width = 160.dp,
       textSize = 16f,
   ){
       !it
   }
}

