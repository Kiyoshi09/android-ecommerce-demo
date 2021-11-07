package com.tealiumlabs.ecommercec.model

import javax.annotation.concurrent.Immutable

@Immutable
data class Outfit(
    val id: Long,
    val name: String,
    val category: OutfitCategory,
    val price: Double,
    val imageUrl: String,
    val description: String
)

val outfitList = listOf<Outfit>()