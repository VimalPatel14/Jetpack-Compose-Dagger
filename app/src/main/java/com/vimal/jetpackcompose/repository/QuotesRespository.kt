package com.vimal.jetpackcompose.repository

import com.vimal.jetpackcompose.model.Quotes
import com.vimal.jetpackcompose.network.ApiInterface
import com.vimal.jetpackcompose.utils.NetworkState
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class QuotesRespository @Inject constructor(
    private val apiInterface: ApiInterface
) {

    suspend fun getUserResponse(): NetworkState<List<Quotes>> {
        val response = try {
            apiInterface.getUserData()
        } catch (e: Exception) {
            return NetworkState.Error("An unknown error occured: ${e.localizedMessage}")
        }

        return NetworkState.Success(response)
    }
}