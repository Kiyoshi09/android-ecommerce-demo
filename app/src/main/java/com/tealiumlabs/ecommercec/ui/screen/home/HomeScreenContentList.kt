package com.tealiumlabs.ecommercec.ui.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.tealiumlabs.ecommercec.R
import com.tealiumlabs.ecommercec.model.Outfit
import com.tealiumlabs.ecommercec.ui.theme.EcommTypography
import com.tealiumlabs.ecommercec.ui.theme.*

@Composable
fun HomeScreenContentList(
    outfitList: List<Outfit>
) {

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        item {
            Spacer(modifier = Modifier.height(10.dp))
        }

        itemsIndexed(outfitList) { _, outfit ->
            Card(
                border = BorderStroke(width = 0.1.dp, color = Color.LightGray),
                elevation = 2.dp,
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 2.dp, bottom = 2.dp)
                    .clickable { }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .padding(4.dp),
                    ) {
                        Image(
                            painter = rememberImagePainter(
                                data = outfit.imageUrl_s,
                                builder = {
                                    crossfade(true)
                                    placeholder(drawableResId = R.drawable.plate_placeholder)
                                }
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .width(84.dp)
                                .height(84.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop,
                        )
                    }

                    Box(
                        modifier = Modifier.padding(start = 16.dp)
                    ) {
                        Column {
                           Row {
                               Box(
                                   modifier = Modifier
                                       .weight(2f),
                                   Alignment.CenterStart
                               ) {
                                   Text(
                                       text = outfit.name,
                                       style = EcommTypography.h5.copy(
                                           fontSize = 14.sp
                                       ),
                                       softWrap = true
                                   )
                               }

                               Box(
                                   modifier = Modifier
                                       .padding(end = 8.dp)
                                       .weight(1f),
                                   Alignment.CenterEnd
                               ) {
                                   Text(
                                       text = "$ ${outfit.price}",
                                       style = EcommTypography.h5.copy(
                                           fontSize = 12.sp,
                                           color = colorPrice,
                                       ),
                                       softWrap = true,
                                       textAlign = TextAlign.End,
                                   )
                               }
                           }

                           Row {
                              Box(
                                  modifier = Modifier
                                      .padding(top = 8.dp)
                                      .weight(2f),
                              ) {
                                  Text(
                                      text = outfit.description,
                                      style = EcommTypography.h5.copy(
                                          color = colorDesc,
                                          fontSize = 12.sp
                                      ),
                                      maxLines = 2,
                                      overflow = TextOverflow.Ellipsis,
                                  )
                              }
                              Box(
                                  modifier = Modifier
                                      .weight(1f)
                              ) {

                              }
                           }

                           Row {
                               Box(
                                   modifier = Modifier
                                       .weight(2f),
                               ) {
                                   Text(
                                       text = "Learn More",
                                       style = EcommTypography.h5.copy(
                                           color = colorPrice,
                                           fontSize = 12.sp
                                       ),
                                   )
                               }
                               Box(
                                   modifier = Modifier
                                       .weight(1f),
                                   Alignment.BottomEnd
                               ) {
                                    IconButton(
                                        onClick = {}
                                    ) {
                                        Icon(
                                            imageVector = Icons.Outlined.FavoriteBorder,
                                            contentDescription = null,
                                            modifier = Modifier.size(16.dp),
                                            tint = Color.LightGray
                                        )
                                    }
                               }
                           }
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(70.dp))
        }

    }
}