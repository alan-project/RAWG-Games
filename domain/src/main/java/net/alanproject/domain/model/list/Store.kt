package net.alanproject.domain.model.list


import com.google.gson.annotations.SerializedName

data class Store(
    val id: Int = 0,
    val name: String = "",
    val slug: String = "",
    val domain: String = "",
    @SerializedName("games_count")
    val gamesCount: Int = 0,
    @SerializedName("image_background")
    val imageBackground: String = ""
)