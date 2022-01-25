package net.alanproject.domain.usecases.impl

import net.alanproject.domain.model.list.Result
import net.alanproject.domain.repository.RawgRepository
import net.alanproject.domain.usecases.GetTopList

class GetTopListUsecase(
    private val repository: RawgRepository
):GetTopList {
    override fun getTopList(): List<Result> {
        return repository.getTopList()
    }
}