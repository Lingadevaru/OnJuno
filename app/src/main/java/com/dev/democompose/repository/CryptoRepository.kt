package com.dev.democompose.repository

import com.dev.democompose.api.CryptoApi
import com.dev.democompose.api.dto.emptydto.EmptyDto
import com.dev.democompose.api.dto.valuedto.ValueDto
import javax.inject.Inject

class CryptoRepository @Inject constructor(
    private val api: CryptoApi
) {
    suspend fun getEmpty(): EmptyDto{
        return api.getEmptyDetail()
    }

    suspend fun getValue(): ValueDto{
        return api.getValueDetail()
    }
}