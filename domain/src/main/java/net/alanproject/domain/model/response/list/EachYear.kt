package net.alanproject.domain.model.response.list

data class EachYear(
    val year: Int = 0,
    val count: Int = 0,
    val nofollow: Boolean = false
)