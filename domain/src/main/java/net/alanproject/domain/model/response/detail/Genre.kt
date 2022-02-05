package net.alanproject.domain.model.response.detail


import com.google.gson.annotations.SerializedName

data class Genre(
    val id: Int = 0,
    val name: String = "",
    val slug: String = "",
    @SerializedName("games_count")
    val gamesCount: Int = 0,
    @SerializedName("image_background")
    val imageBackground: String = ""
)