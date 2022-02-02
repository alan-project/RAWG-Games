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
import net.alanproject.rawg_private.common.Constants.Companion.HOT_PERIOD
import net.alanproject.rawg_private.common.Constants.Companion.RELEASE_PERIOD
import net.alanproject.rawg_private.common.Constants.Companion.TRENDING_PERIOD
import net.alanproject.rawg_private.common.Constants.Companion.UPCOMING_PERIOD
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGames: GetGames
) : ViewModel() {

    val trendingListState: MutableState<List<Game>> = mutableStateOf(listOf())
    val hotListState: MutableState<List<Game>> = mutableStateOf(listOf())
    val upcomingListState: MutableState<List<Game>> = mutableStateOf(listOf())
    val newReleaseListState: MutableState<List<Game>> = mutableStateOf(listOf())

    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    fun onLoadGames() {

        Timber.d("onLoadGames in ViewModel")
        try {
            viewModelScope.launch {
                val newTrendingDeferred = async { fetchResource(trendingListState, TRENDING_PERIOD) }
                val hotDeferred = async { fetchResource(hotListState, HOT_PERIOD) }
                val upcomingDeferred = async { fetchResource(upcomingListState, UPCOMING_PERIOD) }
                val releaseDeferred = async { fetchResource(newReleaseListState, RELEASE_PERIOD) }
                awaitAll(newTrendingDeferred, hotDeferred, upcomingDeferred, releaseDeferred)

            }

        } catch (exception: Exception) {
            Timber.d("throwable: $exception")
        }
    }

    private suspend fun fetchResource(games: MutableState<List<Game>>, dates: String) {
        Timber.d("result: $games")
        isLoading.value = true
        val result = getGames.get(dates = dates)

        when (result) {
            is Resource.Success -> {
                games.value = result.data?.results?: listOf()
                loadError.value = ""
                isLoading.value = false

            }
            is Resource.Error -> {
                loadError.value = result.message!!
                isLoading.value = false
            }
        }
    }


}