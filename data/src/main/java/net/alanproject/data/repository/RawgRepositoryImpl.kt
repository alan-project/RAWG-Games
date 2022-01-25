package net.alanproject.data.repository

import net.alanproject.data.source.RemoteSource
import net.alanproject.data.source.remote.RemoteSourceImpl
import net.alanproject.domain.model.list.Result
import net.alanproject.domain.repository.RawgRepository

class RawgRepositoryImpl(
    private val remoteSource: RemoteSourceImpl
):RawgRepository {
    override fun getTopList(): List<Result> {
        return remoteSource.getTopList()
    }
}