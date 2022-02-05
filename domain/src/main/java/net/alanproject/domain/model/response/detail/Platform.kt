package net.alanproject.domain.model.response.detail


import com.google.gson.annotations.SerializedName

data class Platform(
    val platform: Int = 0,
    val name: String = "",
    val slug: String = ""
)