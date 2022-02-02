package net.alanproject.domain.repository

import net.alanproject.domain.model.list.Game
import net.alanproject.domain.model.list.Response

interface RawgRepository {
    suspend fun getGames(
        page: Int?,
        order: String?,
        dates: String?,
        platforms: String?,
        genres: String?
    ): Response

    suspend fun getGame(
        id: Int
    ): Game
}