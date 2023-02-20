package com.example.impl.room.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.data.Snippet

@Entity(tableName = "stocks")
data class StockModel(
    @PrimaryKey
    @ColumnInfo(name = "ticket")
    val ticket: String,
    @ColumnInfo(name = "company_name")
    val companyName: String,
    @ColumnInfo(name = "logo_url")
    val logoUrl: String?,
    @ColumnInfo(name = "currency")
    val currency: String,
    @ColumnInfo(name = "last_saved_price")
    val lastSavedPrice: String,
    @ColumnInfo(name = "daily_change")
    val savedDailyChange: String,
    @ColumnInfo(name = "daily_change_row")
    val savedDailyChangeRaw: Float
) {
    fun toSnippet() = Snippet (
        ticketName = ticket,
        companyName = companyName,
        logoUrl = logoUrl,
        currency = currency,
        currentPrice = lastSavedPrice,
        dailyChange = savedDailyChange,
        dailyChangeRaw = savedDailyChangeRaw,
        isFavorite = true
    )
}
