package com.tealiumlabs.ecommercec.data.repositories

import com.tealiumlabs.ecommercec.model.*
import com.tealiumlabs.ecommercec.model.OutfitCategory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OutfitRepository @Inject constructor() {

    fun getOutfitList(category: OutfitCategory): List<Outfit> {

        val outfits = when (category) {
            OutfitCategory.Women -> {
                outfitList.filter { outfit -> outfit.category == OutfitCategory.Women }
            }
            OutfitCategory.Men -> {
                outfitList.filter { outift -> outift.category == OutfitCategory.Men }
            }
            OutfitCategory.Accessories -> {
                outfitList.filter { outfit -> outfit.category == OutfitCategory.Accessories }
            }
            OutfitCategory.HomeDecor -> {
                outfitList.filter { outfit -> outfit.category == OutfitCategory.HomeDecor }
            }
            OutfitCategory.Sale -> {
                outfitList.filter { outfit -> outfit.category == OutfitCategory.Sale }
            }
            else -> outfitList
        }

        return outfits
    }

    fun getOutfitNewProductList(): List<Outfit> {
        val newProductsSize = 6
        val outfits = mutableListOf<Outfit>()
        val order = outfitList.indices

        var j = 0
        for (i in order.shuffled()) {
            if (j >= newProductsSize) break

            outfits.add(outfitList[i])
            j++
        }

        return outfits
    }

    fun getOutfitAdList(category: OutfitCategory): List<OutfitAd> {

        val adSize = 5
        val outfits = mutableListOf<OutfitAd>()
        val adOrder = 0 until adSize

        when(category) {
            OutfitCategory.Women -> {
                val adList = outfitAdList.filter { outfitAd -> outfitAd.category == OutfitCategory.Women }
                for (i in adOrder.shuffled()){
                    outfits.add(adList[i])
                }
            }

            OutfitCategory.Men -> {
                val adList = outfitAdList.filter { outfitAd -> outfitAd.category == OutfitCategory.Men }
                for (i in adOrder.shuffled()){
                    outfits.add(adList[i])
                }
            }
            OutfitCategory.Accessories -> {
                val adList = outfitAdList.filter { outfitAd -> outfitAd.category == OutfitCategory.Accessories }
                for (i in adOrder.shuffled()){
                    outfits.add(adList[i])
                }
            }
            OutfitCategory.HomeDecor -> {
                val adList = outfitAdList.filter { outfitAd -> outfitAd.category == OutfitCategory.HomeDecor }
                for (i in adOrder.shuffled()){
                    outfits.add(adList[i])
                }
            }
            OutfitCategory.Sale -> {
                val adList = outfitAdList.filter { outfitAd -> outfitAd.category == OutfitCategory.Sale }
                for (i in adOrder.shuffled()){
                    outfits.add(adList[i])
                }
            }
            else -> {
                for (i in adOrder.shuffled()){
                    outfits.add(outfitAdList[i])
                }
            }
        }

        return outfits
    }

    fun getOutfitCampaign(): List<OutfitCampaign> {
        return outfitCampaignList
    }
}