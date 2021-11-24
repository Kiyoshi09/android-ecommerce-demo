package com.tealiumlabs.ecommercec.model

data class OutfitCampaign(
    val id: Int,
    val name: String,
    val imageUrl: String
)

val outfitCampaignList = listOf<OutfitCampaign>(

   OutfitCampaign(
       id = 311,
       name = "Home_Decor",
       imageUrl = "https://ecommerce.tealiumdemo.com/media/wysiwyg/homepage-three-column-promo-01B.png"
   ),

   OutfitCampaign(
       id = 312,
       name = "Shop_Private_Sale",
       imageUrl = "https://ecommerce.tealiumdemo.com/media/wysiwyg/homepage-three-column-promo-02.png"
   ),

   OutfitCampaign(
       id = 313,
       name = "Travel_Gear",
       imageUrl = "https://ecommerce.tealiumdemo.com/media/wysiwyg/homepage-three-column-promo-03.png"
   ),
)