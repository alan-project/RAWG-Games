package net.alanproject.data.source

import net.alanproject.domain.model.list.Result
import net.alanproject.domain.model.list.TopList

interface RemoteSource {
    fun getTopList():TopList
}