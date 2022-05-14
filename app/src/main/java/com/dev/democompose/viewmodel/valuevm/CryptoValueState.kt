package com.dev.democompose.viewmodel.valuevm

import com.dev.democompose.api.dto.valuedto.ValueDto

data class CryptoValueState(
    val isLoading: Boolean = false,
    val cryptoValue: ValueDto? = null,
    val error: String = ""

)
