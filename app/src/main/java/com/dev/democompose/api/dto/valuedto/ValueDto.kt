package com.dev.democompose.api.dto.valuedto

data class ValueDto(
    val all_transactions: List<AllTransaction>,
    val crypto_balance: CryptoBalance,
    val crypto_prices: List<CryptoPrice>,
    val your_crypto_holdings: List<YourCryptoHolding>
)