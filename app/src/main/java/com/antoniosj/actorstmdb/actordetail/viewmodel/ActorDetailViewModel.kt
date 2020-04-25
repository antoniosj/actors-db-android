package com.antoniosj.actorstmdb.actordetail.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antoniosj.actorstmdb.actordetail.model.ActorDetailResponse
import com.antoniosj.actorstmdb.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ActorDetailViewModel @Inject constructor(val repository: Repository<ActorDetailResponse>) : ViewModel() {

    private var mutableMovieCreditsResponse = MutableLiveData<ActorDetailResponse>()
    val movieCreditsResponse: LiveData<ActorDetailResponse> = mutableMovieCreditsResponse

    fun getMovieCredits(id: Int) : LiveData<ActorDetailResponse> {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                repository.getById(id)
            }
            mutableMovieCreditsResponse.value = response
            Log.d("ASJ", mutableMovieCreditsResponse.value.toString())
        }
        return movieCreditsResponse
    }
}