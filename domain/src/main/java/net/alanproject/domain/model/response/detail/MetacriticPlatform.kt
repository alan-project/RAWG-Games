package net.alanproject.domain.model.response.detail


import com.google.gson.annotations.SerializedName

data class MetacriticPlatform(
    val metascore: Int = 0,
    val url: String = "",
    val platform: Platform = Platform()
)