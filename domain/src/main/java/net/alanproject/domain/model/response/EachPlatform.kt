package net.alanproject.domain.model.response


import com.google.gson.annotations.SerializedName

data class EachPlatform(
    val platform: Platform = Platform(),
    @SerializedName("released_at")
    val releasedAt: String = "",
    @SerializedName("requirements_en")
    val requirementsEn: Any = Any(),
    @SerializedName("requirements_ru")
    val requirementsRu: Any = Any()
)