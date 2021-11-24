package com.tealiumlabs.ecommercec.model

import com.tealiumlabs.ecommercec.ui.screen.home.OutfitCategory


data class OutfitAd(
    val id: Int,
    val name: String,
    val category: OutfitCategory,
    val imageUrl: String
)

val outfitAdList = listOf<OutfitAd>(
    OutfitAd(
        id = 11,
        name = "Women Ad1",
        category = OutfitCategory.Women,
        imageUrl = "https://ecommerce.tealiumdemo.com/media/catalog/category/vip-banner.jpg",
    ),
    OutfitAd(
        id = 12,
        name = "Women Ad2",
        category = OutfitCategory.Women,
        imageUrl = "https://ecommerce.tealiumdemo.com/media/wysiwyg/slide-1.jpg",
    ),
    OutfitAd(
        id = 13,
        name = "Women Ad3",
        category = OutfitCategory.Women,
        imageUrl = "https://ecommerce.tealiumdemo.com/media/wysiwyg/slide-2.jpg",
    ),
    OutfitAd(
        id = 14,
        name = "Women Ad4",
        category = OutfitCategory.Women,
        imageUrl = "https://ecommerce.tealiumdemo.com/media/wysiwyg/slide-3.jpg",
    ),
    OutfitAd(
        id = 15,
        name = "Women Ad5",
        category = OutfitCategory.Women,
        imageUrl = "https://ecommerce.tealiumdemo.com/media/catalog/category/plp-w-newarrivals_1.jpg",
    ),
    OutfitAd(
        id = 16,
        name = "Women Ad6",
        category = OutfitCategory.Women,
        imageUrl = "https://ecommerce.tealiumdemo.com/media/catalog/category/plp-m-newarrivals.jpg",
    ),
)