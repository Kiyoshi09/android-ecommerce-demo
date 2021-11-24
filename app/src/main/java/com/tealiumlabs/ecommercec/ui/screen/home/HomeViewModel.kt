package com.tealiumlabs.ecommercec.ui.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tealiumlabs.ecommercec.data.repositories.OutfitRepository
import com.tealiumlabs.ecommercec.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
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

    private val _selectedTabIndex = MutableLiveData(OutfitCategory.All.index)
    val selectedTabIndex: LiveData<Int>
    get() = _selectedTabIndex

    fun onChangeSelectedTab(selectedTabIndex: Int){
        _selectedTabIndex.value = selectedTabIndex
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
}

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