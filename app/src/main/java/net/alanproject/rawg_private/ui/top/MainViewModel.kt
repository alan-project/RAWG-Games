package net.alanproject.rawg_private.ui.top

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import net.alanproject.domain.model.list.Result
import net.alanproject.domain.usecases.GetList
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getList: GetList
) : ViewModel() {

    val newTrendingState: MutableState<List<Result>> = mutableStateOf(listOf())
    val hotState: MutableState<List<Result>> = mutableStateOf(listOf())
    val upcomingState: MutableState<List<Result>> = mutableStateOf(listOf())

    init{
        try{
            viewModelScope.launch {
                val newTrendingDeferred = async {
                    getList(dates = "2022-01-01,2022-01-25", platforms =null)
                }
                val hotDeferred = async {
                    getList(dates = "2021-07-01,2022-01-25", platforms =null)
                }
                val upcomingDeferred = async {
                    getList(dates = "2022-01-27,2022-02-27", platforms =null)
                }

                newTrendingState.value = newTrendingDeferred.await()
                hotState.value = hotDeferred.await()
                upcomingState.value = upcomingDeferred.await()
            }

        }catch (exception: Exception) {
            Timber.d("throwable: $exception")
        }
    }


    private suspend fun getList(
        page: Int = 1,
        order: String = "rating",
        dates: String = "",
        platforms: String?
    ): List<Result> {
        return getList.getList(page, order, dates, platforms)
    }
}