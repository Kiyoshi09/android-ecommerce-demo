package com.tealiumlabs.ecommercec.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tealiumlabs.ecommercec.data.repositories.OutfitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EcommViewModel @Inject constructor(
    outfitRepository: OutfitRepository
): ViewModel() {

    private var _outfitAdList = outfitRepository.getOutfitAdList(OutfitCategory.All)
    val outfitAdList: List<OutfitAd>
    get() = _outfitAdList

    private var _outfitList = outfitRepository.getOutfitList(OutfitCategory.All)
    private val outfitList: List<Outfit>
        get() = _outfitList

    private var _outfitWomenList = outfitRepository.getOutfitList(OutfitCategory.Women)
    val outfitWomenList: List<Outfit>
        get() = _outfitWomenList

    private var _outfitMenList = outfitRepository.getOutfitList(OutfitCategory.Men)
    val outfitMenList: List<Outfit>
        get() = _outfitMenList

    private var _outfitCampaignList = outfitRepository.getOutfitCampaign()
    val outfitCampaignList: List<OutfitCampaign>
    get() = _outfitCampaignList

    private var _outfitNewProductList = outfitRepository.getOutfitNewProductList()
    val outfitNewProductList: List<Outfit>
        get() = _outfitNewProductList

//    private val _selectedTabIndex = MutableLiveData(OutfitCategory.All.index)
//    val selectedTabIndex: LiveData<Int>
//    get() = _selectedTabIndex
    var selectedTabIndex = mutableStateOf(OutfitCategory.All.index)

    fun onChangeSelectedTab(tabIndex: Int){
        selectedTabIndex.value = tabIndex
    }
    fun getSearchResults(query: String): List<Outfit> {
        val filteredOutfitList = mutableListOf<Outfit>()

        if(query.isNotEmpty()){
            outfitList.forEach { outfit ->
                if(outfit.name.contains(query, ignoreCase = true) || outfit.description.contains(query, ignoreCase = true)) {
                    filteredOutfitList.add(outfit)
                }
            }
        }

        return filteredOutfitList
    }

    val favoriteOutfitList = mutableStateListOf(outfitList[0], outfitList[2]) // set default values for example

    fun removeItemFromFavoriteOutfitList(outfit: Outfit) {
        favoriteOutfitList.remove(outfit)
    }

    val searchedKeywords = mutableStateListOf("sweater","shirt")

    fun updateSearchKeywords(keyword: String) {

        if(!searchedKeywords.contains(keyword)) {
            if (searchedKeywords.size >= 8) {
                searchedKeywords.removeAt(0)
                searchedKeywords.add(keyword)
            }
            else {
                searchedKeywords.add(keyword)
            }
        }
    }

    fun getOutfit(id: Long?): Outfit? {

        return if(id == null) {
            null
        }
        else {
            var i = 0
            run loop@{
                outfitList.forEach {
                    if(id == it.id) {
                        return@loop
                    }
                    i++
                }
            }
            outfitList[i]
        }
    }

    val cartAddedOutfitList = mutableStateListOf<OutfitInCart>()

    fun cartAddedItemsTotalQty(): Int {
        var total = 0

        cartAddedOutfitList.forEach { cartAddedOutfit ->
            total += cartAddedOutfit.quantity
        }

        return total
    }

    fun removeFromCart(outfitInCart: OutfitInCart) {
        cartAddedOutfitList.remove(outfitInCart)
    }

    fun orderTotal(): MutableState<Double> {
        val total = mutableStateOf(0.0)
        cartAddedOutfitList.forEach { outfitInCart ->
           total.value += (outfitInCart.quantity * outfitInCart.outfit.price)
        }
        return total
    }

    var emailAddress = mutableStateOf("")
}