package com.example.network.models

import kotlinx.serialization.Serializable

@Serializable
internal data class StocksResponse(
    val finance: StocksResultResponse?
)

@Serializable
internal data class StocksResultResponse(
    val result: List<ResultItemResponse>?
)
