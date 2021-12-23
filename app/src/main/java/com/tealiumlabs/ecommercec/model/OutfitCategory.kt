package com.tealiumlabs.ecommercec.model

sealed class OutfitCategory(open val title: String, open val index: Int){
    object All: OutfitCategory(title = "   All   ", index = 0)
    object Women: OutfitCategory(title = "  Women  ", index = 1)
    object Men: OutfitCategory(title = "   Men   ", index = 2)
    object Accessories: OutfitCategory(title = "Accessories", index = 3)
    object HomeDecor: OutfitCategory(title = "Home & Decor", index = 4)
    object Sale: OutfitCategory(title = "   Sale   ", index = 5)

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