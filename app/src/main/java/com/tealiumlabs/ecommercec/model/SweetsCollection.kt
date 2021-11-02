package com.tealiumlabs.ecommercec.data.repositories

import com.tealiumlabs.ecommercec.model.Sweets
import javax.annotation.concurrent.Immutable

@Immutable
data class SweetsCollection(
    val id: Long,
    val name: String,
    val sweetsList: List<Sweets>,
    val type: CollectionType = CollectionType.Normal,
)

enum class CollectionType { Normal, Recent, Highlight }

sealed class SweetsCategory(open val title: String){
    object All: SweetsCategory(title = "   All   ")

    object Cakes: SweetsCategory(title = "  Cakes  ")
    object Chocolates: SweetsCategory(title = "Chocolates")
    object CoffeeBeans: SweetsCategory(title = "Coffee Beans")
    object Macaroons: SweetsCategory(title = "Macaroons")
    object Cookies: SweetsCategory(title = " Cookies ")

    companion object {
        fun getSweetsCategoryList(): List<SweetsCategory> {
            return listOf(
                All,
                Cakes,
                Chocolates,
                CoffeeBeans,
                Macaroons,
                Cookies
            )
        }
    }
}

