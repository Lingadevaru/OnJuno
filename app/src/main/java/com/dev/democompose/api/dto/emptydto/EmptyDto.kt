package com.dev.democompose.api.dto.emptydto

data class EmptyDto(
    val all_transactions: List<Any>,
    val crypto_balance: CryptoBalance,
    val crypto_prices: List<CryptoPrice>,
    val your_crypto_holdings: List<YourCryptoHolding>
)