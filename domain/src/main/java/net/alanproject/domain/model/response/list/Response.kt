package net.alanproject.domain.model.response.list


import com.google.gson.annotations.SerializedName

data class Response(
    val count: Int = 0,
    val next: String = "",
    val previous: Any = Any(),
    val results: List<Game> = listOf(),
    @SerializedName("seo_title")
    val seoTitle: String = "",
    @SerializedName("seo_description")
    val seoDescription: String = "",
    @SerializedName("seo_keywords")
    val seoKeywords: String = "",
    @SerializedName("seo_h1")
    val seoH1: String = "",
    val noindex: Boolean = false,
    val nofollow: Boolean = false,
    val description: String = "",
    val filters: Filters = Filters(),
    @SerializedName("nofollow_collections")
    val nofollowCollections: List<String> = listOf()
)