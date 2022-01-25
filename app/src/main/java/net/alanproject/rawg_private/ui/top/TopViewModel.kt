package net.alanproject.rawg_private.ui.top

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.alanproject.data.repository.RawgRepositoryImpl
import net.alanproject.domain.model.list.Result
import net.alanproject.domain.repository.RawgRepository

class TopViewModel(
    private val repository:RawgRepository = RawgRepositoryImpl()
):ViewModel() {

    val topListState: MutableState<List<Result>> = mutableStateOf(listOf())

    init{
        viewModelScope.launch(Dispatchers.IO) {
            val TopList = getList()
            topListState.value = TopList
        }
    }

    private fun getList(): List<Result> {
        return repository.getTopList()
    }
}