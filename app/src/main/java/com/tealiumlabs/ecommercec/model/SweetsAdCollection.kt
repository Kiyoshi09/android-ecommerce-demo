package com.tealiumlabs.ecommercec.model

import javax.annotation.concurrent.Immutable

@Immutable
data class SweetsAdCollection(
    val sweetsAdList: List<SweetsAd>
)

