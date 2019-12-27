package com.antoniosj.actorstmdb.actordetail.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antoniosj.actorstmdb.entity.MovieCredit
import com.antoniosj.actorstmdb.remote.MovieCreditResponse
import com.antoniosj.actorstmdb.repository.MovieCreditsRepository
import com.antoniosj.actorstmdb.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ActorDetailViewModel : ViewModel() {

    private val repository: Repository<MovieCreditResponse> = MovieCreditsRepository()
    private var mutableMovieCreditsResponse = MutableLiveData<MovieCreditResponse>()
    val movieCreditsResponse: LiveData<MovieCreditResponse> = mutableMovieCreditsResponse

    fun getMovieCredits(id: Int) : LiveData<MovieCreditResponse> {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                Log.d("ASJ", id.toString())
                repository.getById(id)
            }
            mutableMovieCreditsResponse.value = response
            Log.d("ASJ", mutableMovieCreditsResponse.value.toString())
        }
        return movieCreditsResponse
    }
}