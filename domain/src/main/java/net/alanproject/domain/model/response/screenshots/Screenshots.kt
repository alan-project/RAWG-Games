package net.alanproject.domain.model.response.screenshots

data class Screenshots(
    val count: Int? = 0,
    val next: Any? = Any(),
    val previous: Any? = Any(),
    val results: List<Result>? = listOf()
)