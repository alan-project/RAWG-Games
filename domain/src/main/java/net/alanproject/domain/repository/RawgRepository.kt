package net.alanproject.domain.repository

import net.alanproject.domain.model.list.Result
import net.alanproject.domain.model.list.TopList

interface RawgRepository {
    fun getTopList():TopList
}