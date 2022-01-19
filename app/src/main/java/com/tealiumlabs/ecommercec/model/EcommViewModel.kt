package com.tealiumlabs.ecommercec.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tealiumlabs.ecommercec.data.repositories.DataStoreRepository
import com.tealiumlabs.ecommercec.data.repositories.OutfitRepository
import com.tealiumlabs.ecommercec.utils.Constants.CONSENTED
import com.tealiumlabs.ecommercec.utils.Constants.DEFAULT_SEARCH_KEYWORD1
import com.tealiumlabs.ecommercec.utils.Constants.DEFAULT_SEARCH_KEYWORD2
import com.tealiumlabs.ecommercec.utils.Constants.NOT_CONSENTED
import com.tealiumlabs.ecommercec.utils.Constants.UNKNOWN_CONSENTED
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

    val searchedKeywords = mutableStateListOf(DEFAULT_SEARCH_KEYWORD1, DEFAULT_SEARCH_KEYWORD2)
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
    var traceId = mutableStateOf("")

    val isOptIn = mutableStateOf(UNKNOWN_CONSENTED)
    val consentAnalytics = mutableStateOf(UNKNOWN_CONSENTED)
    val consentAffiliate = mutableStateOf(UNKNOWN_CONSENTED)
    val consentDisplayAd = mutableStateOf(UNKNOWN_CONSENTED)
    val consentSearch = mutableStateOf(UNKNOWN_CONSENTED)
    val consentEmail = mutableStateOf(UNKNOWN_CONSENTED)
    val consentPersonalization = mutableStateOf(UNKNOWN_CONSENTED)
    val consentSocial = mutableStateOf(UNKNOWN_CONSENTED)
    val consentBigData = mutableStateOf(UNKNOWN_CONSENTED)
    val consentMisc = mutableStateOf(UNKNOWN_CONSENTED)
    val consentCookieMatch = mutableStateOf(UNKNOWN_CONSENTED)
    val consentCDP = mutableStateOf(UNKNOWN_CONSENTED)
    val consentMobile = mutableStateOf(UNKNOWN_CONSENTED)
    val consentEngagement = mutableStateOf(UNKNOWN_CONSENTED)
    val consentMonitoring = mutableStateOf(UNKNOWN_CONSENTED)
    val consentCRM = mutableStateOf(UNKNOWN_CONSENTED)

    fun updateConsentParameters(consent: Int, categories: List<String>) {
        viewModelScope.launch(Dispatchers.IO) {

            if (consent == CONSENTED) {
                isOptIn.value = CONSENTED

                consentAnalytics.value = NOT_CONSENTED
                consentAffiliate.value = NOT_CONSENTED
                consentDisplayAd.value = NOT_CONSENTED
                consentSearch.value = NOT_CONSENTED
                consentEmail.value = NOT_CONSENTED
                consentPersonalization.value = NOT_CONSENTED
                consentSocial.value = NOT_CONSENTED
                consentBigData.value = NOT_CONSENTED
                consentMisc.value = NOT_CONSENTED
                consentCookieMatch.value = NOT_CONSENTED
                consentCDP.value = NOT_CONSENTED
                consentMobile.value = NOT_CONSENTED
                consentEngagement.value = NOT_CONSENTED
                consentMonitoring.value = NOT_CONSENTED
                consentCRM.value = NOT_CONSENTED

                categories.forEach { category ->
                    when(category) {
                        "analytics" -> {
                            consentAnalytics.value = CONSENTED
                        }
                        "affiliates" -> {
                            consentAffiliate.value = CONSENTED
                        }
                        "display_ads" -> {
                            consentDisplayAd.value = CONSENTED
                        }
                        "search" -> {
                            consentSearch.value = CONSENTED
                        }
                        "email" -> {
                            consentEmail.value = CONSENTED
                        }
                        "personalization" -> {
                            consentPersonalization.value = CONSENTED
                        }
                        "social" -> {
                            consentSocial.value = CONSENTED
                        }
                        "big_data" -> {
                            consentBigData.value = CONSENTED
                        }
                        "misc" -> {
                            consentMisc.value = CONSENTED
                        }
                        "cookiematch" -> {
                            consentCookieMatch.value = CONSENTED
                        }
                        "cdp" -> {
                            consentCDP.value = CONSENTED
                        }
                        "mobile" -> {
                            consentMobile.value = CONSENTED
                        }
                        "engagement" -> {
                            consentEngagement.value = CONSENTED
                        }
                        "monitoring" -> {
                            consentMonitoring.value = CONSENTED
                        }
                        "crm" -> {
                            consentCRM.value = CONSENTED
                        }
                    }
                }
            } else if (consent == NOT_CONSENTED) {
                isOptIn.value = NOT_CONSENTED

                consentAnalytics.value = UNKNOWN_CONSENTED
                consentAffiliate.value = UNKNOWN_CONSENTED
                consentDisplayAd.value = UNKNOWN_CONSENTED
                consentSearch.value = UNKNOWN_CONSENTED
                consentEmail.value = UNKNOWN_CONSENTED
                consentPersonalization.value = UNKNOWN_CONSENTED
                consentSocial.value = UNKNOWN_CONSENTED
                consentBigData.value = UNKNOWN_CONSENTED
                consentMisc.value = UNKNOWN_CONSENTED
                consentCookieMatch.value = UNKNOWN_CONSENTED
                consentCDP.value = UNKNOWN_CONSENTED
                consentMobile.value = UNKNOWN_CONSENTED
                consentEngagement.value = UNKNOWN_CONSENTED
                consentMonitoring.value = UNKNOWN_CONSENTED
                consentCRM.value = UNKNOWN_CONSENTED
            }
        }
    }
}