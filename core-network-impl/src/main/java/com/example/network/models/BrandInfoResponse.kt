package com.example.network.models

import kotlinx.serialization.Serializable

@Serializable
data class BrandInfoResponse(
    val pageProps: PagePropsResponse?
)

@Serializable
data class PagePropsResponse(
    val data: BrandData?
)

@Serializable
data class BrandData(
    val name: String?,
    val logos: List<LogoResponse>
)

@Serializable
data class LogoResponse(
    val type: String,
    val formats: List<LogoFormat>
)

@Serializable
data class LogoFormat(
    val src: String,
    val format: String
)