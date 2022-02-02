package net.alanproject.rawg_private.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import net.alanproject.domain.model.list.Game
import net.alanproject.domain.usecases.GetGames
import net.alanproject.domain.util.Resource
import net.alanproject.rawg_private.common.Constants.Companion.ACTION
import net.alanproject.rawg_private.common.Constants.Companion.HOT_PERIOD
import net.alanproject.rawg_private.common.Constants.Companion.PUZZLE
import net.alanproject.rawg_private.common.Constants.Companion.RACING
import net.alanproject.rawg_private.common.Constants.Companion.RELEASE_PERIOD
import net.alanproject.rawg_private.common.Constants.Companion.STRATEGY
import net.alanproject.rawg_private.common.Constants.Companion.TRENDING_PERIOD
import net.alanproject.rawg_private.common.Constants.Companion.UPCOMING_PERIOD
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGames: GetGames
) : ViewModel() {

    //Trending
    val trendingListState: MutableState<List<Game>> = mutableStateOf(listOf())

    //Hot: NewRelease, Upcoming
    val upcomingListState: MutableState<List<Game>> = mutableStateOf(listOf())
    val newReleaseListState: MutableState<List<Game>> = mutableStateOf(listOf())

    //Ranking
    val rankListState: MutableState<List<Game>> = mutableStateOf(listOf())

    //Popular by Genre
    val actionListState: MutableState<List<Game>> = mutableStateOf(listOf())
    val strategyListState: MutableState<List<Game>> = mutableStateOf(listOf())
    val puzzleListState: MutableState<List<Game>> = mutableStateOf(listOf())
    val racingListState: MutableState<List<Game>> = mutableStateOf(listOf())

    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    fun onLoadGames() {

        Timber.d("onLoadGames in ViewModel")
        try {
            viewModelScope.launch {
                val trendingDeferred = async { fetchResource(trendingListState, TRENDING_PERIOD) }

                val upcomingDeferred = async { fetchResource(upcomingListState, UPCOMING_PERIOD) }
                val newReleaseDeferred =
                    async { fetchResource(newReleaseListState, RELEASE_PERIOD) }

                val rankDeferred = async { fetchResource(rankListState, HOT_PERIOD) }

                //Generes
                val actionDeferred = async { fetchResource(actionListState, HOT_PERIOD, genres = ACTION) }
                val strategyDeferred = async { fetchResource(strategyListState, HOT_PERIOD, genres = STRATEGY) }
                val puzzleDeferred = async { fetchResource(puzzleListState, HOT_PERIOD, genres = PUZZLE) }
                val racingDeferred = async { fetchResource(racingListState, HOT_PERIOD, genres = RACING) }

                awaitAll(
                    trendingDeferred,
                    rankDeferred,
                    upcomingDeferred,
                    newReleaseDeferred,
                    actionDeferred,
                    strategyDeferred,
                    puzzleDeferred,
                    racingDeferred
                )

            }

        } catch (exception: Exception) {
            Timber.d("throwable: $exception")
        }
    }

    private suspend fun fetchResource(games: MutableState<List<Game>>, dates: String,genres:String?=null) {
        Timber.d("fetchResource in MainViewModel")
        isLoading.value = true
        val result = getGames.get(dates = dates, genres = genres)

        when (result) {
            is Resource.Success -> {
                Timber.d("fetchResource: Success")
                games.value = result.data?.results ?: listOf()
                loadError.value = ""
                isLoading.value = false

            }
            is Resource.Error -> {
                Timber.d("fetchResource: Error ${result.message}")
                loadError.value = result.message!!
                isLoading.value = false
            }
        }
    }


}