package net.alanproject.rawg_private.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import net.alanproject.domain.model.params.ListParams
import net.alanproject.domain.model.response.Game
import net.alanproject.domain.usecases.GetGames
import net.alanproject.domain.util.Resource
import net.alanproject.rawg_private.common.Constants.Companion.ACTION
import net.alanproject.rawg_private.common.Constants.Companion.ACTION_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.RANK_PERIOD
import net.alanproject.rawg_private.common.Constants.Companion.PUZZLE
import net.alanproject.rawg_private.common.Constants.Companion.PUZZLE_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.RACING
import net.alanproject.rawg_private.common.Constants.Companion.RACING_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.RANK_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.RELEASE_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.STRATEGY
import net.alanproject.rawg_private.common.Constants.Companion.STRATEGY_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.TRENDING_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.UPCOMING_PARAMS
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
                val trendingDeferred = async { fetchResource(trendingListState, TRENDING_PARAMS) }

                val upcomingDeferred = async { fetchResource(upcomingListState, UPCOMING_PARAMS) }
                val newReleaseDeferred =
                    async { fetchResource(newReleaseListState, RELEASE_PARAMS) }

                val rankDeferred = async {
                    fetchResource(rankListState, RANK_PARAMS)
                }

                //Generes
                val actionDeferred = async { fetchResource(actionListState, ACTION_PARAMS) }
                val strategyDeferred = async { fetchResource(strategyListState, STRATEGY_PARAMS) }
                val puzzleDeferred = async { fetchResource(puzzleListState, PUZZLE_PARAMS) }
                val racingDeferred = async { fetchResource(racingListState, RACING_PARAMS) }

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

    private suspend fun fetchResource(
        games: MutableState<List<Game>>,
        params:ListParams

    ) {
        Timber.d("fetchResource in MainViewModel")
        isLoading.value = true
        val result = getGames.get(params = params)

        when (result) {
            is Resource.Success -> {
                Timber.d("fetchResource: Success")
                games.value = (result.data?.results ?: listOf()).take(VERTICAL_GAME_NUMBER)
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

    companion object {
        private const val VERTICAL_GAME_NUMBER = 6
    }

}