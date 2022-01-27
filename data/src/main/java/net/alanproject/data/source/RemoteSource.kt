package net.alanproject.data.source

import net.alanproject.domain.model.list.GameList

interface RemoteSource {
    suspend fun getList(page: Int, order: String, dates: String, platforms: String?): GameList
}