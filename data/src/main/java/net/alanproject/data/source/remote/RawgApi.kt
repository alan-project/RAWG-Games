package net.alanproject.data.source.remote


import net.alanproject.data.BuildConfig
import net.alanproject.domain.model.list.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RawgApi {
    @GET("games")
    suspend fun getGames(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("page") page: Int?,
        @Query("ordering") order: String?, // rating, release, metacritic
        @Query("dates") dates: String?,
        @Query("platforms") platforms: String?,
    ):Response
}