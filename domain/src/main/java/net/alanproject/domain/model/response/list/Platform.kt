package net.alanproject.domain.model.response.list


import com.google.gson.annotations.SerializedName

data class Platform(
    val id: Int = 0,
    val name: String = "",
    val slug: String = "",
    val image: Any? = Any(),
    @SerializedName("year_end")
    val yearEnd: Any? = Any(),
    @SerializedName("year_start")
    val yearStart: Any? = Any(),
    @SerializedName("games_count")
    val gamesCount: Int? = 0,
    @SerializedName("image_background")
    val imageBackground: String = ""
)