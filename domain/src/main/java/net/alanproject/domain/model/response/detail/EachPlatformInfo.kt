package net.alanproject.domain.model.response.detail


import com.google.gson.annotations.SerializedName

data class EachPlatformInfo(
    val platform: PlatformXXX = PlatformXXX(),
    @SerializedName("released_at")
    val releasedAt: String = "",
    val requirements: Requirements = Requirements()
)