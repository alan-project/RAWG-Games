package net.alanproject.domain.model.response.detail


import com.google.gson.annotations.SerializedName
import net.alanproject.domain.model.response.list.EachPlatform
import net.alanproject.domain.model.response.list.Platform

data class EachPlatformInfo(
    val platform: PlatformXXX = PlatformXXX(),
    @SerializedName("released_at")
    val releasedAt: String = "",
    val requirements: Requirements = Requirements()
)

fun EachPlatformInfo.mapToEachPlatform(): EachPlatform = EachPlatform(
    platform = Platform(
        id = this.platform.id,
        name = this.platform.name,
        slug = this.platform.slug,
        image = this.platform.image,
        yearEnd = this.platform.yearEnd,
        yearStart = this.platform.yearStart,
        gamesCount = this.platform.gamesCount,
        imageBackground = this.platform.imageBackground
    ),
    releasedAt= releasedAt,
    requirementsEn = requirements,
    requirementsRu = requirements
)