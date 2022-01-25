package net.alanproject.data.source

import net.alanproject.domain.model.list.Result

interface RemoteSource {
    fun getTopList():List<Result>
}