package net.alanproject.data.source.remote

import net.alanproject.data.source.RemoteSource
import net.alanproject.domain.model.list.GameList
import javax.inject.Inject

class RemoteSourceImpl @Inject constructor(
    private val api: RawgApi
) : RemoteSource {
    override suspend fun getList(
        page: Int,
        order: String,
        dates: String,
        platforms: String?
    ): GameList {
        return api.getList(page = page, order = order, dates = dates, platforms = platforms)
    }
}