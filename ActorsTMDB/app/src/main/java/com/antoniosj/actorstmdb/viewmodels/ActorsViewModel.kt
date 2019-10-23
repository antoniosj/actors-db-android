package com.antoniosj.actorstmdb.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antoniosj.actorstmdb.models.remote.TmdbActorResponse
import com.antoniosj.actorstmdb.models.repository.ActorsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ActorsViewModel: ViewModel() {

    private val repository: ActorsRepository = ActorsRepository()
    private val mutablePersonResponse = MutableLiveData<TmdbActorResponse>()
    val personResponse: LiveData<TmdbActorResponse> = mutablePersonResponse

    fun loadPeople() {
        viewModelScope.launch {
            val personResponse = withContext(Dispatchers.IO) {
                repository.getAll()
            }
            mutablePersonResponse.value = personResponse
            Log.d("ASJ", mutablePersonResponse.value.toString())
        }
    }

}