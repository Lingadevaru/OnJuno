package com.dev.democompose.api.dto.valuedto

data class AllTransaction(
    val title: String,
    val txn_amount: String,
    val txn_logo: String,
    val txn_sub_amount: String,
    val txn_time: String
)