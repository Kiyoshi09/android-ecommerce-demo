package com.tealiumlabs.ecommercec.model

data class OutfitCampaign(
    val id: Int,
    val name: String,
    val imageUrl: String
)

val outfitCampaignList = listOf<OutfitCampaign>(
   OutfitCampaign(
       id = 301,
       name = "Sale",
       imageUrl = "https://www.kiyotaro.cloud/images/camp1_sale.png"
   ),
   OutfitCampaign(
       id = 302,
       name = "Coupon",
       imageUrl = "https://www.kiyotaro.cloud/images/camp2_coupon.jpg"
   ),
   OutfitCampaign(
       id = 303,
       name = "Category",
       imageUrl = "https://www.kiyotaro.cloud/images/camp3_category.jpg"
   ),
   OutfitCampaign(
       id = 304,
       name = "Other",
       imageUrl = "https://www.kiyotaro.cloud/images/camp4_glasses.jpg"
   ),
)