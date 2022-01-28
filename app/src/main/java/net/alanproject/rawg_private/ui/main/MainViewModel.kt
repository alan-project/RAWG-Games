package net.alanproject.rawg_private.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import net.alanproject.domain.model.list.Game
import net.alanproject.domain.usecases.GetGames
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGames: GetGames
) : ViewModel() {

    val newTrendingList: MutableState<List<Game>> = mutableStateOf(listOf())
    val hotListState: MutableState<List<Game>> = mutableStateOf(listOf())
    val upcomingListState: MutableState<List<Game>> = mutableStateOf(listOf())

    init{
        try{
            viewModelScope.launch {
                val newTrendingDeferred = async {
                    getGames.get(dates = "2022-01-01,2022-01-25")
                }
                val hotDeferred = async {
                    getGames.get(dates = "2021-06-01,2022-01-26")
                }
                val upcomingDeferred = async {
                    getGames.get(dates = "2022-01-27,2022-02-27")
                }


                newTrendingList.value = newTrendingDeferred.await()
                hotListState.value = hotDeferred.await()
                upcomingListState.value = upcomingDeferred.await()
            }

        }catch (exception: Exception) {
            Timber.d("throwable: $exception")
        }
    }

}