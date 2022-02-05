package net.alanproject.rawg_private.ui.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.alanproject.domain.model.params.ListParams
import net.alanproject.domain.model.response.list.Game
import net.alanproject.domain.usecases.GetGames
import net.alanproject.domain.util.Resource
import net.alanproject.rawg_private.common.PAGE_SIZE
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getGames: GetGames,
) : ViewModel() {

    private var curPage = 1

    val gamesState: MutableState<List<Game>> = mutableStateOf(listOf())
    private var cachedGames = mutableListOf<Game>()

    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)

    fun onLoadGames(listParams: ListParams) {

        try {
            if(!isLoading.value){

                viewModelScope.launch {
                    fetchResource(gamesState, listParams)
                }
            }
        } catch (exception: Exception) {
            Timber.d("throwable: $exception")
        }
    }

    private suspend fun fetchResource(games: MutableState<List<Game>>, listParams: ListParams) {
        Timber.d("fetchResource in ListViewModel")
        Timber.d("[LoadingError] curPage: $curPage")
        isLoading.value = true
        val result = getGames.get(page = curPage, listParams)
        when (result) {
            is Resource.Success -> {
                Timber.d("[LoadingError] Success")
                Timber.d("fetchResource: Success")
                endReached.value = curPage * PAGE_SIZE >= result.data!!.count

                cachedGames.addAll(result.data?.results?: listOf())
                games.value = cachedGames

                curPage ++
                Timber.d("curPage increase: $curPage")
                loadError.value = ""
                isLoading.value = false

            }
            is Resource.Error -> {
                Timber.d("[LoadingError] Error")
                Timber.d("fetchResource: Error ${result.message}")
                loadError.value = result.message!!
                isLoading.value = false
            }
            else ->{
                Timber.d("[LoadingError] else")
            }
        }
    }
}