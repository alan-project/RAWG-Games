package net.alanproject.data.source.remote

import net.alanproject.data.source.RemoteSource
import net.alanproject.domain.model.response.detail.GameDetail
import net.alanproject.domain.model.response.list.Response
import timber.log.Timber
import javax.inject.Inject

class RemoteSourceImpl @Inject constructor(
    private val api: RawgApi
) : RemoteSource {
    override suspend fun getGames(
        page: Int?,
        order: String?,
        dates: String?,
        platforms: String?,
        genres:String?
    ): Response {

//        Timber.d("RemoteSourceImpl: page:$page, order:$order, dates:$dates, eachPlatforms:$platforms")
        return api.getGames(page = page, order = order, dates = dates, platforms = platforms, genres = genres)
    }

    override suspend fun getGame(id: Int): GameDetail {
        return api.getGame(id = id)
    }
}