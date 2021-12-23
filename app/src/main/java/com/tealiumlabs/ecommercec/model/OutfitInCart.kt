package com.tealiumlabs.ecommercec.model

data class OutfitInCart(
    var id: Long,
    var colorId: Int,
    var quantity: Int,
    var outfit: Outfit,
)