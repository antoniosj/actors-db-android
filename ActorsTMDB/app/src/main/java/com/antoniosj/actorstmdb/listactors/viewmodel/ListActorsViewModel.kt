package com.antoniosj.actorstmdb.listactors.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antoniosj.actorstmdb.entity.Actor
import com.antoniosj.actorstmdb.remote.ActorResponse
import com.antoniosj.actorstmdb.repository.ActorsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListActorsViewModel: ViewModel() {

    private val repository: ActorsRepository = ActorsRepository()
    private val mutablePersonResponse = MutableLiveData<ActorResponse>()
    val personResponse: LiveData<ActorResponse> = mutablePersonResponse

    // Coroutines will dispatch in IO the "fire and go" repository function and set the personResp
    // variable
    fun loadPeople() : LiveData<ActorResponse> {
        viewModelScope.launch {
            val personResponse = withContext(Dispatchers.IO) {
                repository.getAll()
            }
            mutablePersonResponse.value = personResponse
            Log.d("ASJ", mutablePersonResponse.value.toString())
        }
        return personResponse
    }

}