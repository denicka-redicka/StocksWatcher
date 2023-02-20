package com.example.network.data

import com.example.core.data.Snippet
import kotlinx.coroutines.*
import javax.inject.Inject

private const val TYPE_LOGO = "logo"
private const val TYPE_SYMBOL = "symbol"
private const val TYPE_ICON = "icon"

internal class StocksRemoteDataSourceImpl @Inject constructor(
    private val api: StocksService,
    private val logoApi: LogoService
) : StocksRemoteDataSourceApi<List<@JvmSuppressWildcards Snippet>> {
    override suspend fun getStocksList(): List<Snippet> = withContext(Dispatchers.IO) {
        val response = api.getStocksInfo()
        supervisorScope {
            response.finance?.result?.first()?.quotes?.forEach { stocksInfo ->
                launch {
                    val webSite =
                        api.getSummary(stocksInfo.symbol).quoteSummary.result.first().summaryProfile.website
                    val logos = logoApi.getBrandInfo(webSite.substring(8)).pageProps?.data?.logos
                    val types = logos?.map {
                        it.type
                    }
                    val index = if (types != null) {
                        when {
                            types.contains(TYPE_ICON) -> types.indexOf(TYPE_ICON)
                            types.contains(TYPE_SYMBOL) -> types.indexOf(TYPE_SYMBOL)
                            types.contains(TYPE_LOGO) -> types.indexOf(TYPE_LOGO)
                            else -> -1
                        }
                    } else -1
                    if (!logos.isNullOrEmpty())
                        stocksInfo.logoUrl =
                            logos[index].formats.first { it.format == "png" || it.format == "jpeg" }.src
                }
            }
        }
        response.toSnippetList()
    }
}