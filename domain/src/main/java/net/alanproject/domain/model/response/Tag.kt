package net.alanproject.domain.model.response


import com.google.gson.annotations.SerializedName

data class Tag(
    val id: Int = 0,
    val name: String = "",
    val slug: String = "",
    val language: String = "",
    @SerializedName("games_count")
    val gamesCount: Int = 0,
    @SerializedName("image_background")
    val imageBackground: String = ""
)