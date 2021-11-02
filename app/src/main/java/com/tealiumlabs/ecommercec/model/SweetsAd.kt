package com.tealiumlabs.ecommercec.model

import com.tealiumlabs.ecommercec.data.repositories.SweetsCategory
import javax.annotation.concurrent.Immutable

@Immutable
data class SweetsAd(
   val id: Int,
   val name: String,
   val category: SweetsCategory,
   val imageUrl: String,
)

val sweetsAdList = listOf(
   SweetsAd(
      id = 11,
      name = "CakeAd1",
      category = SweetsCategory.Cakes,
      imageUrl = "https://source.unsplash.com/5K5Nc3AGF1w",
   ),
   SweetsAd(
      id = 12,
      name = "CakeAd2",
      category = SweetsCategory.Cakes,
      imageUrl = "https://source.unsplash.com/OrkEasJeY74",
   ),
   SweetsAd(
      id = 13,
      name = "CakeAd3",
      category = SweetsCategory.Cakes,
      imageUrl = "https://source.unsplash.com/V4MBq8kue3U",
   ),
   SweetsAd(
      id = 14,
      name = "CakeAd4",
      category = SweetsCategory.Cakes,
      imageUrl = "https://source.unsplash.com/pZZJwwNPy2k",
   ),
   SweetsAd(
      id = 14,
      name = "CakeAd4",
      category = SweetsCategory.Cakes,
      imageUrl = "https://source.unsplash.com/ttY5ZD2O3h8",
   ),

   SweetsAd(
      id = 21,
      name = "ChocolatesAd1",
      category = SweetsCategory.Chocolates,
      imageUrl = "https://source.unsplash.com/mGP8gyGb8zY",
   ),
   SweetsAd(
      id = 22,
      name = "ChocolatesAd2",
      category = SweetsCategory.Chocolates,
      imageUrl = "https://source.unsplash.com/X2gM-SIufpU",
   ),
   SweetsAd(
      id = 23,
      name = "ChocolatesAd3",
      category = SweetsCategory.Chocolates,
      imageUrl = "https://source.unsplash.com/HtUginYLLUc",
   ),
   SweetsAd(
      id = 24,
      name = "ChocolatesAd4",
      category = SweetsCategory.Chocolates,
      imageUrl = "https://source.unsplash.com/5HgdQjUdYpc",
   ),
   SweetsAd(
      id = 25,
      name = "ChocolatesAd5",
      category = SweetsCategory.Chocolates,
      imageUrl = "https://source.unsplash.com/dcPNZeSY3yk",
   ),
)