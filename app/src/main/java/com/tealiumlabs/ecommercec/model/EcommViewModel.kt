package com.tealiumlabs.ecommercec.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tealiumlabs.ecommercec.data.repositories.DataStoreRepository
import com.tealiumlabs.ecommercec.data.repositories.OutfitRepository
import com.tealiumlabs.ecommercec.utils.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class EcommViewModel @Inject constructor(
    outfitRepository: OutfitRepository,
    private val dataStoredRepository: DataStoreRepository,
) : ViewModel() {

    private var _outfitAdList = outfitRepository.getOutfitAdList(OutfitCategory.All)
    val outfitAdList: List<OutfitAd>
        get() = _outfitAdList

    private var _outfitList = outfitRepository.getOutfitList(OutfitCategory.All)
    val outfitList: List<Outfit>
        get() = _outfitList

    private var _outfitWomenList = outfitRepository.getOutfitList(OutfitCategory.Women)
    val outfitWomenList: List<Outfit>
        get() = _outfitWomenList

    private var _outfitMenList = outfitRepository.getOutfitList(OutfitCategory.Men)
    val outfitMenList: List<Outfit>
        get() = _outfitMenList

    private var _outfitAccessoriesList = outfitRepository.getOutfitList(OutfitCategory.Accessories)
    val outfitAccessoriesList: List<Outfit>
        get() = _outfitAccessoriesList

    private var _outfitHomeDecorList = outfitRepository.getOutfitList(OutfitCategory.HomeDecor)
    val outfitHomeDecorList: List<Outfit>
        get() = _outfitHomeDecorList

    private var _outfitSaleList = outfitRepository.getOutfitList(OutfitCategory.Sale)
    val outfitSaleList: List<Outfit>
        get() = _outfitSaleList

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
    fun onChangeSelectedTab(tabIndex: Int) {
        selectedTabIndex.value = tabIndex
    }

    fun getSearchResults(query: String): List<Outfit> {
        val filteredOutfitList = mutableListOf<Outfit>()

        if (query.isNotEmpty()) {
            outfitList.forEach { outfit ->
                if (outfit.name.contains(query, ignoreCase = true) || outfit.description.contains(
                        query,
                        ignoreCase = true
                    )
                ) {
                    filteredOutfitList.add(outfit)
                }
            }
        }

        return filteredOutfitList
    }

    val favoriteOutfitList =
        mutableStateListOf(outfitList[0], outfitList[2]) // set default values for example

    fun removeItemFromFavoriteOutfitList(outfit: Outfit) {
        favoriteOutfitList.remove(outfit)
    }

    val searchedKeywords = mutableStateListOf("sweater", "shirt")
    fun updateSearchKeywords(keyword: String) {

        if (!searchedKeywords.contains(keyword)) {
            if (searchedKeywords.size >= 8) {
                searchedKeywords.removeAt(0)
                searchedKeywords.add(keyword)
            } else {
                searchedKeywords.add(keyword)
            }
        }
    }

    fun getOutfit(id: Long?): Outfit? {

        return if (id == null) {
            null
        } else {
            var i = 0
            run loop@{
                outfitList.forEach {
                    if (id == it.id) {
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

    fun persistTealiumConfigState(tealiumConfig: String) {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoredRepository.persistTealiumConfig(config = tealiumConfig)
        }
    }

    private val _tealiumConfigState = MutableStateFlow<RequestState<String>>(RequestState.Idle)
    val tealiumConfigState: StateFlow<RequestState<String>> = _tealiumConfigState

    fun readTealiumConfigState() {
        _tealiumConfigState.value = RequestState.Loading

        try {
            viewModelScope.launch {
                dataStoredRepository.readTealiumConfig
                    .map { it }
                    .collect {
                        _tealiumConfigState.value = RequestState.Success(it)
                    }
            }
        } catch (e: Exception) {
            _tealiumConfigState.value = RequestState.Error(e)
        }
    }

    var emailAddress = mutableStateOf("")

    val isOptIn = mutableStateOf(true)
    val consentAnalytics = mutableStateOf(true)
    val consentAffiliate = mutableStateOf(true)
    val consentDisplayAd = mutableStateOf(true)
    val consentSearch = mutableStateOf(true)
    val consentEmail = mutableStateOf(true)
    val consentPersonalization = mutableStateOf(true)
    val consentSocial = mutableStateOf(true)
    val consentBigData = mutableStateOf(true)
    val consentMisc = mutableStateOf(true)
    val consentCookieMatch = mutableStateOf(true)
    val consentCDP = mutableStateOf(true)
    val consentMobile = mutableStateOf(true)
    val consentEngagement = mutableStateOf(true)
    val consentMonitoring = mutableStateOf(true)
    val consentCRM = mutableStateOf(true)
}