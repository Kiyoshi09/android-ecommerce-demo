package com.tealiumlabs.ecommercec.ui.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tealiumlabs.ecommercec.data.repositories.OutfitRepository
import com.tealiumlabs.ecommercec.data.repositories.SweetsCategory
import com.tealiumlabs.ecommercec.data.repositories.SweetsRepository
import com.tealiumlabs.ecommercec.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val sweetsRepository: SweetsRepository,
    private val outfitRepository: OutfitRepository
): ViewModel() {

    private var _sweetsAdList = sweetsRepository.getSweetsAdList(SweetsCategory.All)
    val sweetsAdList: List<SweetsAd>
    get() = _sweetsAdList

    private var _sweetsList = sweetsRepository.getSweetsList(SweetsCategory.All)
    val sweetsList: List<Sweets>
    get() = _sweetsList


    private var _outfitAdList = outfitRepository.getOutfitAdList(OutfitCategory.All)
    val outfitAdList: List<OutfitAd>
    get() = _outfitAdList

    private var _outfitList = outfitRepository.getOutfitList(OutfitCategory.All)
    val outfitList: List<Outfit>
    get() = _outfitList

    private var _outfitCampaignList = outfitRepository.getOutfitCampaign()
    val outfitCampaignList: List<OutfitCampaign>
    get() = _outfitCampaignList


    fun onCategorySelected(sweetsCategory: SweetsCategory) {
        _sweetsAdList = sweetsRepository.getSweetsAdList(sweetsCategory)
        _sweetsList = sweetsRepository.getSweetsList(sweetsCategory)
    }



}