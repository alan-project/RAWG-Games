package net.alanproject.data.source.remote

import net.alanproject.data.source.RemoteSource
import net.alanproject.domain.model.list.Result
import net.alanproject.domain.model.list.TopList
import javax.inject.Inject

class RemoteSourceImpl @Inject constructor(
    private val api:RawgApi
):RemoteSource {
    override suspend fun getTopList(): TopList {
        RetrofitInstance.api.getTopList()
        return api.getTopList()
    }

}