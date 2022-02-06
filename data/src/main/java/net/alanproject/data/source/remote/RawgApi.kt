package net.alanproject.data.source.remote


import net.alanproject.data.BuildConfig
import net.alanproject.domain.model.response.detail.GameDetail
import net.alanproject.domain.model.response.list.Response
import net.alanproject.domain.model.response.screenshots.Screenshots
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RawgApi {
    @GET("games")
    suspend fun getGames(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("page") page: Int?,
        @Query("ordering") order: String?, // rating, release, metacritic
        @Query("dates") dates: String?,
        @Query("platforms") platforms: String?,
        @Query("genres") genres: String?,
    ): Response

    @GET("games/{id}")
    suspend fun getGame(
        @Path("id") id: Int,
        @Query("key") key: String = BuildConfig.API_KEY
    ): GameDetail

    @GET("games/{id}/screenshots")
    suspend fun getScreenshots(
        @Path("id") id: Int,
        @Query("key") key: String = BuildConfig.API_KEY
    ): Screenshots
}