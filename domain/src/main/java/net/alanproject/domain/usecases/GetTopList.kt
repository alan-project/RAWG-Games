package net.alanproject.domain.usecases

import net.alanproject.domain.model.list.Result

interface GetTopList {
    fun getTopList():List<Result>
}