package com.example.impl.data

import com.example.core.data.Snippet
import com.example.impl.room.entitiy.StockModel

internal fun Snippet.toStockModel(): StockModel = StockModel(
    ticket = ticketName,
    companyName = companyName,
    logoUrl = logoUrl,
    currency = currency,
    lastSavedPrice = currentPrice,
    savedDailyChange = dailyChange,
    savedDailyChangeRaw = dailyChangeRaw
)