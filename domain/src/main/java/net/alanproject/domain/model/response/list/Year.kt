package net.alanproject.domain.model.response.list


data class Year(
    val from: Int = 0,
    val to: Int = 0,
    val filter: String = "",
    val decade: Int = 0,
    val years: List<EachYear> = listOf(),
    val nofollow: Boolean = false,
    val count: Int = 0
)