package net.alanproject.domain.model.response.detail


import com.google.gson.annotations.SerializedName

data class ParentPlatform(
    val platform: PlatformX = PlatformX()
)