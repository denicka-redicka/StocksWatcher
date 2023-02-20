package com.example.network.data

import com.example.network.models.StocksResponse
import com.example.network.models.SummaryResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val defaultScrIds = "most_actives"
internal interface StocksService {
    @GET("v1/finance/screener/predefined/saved?formatted=true&lang=en-US&region=US&start=0&count=25&enableSectorIndustryLabelFix=true&corsDomain=finance.yahoo.com")
    suspend fun getStocksInfo(@Query("scrIds") srcIds: String = defaultScrIds): StocksResponse

    @GET("v10/finance/quoteSummary/{symbol}?formatted=true&crumb=PWrC4U3nvgC&lang=en-US&region=US&modules=summaryProfile%2CfinancialData%2CrecommendationTrend%2CupgradeDowngradeHistory%2Cearnings%2CdefaultKeyStatistics%2CesgScores%2Cdetails&corsDomain=finance.yahoo.com")
    suspend fun getSummary(@Path("symbol") symbol: String): SummaryResponse
}
