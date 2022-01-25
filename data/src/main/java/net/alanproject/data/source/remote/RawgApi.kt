package net.alanproject.data.source.remote


import net.alanproject.domain.model.list.TopList
import retrofit2.http.GET
import retrofit2.http.Query

interface RawgApi {
    @GET("/games/")
    fun getTopList(
        @Query("key")
        apiKey: String = "8c2ffdf16925419b9dc563c05ea0e7d6"
    ):TopList
}