package com.tealiumlabs.ecommercec.model

data class OutfitCampaign(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val category: OutfitCategory,
)

val outfitCampaignList = listOf(

    OutfitCampaign(
        id = 311,
        name = "Home_Decor",
        imageUrl = "https://ecommerce.tealiumdemo.com/media/wysiwyg/homepage-three-column-promo-01B.png",
        category = OutfitCategory.HomeDecor
    ),

    OutfitCampaign(
        id = 312,
        name = "Shop_Private_Sale",
        imageUrl = "https://ecommerce.tealiumdemo.com/media/wysiwyg/homepage-three-column-promo-02.png",
        category = OutfitCategory.Women
    ),

    OutfitCampaign(
        id = 313,
        name = "Travel_Gear",
        imageUrl = "https://ecommerce.tealiumdemo.com/media/wysiwyg/homepage-three-column-promo-03.png",
        category = OutfitCategory.Accessories
    ),
)