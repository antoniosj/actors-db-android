package com.antoniosj.actorstmdb.actordetail.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antoniosj.actorstmdb.actordetail.model.ActorDetailsResponse
import com.antoniosj.actorstmdb.actordetail.model.ActorMovieCreditsResponse
import com.antoniosj.actorstmdb.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ActorDetailViewModel @Inject constructor(val repository: Repository<Any>) : ViewModel() {

    private var mutableMovieCreditsResponse = MutableLiveData<ActorMovieCreditsResponse>()
    val movieCreditsResponse: LiveData<ActorMovieCreditsResponse> = mutableMovieCreditsResponse

    private var mutableActorDetails = MutableLiveData<ActorDetailsResponse>()
    val actorDetailsResponse: LiveData<ActorDetailsResponse> = mutableActorDetails

    fun getMovieCredits(id: Int) : LiveData<ActorMovieCreditsResponse> {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                repository.getById(id)
            }
            mutableMovieCreditsResponse.value = response as ActorMovieCreditsResponse
            Log.d("ASJ", mutableMovieCreditsResponse.value.toString())
        }
        return movieCreditsResponse
    }

    fun getActorDetails(id: Int) : LiveData<ActorDetailsResponse> {

        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                repository.getDetailsById(id)
            }
            mutableActorDetails.value = response as ActorDetailsResponse
        }

        return actorDetailsResponse
    }
}