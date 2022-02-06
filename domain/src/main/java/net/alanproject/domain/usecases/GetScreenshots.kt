package net.alanproject.domain.usecases


import net.alanproject.domain.model.response.screenshots.Screenshots
import net.alanproject.domain.util.Resource

interface GetScreenshots {
    suspend fun get(
        id: Int
    ): Resource<Screenshots>

}