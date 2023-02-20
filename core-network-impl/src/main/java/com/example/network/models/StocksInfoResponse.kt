package com.example.network.models

import kotlinx.serialization.Serializable

@Serializable
internal data class ResultItemResponse(
    val quotes: List<StocksInfoResponse>
)

@Serializable
internal data class StocksInfoResponse (
    val shortName: String,
    val symbol: String,
    val region: String,
    val currency: String,
    val regularMarketPrice: MarketValues,
    val regularMarketChange: MarketValues,
    val regularMarketChangePercent: MarketValues
) {
    var logoUrl: String? = null
}

@Serializable
data class MarketValues(
    val raw: Float,
    val fmt: String
)