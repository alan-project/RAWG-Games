package net.alanproject.domain.repository

import net.alanproject.domain.model.list.Response

interface RawgRepository {
    suspend fun getGames(
        page: Int?,
        order: String?,
        dates: String?,
        platforms: String?
    ): Response
}