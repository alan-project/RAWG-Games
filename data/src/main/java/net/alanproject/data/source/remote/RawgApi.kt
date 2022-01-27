package net.alanproject.data.source.remote


import androidx.annotation.Nullable
import net.alanproject.data.BuildConfig
import net.alanproject.domain.model.list.GameList
import retrofit2.http.GET
import retrofit2.http.Query

interface RawgApi {
    @GET("games")
    suspend fun getList(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("page") page: Int = 1,
        @Query("ordering") order: String = "rating",//release, metacritic
        @Query("dates") dates: String = "",
        @Query("platforms") platforms: String?,
    ):GameList
}