package com.vimal.jetpackcompose.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vimal.jetpackcompose.model.Quotes
import com.vimal.jetpackcompose.repository.QuotesRespository
import com.vimal.jetpackcompose.utils.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(
    private val userRespository: QuotesRespository
): ViewModel() {

    var isLoading = mutableStateOf(false)
    private var _getUserData: MutableLiveData<List<Quotes>> = MutableLiveData<List<Quotes>>()
    var getUserData: LiveData<List<Quotes>> = _getUserData

    suspend fun getUserData(): NetworkState<List<Quotes>> {
        val result = userRespository.getUserResponse()
        if (result is NetworkState.Success) {
            isLoading.value = true
            _getUserData.value = result.data!!
        }

        return result
    }
}