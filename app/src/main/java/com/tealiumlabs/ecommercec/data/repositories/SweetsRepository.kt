package com.tealiumlabs.ecommercec.data.repositories

import com.tealiumlabs.ecommercec.model.Sweets
import com.tealiumlabs.ecommercec.model.SweetsAd
import com.tealiumlabs.ecommercec.model.sweetsAdList
import com.tealiumlabs.ecommercec.model.sweetsList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SweetsRepository @Inject constructor() {

    fun getSweetsList(category: SweetsCategory): List<Sweets> {

        val aSweetsList = when (category) {
            SweetsCategory.Cakes -> {
                sweetsList.filter {sweets ->  sweets.category == SweetsCategory.Cakes}
            }
            SweetsCategory.Chocolates -> {
                sweetsList.filter {sweets ->  sweets.category == SweetsCategory.Chocolates}
            }
            SweetsCategory.CoffeeBeans -> {
                sweetsList.filter {sweets ->  sweets.category == SweetsCategory.CoffeeBeans}
            }
            SweetsCategory.Macaroons -> {
                sweetsList.filter {sweets ->  sweets.category == SweetsCategory.Macaroons}
            }
            SweetsCategory.Cookies -> {
                sweetsList.filter {sweets ->  sweets.category == SweetsCategory.Cookies}
            }
            else -> sweetsList
        }

        return aSweetsList
    }

    fun getSweetsAdList(category: SweetsCategory): List<SweetsAd> {

       val adSize = 5
       val aSweetsAdList = mutableListOf<SweetsAd>()

       when(category) {
           SweetsCategory.Cakes -> {
               val cakeAdList = sweetsAdList.filter { sweetsAd -> sweetsAd.category == SweetsCategory.Cakes }
               val rnd = (cakeAdList.indices).random()
               var j = rnd % adSize
               for (i in 0 until adSize){
                   aSweetsAdList.add(cakeAdList[j])
               }
           }

           SweetsCategory.Chocolates -> {
               val chocoAdList = sweetsAdList.filter { sweetsAd -> sweetsAd.category == SweetsCategory.Chocolates }
               val rnd = (chocoAdList.indices).random()
               var j = rnd % adSize
               for (i in 0 until adSize){
                   aSweetsAdList.add(chocoAdList[j])
               }
           }
           SweetsCategory.CoffeeBeans -> {
               val coffeeAdList = sweetsAdList.filter { sweetsAd -> sweetsAd.category == SweetsCategory.CoffeeBeans }
               val rnd = (coffeeAdList.indices).random()
               var j = rnd % adSize
               for (i in 0 until adSize){
                   aSweetsAdList.add(coffeeAdList[j])
               }
           }
           SweetsCategory.Macaroons -> {
               val macAdList = sweetsAdList.filter { sweetsAd -> sweetsAd.category == SweetsCategory.Macaroons }
               val rnd = (macAdList.indices).random()
               var j = rnd % adSize
               for (i in 0 until adSize){
                   aSweetsAdList.add(macAdList[j])
               }
           }
           SweetsCategory.Cookies -> {
               val cookieAdList = sweetsAdList.filter { sweetsAd -> sweetsAd.category == SweetsCategory.Cookies }
               val rnd = (cookieAdList.indices).random()
               var j = rnd % adSize
               for (i in 0 until adSize){
                   aSweetsAdList.add(cookieAdList[j])
               }
           }
           else -> {
               val rnd = (sweetsAdList.indices).random()
               var j = rnd % adSize
               for (i in 0 until adSize){
                   aSweetsAdList.add(sweetsAdList[j++])
               }
           }
       }

       return aSweetsAdList
    }
}