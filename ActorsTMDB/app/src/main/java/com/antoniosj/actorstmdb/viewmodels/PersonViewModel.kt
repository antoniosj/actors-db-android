package com.antoniosj.actorstmdb.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antoniosj.actorstmdb.models.remote.TmdbPersonResponse
import com.antoniosj.actorstmdb.models.repository.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PersonViewModel: ViewModel() {

    private val repository: PersonRepository = PersonRepository()
    private val mutablePersonResponse = MutableLiveData<TmdbPersonResponse>()
    val personResponse: LiveData<TmdbPersonResponse> = mutablePersonResponse

    fun loadPeople() {
        viewModelScope.launch {
            val personResponse = withContext(Dispatchers.IO) {
                repository.getPeople()
            }
            mutablePersonResponse.value = personResponse
            Log.d("ASJ", mutablePersonResponse.value.toString())
        }
    }

}