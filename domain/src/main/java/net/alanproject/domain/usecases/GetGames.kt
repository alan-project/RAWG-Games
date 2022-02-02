package net.alanproject.domain.usecases

import net.alanproject.domain.model.list.Response
import net.alanproject.domain.util.Resource

interface GetGames {
    suspend fun get(
        page: Int? = 1,
        order: String? = "-added",
        dates: String? = null,
        platforms: String? = null,
        genres: String? = null
    ): Resource<Response>

}