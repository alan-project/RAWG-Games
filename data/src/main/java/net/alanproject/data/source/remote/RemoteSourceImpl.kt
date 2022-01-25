package net.alanproject.data.source.remote

import net.alanproject.data.source.RemoteSource
import net.alanproject.domain.model.list.Result

class RemoteSourceImpl(
    private val api:RawgApi
):RemoteSource {
    override fun getTopList(): List<Result> {
        return api.getTopList().results
    }

}