package com.example.network.models

@kotlinx.serialization.Serializable
internal data class QuoteSummaryResponse (
    val result: List<SummaryResultResponse>
)