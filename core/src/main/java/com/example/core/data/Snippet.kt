package com.example.core.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Snippet(
    val companyName: String,
    val ticketName: String,
    val logoUrl: String?,
    val currency: String,
    val currentPrice: String,
    val dailyChange: String,
    val dailyChangeRaw: Float,
    var isFavorite: Boolean
): Parcelable