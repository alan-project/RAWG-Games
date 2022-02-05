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
import net.alanproject.domain.model.response.list.Game
import net.alanproject.domain.usecases.GetGames
import net.alanproject.domain.util.Resource
import net.alanproject.rawg_private.common.Constants.Companion.ACTION_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.MOBILE_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.PC_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.PS_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.PUZZLE_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.RACING_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.RANK_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.RELEASE_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.STRATEGY_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.TRENDING_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.UPCOMING_PARAMS
import net.alanproject.rawg_private.common.Constants.Companion.XBOX_PARAMS
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGames: GetGames
) : ViewModel() {

    //Trending
    val trendingGamesState: MutableState<List<Game>> = mutableStateOf(listOf())

    //Hot: NewRelease, Upcoming
    val upcomingGamesState: MutableState<List<Game>> = mutableStateOf(listOf())
    val releaseGamesState: MutableState<List<Game>> = mutableStateOf(listOf())

    //Ranking
    val totalRankGamesState: MutableState<List<Game>> = mutableStateOf(listOf())

    //Popular by Genre
    val actionGamesState: MutableState<List<Game>> = mutableStateOf(listOf())
    val strategyGamesState: MutableState<List<Game>> = mutableStateOf(listOf())
    val puzzleGamesState: MutableState<List<Game>> = mutableStateOf(listOf())
    val racingGamesState: MutableState<List<Game>> = mutableStateOf(listOf())

    //Popular by Platforms
    val pcGamesState: MutableState<List<Game>> = mutableStateOf(listOf())
    val psGamesState: MutableState<List<Game>> = mutableStateOf(listOf())
    val xboxGamesState: MutableState<List<Game>> = mutableStateOf(listOf())
    val mobileGamesState: MutableState<List<Game>> = mutableStateOf(listOf())

    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    fun onLoadGames() {

        Timber.d("onLoadGames in ViewModel")
        try {
            viewModelScope.launch {
                val trendingDeferred = async { fetchResource(trendingGamesState, TRENDING_PARAMS) }

                val upcomingDeferred = async { fetchResource(upcomingGamesState, UPCOMING_PARAMS) }
                val newReleaseDeferred =
                    async { fetchResource(releaseGamesState, RELEASE_PARAMS) }

                val rankDeferred = async {
                    fetchResource(totalRankGamesState, RANK_PARAMS)
                }

                //Generes
                val actionDeferred = async { fetchResource(actionGamesState, ACTION_PARAMS) }
                val strategyDeferred = async { fetchResource(strategyGamesState, STRATEGY_PARAMS) }
                val puzzleDeferred = async { fetchResource(puzzleGamesState, PUZZLE_PARAMS) }
                val racingDeferred = async { fetchResource(racingGamesState, RACING_PARAMS) }

                //PlatformTemp
                val pcDeferred = async { fetchResource(pcGamesState, PC_PARAMS) }
                val psDeferred = async { fetchResource(psGamesState, PS_PARAMS) }
                val xboxDeferred = async { fetchResource(xboxGamesState, XBOX_PARAMS) }
                val mobileDeferred = async { fetchResource(mobileGamesState, MOBILE_PARAMS) }

                awaitAll(
                    trendingDeferred,
                    rankDeferred,
                    upcomingDeferred,
                    newReleaseDeferred,
                    actionDeferred,
                    strategyDeferred,
                    puzzleDeferred,
                    racingDeferred,
                    pcDeferred,
                    psDeferred,
                    xboxDeferred,
                    mobileDeferred

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