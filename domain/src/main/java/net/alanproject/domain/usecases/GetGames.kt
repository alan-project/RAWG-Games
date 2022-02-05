package net.alanproject.domain.usecases

import net.alanproject.domain.model.params.ListParams
import net.alanproject.domain.model.response.list.Response
import net.alanproject.domain.util.Resource

interface GetGames {
    suspend fun get(
        page: Int? = 1,
        params: ListParams
    ): Resource<Response>

}