package com.dev.democompose.api

import com.dev.democompose.api.dto.emptydto.EmptyDto
import com.dev.democompose.api.dto.valuedto.ValueDto
import retrofit2.http.GET

interface CryptoApi {

    @GET("/empty-home")
    suspend fun getEmptyDetail(): EmptyDto

    @GET("/home")
    suspend fun getValueDetail(): ValueDto

}