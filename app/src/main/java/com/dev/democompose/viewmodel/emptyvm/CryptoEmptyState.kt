package com.dev.democompose.viewmodel.emptyvm

import com.dev.democompose.api.dto.emptydto.EmptyDto

data class CryptoEmptyState(
    val isLoading: Boolean = false,
    val cryptoEmpty: EmptyDto? = null,
    val error: String = ""

)
