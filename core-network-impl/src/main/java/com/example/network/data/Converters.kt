package com.example.network.data

import com.example.core.data.Snippet
import com.example.network.models.StocksResponse

internal fun StocksResponse.toSnippetList(): List<Snippet> {
    val list = mutableListOf<Snippet>()
    finance?.result?.first()?.quotes?.forEach { stock ->
        list += Snippet(
            ticketName = stock.symbol,
            companyName = stock.shortName,
            logoUrl = stock.logoUrl,
            currency = stock.currency,
            currentPrice = "$${stock.regularMarketPrice.fmt}",
            dailyChange = getChangeStringWithCurrency(
                stock.regularMarketChange.fmt,
                stock.regularMarketChangePercent.fmt
            ),
            dailyChangeRaw = stock.regularMarketChange.raw,
            isFavorite = false
        )
    }
    return list
}

private fun getChangeStringWithCurrency(change: String, changePercent: String): String {
    return if (change.first() != '-') {
        "$$change ($changePercent)"
    } else {
        val changeWithCurrency = change.replace("-", "-$")
        "$changeWithCurrency ($changePercent)"
    }
}