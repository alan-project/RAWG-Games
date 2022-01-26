package net.alanproject.data.repository

import net.alanproject.data.source.RemoteSource
import net.alanproject.data.source.remote.RemoteSourceImpl
import net.alanproject.domain.model.list.Result
import net.alanproject.domain.model.list.TopList
import net.alanproject.domain.repository.RawgRepository
import javax.inject.Inject

class RawgRepositoryImpl @Inject constructor(
    private val remoteSource: RemoteSourceImpl
):RawgRepository {
    override fun getTopList(): TopList {
        return remoteSource.getTopList()
    }
}