package net.alanproject.domain.repository

import net.alanproject.domain.model.list.GameList

interface RawgRepository {
    suspend fun getList(
        page: Int,
        order: String,
        dates: String,
        platforms: String?
    ): GameList
}