package com.tealiumlabs.ecommercec.ui.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tealiumlabs.ecommercec.data.repositories.SweetsCategory
import com.tealiumlabs.ecommercec.data.repositories.SweetsRepository
import com.tealiumlabs.ecommercec.model.Sweets
import com.tealiumlabs.ecommercec.model.SweetsAd
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val sweetsRepository: SweetsRepository
): ViewModel() {

    private var _sweetsAdList = sweetsRepository.getSweetsAdList(SweetsCategory.All)
    val sweetsAdList: List<SweetsAd>
    get() = _sweetsAdList

    private var _sweetsList = sweetsRepository.getSweetsList(SweetsCategory.All)
    val sweetsList: List<Sweets>
    get() = _sweetsList


    init {
    }

    fun onCategorySelected(sweetsCategory: SweetsCategory) {
        _sweetsAdList = sweetsRepository.getSweetsAdList(sweetsCategory)
        _sweetsList = sweetsRepository.getSweetsList(sweetsCategory)
    }

}