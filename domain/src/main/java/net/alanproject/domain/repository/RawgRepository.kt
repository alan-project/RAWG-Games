package net.alanproject.domain.repository

import net.alanproject.domain.model.list.Result

interface RawgRepository {

    fun getTopList():List<Result>
}