package net.alanproject.domain.model.response


import com.google.gson.annotations.SerializedName

data class Game(
    val id: Int = 0,
    val slug: String = "",
    val name: String = "",
    val released: String = "",
    val tba: Boolean = false,
    @SerializedName("background_image")
    val backgroundImage: String? = "",
    val rating: Double = 0.0,
    @SerializedName("rating_top")
    val ratingTop: Int = 0,
    val ratings: List<Rating> = listOf(),
    @SerializedName("ratings_count")
    val ratingsCount: Int = 0,
    @SerializedName("reviews_text_count")
    val reviewsTextCount: Int = 0,
    val added: Int = 0,
    @SerializedName("added_by_status")
    val addedByStatus: AddedByStatus = AddedByStatus(),
    val metacritic: Int = 0,
    val playtime: Int = 0,
    @SerializedName("suggestions_count")
    val suggestionsCount: Int = 0,
    val updated: String = "",
    @SerializedName("user_game")
    val userGame: Any = Any(),
    @SerializedName("reviews_count")
    val reviewsCount: Int = 0,
    @SerializedName("saturated_color")
    val saturatedColor: String = "",
    @SerializedName("dominant_color")
    val dominantColor: String = "",
    val platforms: List<EachPlatform> = listOf(),
    val genres: List<Genre> = listOf(),
    val stores: List<EachStore> = listOf(),
    val clip: Any = Any(),
    val tags: List<Tag> = listOf(),
    @SerializedName("esrb_rating")
    val esrbRating: EsrbRating = EsrbRating(),
    @SerializedName("short_screenshots")
    val shortScreenshots: List<ShortScreenshot> = listOf()
)