package com.example.network.models

import kotlinx.serialization.Serializable

@Serializable
internal data class SummaryResponse (
    val quoteSummary: QuoteSummaryResponse
)

