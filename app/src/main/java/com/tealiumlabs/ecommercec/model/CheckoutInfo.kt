package com.tealiumlabs.ecommercec.model

import androidx.compose.runtime.MutableState

data class CheckoutInfo(
    val billName: MutableState<String>,
    val billAddress: MutableState<String>,
    val billZip: MutableState<String>,
    val billPhone: MutableState<String>,
    val email: MutableState<String>,
    val shipName: MutableState<String>,
    val shipAddress: MutableState<String>,
    val shipZip: MutableState<String>,
    val shipPhone: MutableState<String>,
    val shipMethod: MutableState<String>,
)