package net.alanproject.domain.model.response.custom

import net.alanproject.domain.model.response.detail.GameDetail
import timber.log.Timber

data class Specification(
    val platforms: String = "",
    val genres: String = "",
    val developer: String = "",
    val publisher: String = "",
    val ageRating: String = "",
    val tags: String = "",
    val releaseDate: String = ""
)

fun mapToSpecification(game: GameDetail): Specification {

    val platformList: MutableList<String> = mutableListOf()
    game.platforms.forEach {
        platformList.add(it.platform.name)
    }
    Timber.d("platformList: $platformList")
    val platformsString = platformList.joinToString(", ")
    Timber.d("platformsString: $platformsString")

    val genreList: MutableList<String> = mutableListOf()
    game.genres.forEach {
        genreList.add(it.name)
    }
    val genresString = genreList.joinToString(", ")

    val developerList: MutableList<String> = mutableListOf()
    game.developers.forEach {
        developerList.add(it.name)
    }
    val developersString = developerList.joinToString(", ")

    val publisherList: MutableList<String> = mutableListOf()
    game.publishers.forEach {
        publisherList.add(it.name)
    }
    val publishersString = publisherList.joinToString(", ")

    val ageRating: String = game.esrbRating?.name?:"Not rated"
    Timber.d("game.esrbRating.name: ${game.esrbRating?.name}")

    val tagsList: MutableList<String> = mutableListOf()
    game.tags.forEach {
        tagsList.add(it.name)
    }
    val tagsString = tagsList.joinToString { ", " }

    val releaseDae: String = game.released

    return Specification(
        platforms = platformsString,
        genres = genresString,
        developer = developersString,
        publisher = publishersString,
        ageRating = ageRating,
        tags = tagsString,
        releaseDate = releaseDae
    )
}
