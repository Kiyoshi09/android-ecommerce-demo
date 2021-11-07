package com.tealiumlabs.ecommercec.model

import com.tealiumlabs.ecommercec.data.repositories.CollectionType
import javax.annotation.concurrent.Immutable

@Immutable
data class OutfitCollection (
    val id: Long,
    val name: String,
    val outfits: List<Outfit>,
    val type: OutfitCollectionType = OutfitCollectionType.Normal
)

enum class OutfitCollectionType { Normal, Recent, Highlight }

sealed class OutfitCategory(open val title: String){
    object All: OutfitCategory(title = "   All   ")

    object Women: OutfitCategory(title = "  Women  ")
    object Men: OutfitCategory(title = "   Men   ")
    object Accessories: OutfitCategory(title = "Accessories")
    object HomeDecor: OutfitCategory(title = "Home & Decor")
    object Sale: OutfitCategory(title = "   Sale   ")

    companion object {
        fun getOutfitCategoryList(): List<OutfitCategory> {
            return listOf(
                All,
                Women,
                Men,
                Accessories,
                HomeDecor,
                Sale
            )
        }
    }
}
