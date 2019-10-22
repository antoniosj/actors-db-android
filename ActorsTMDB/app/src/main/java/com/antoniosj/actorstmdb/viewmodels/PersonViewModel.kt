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


    val repository: PersonRepository = PersonRepository()
    val _personResponse = MutableLiveData<TmdbPersonResponse>()
    val personResponse: LiveData<TmdbPersonResponse> = _personResponse

    fun loadPeople() {
        viewModelScope.launch {
            val person = withContext(Dispatchers.IO) {
                repository.getPeople()
            }
            _personResponse.value = person
            Log.d("ASJ", _personResponse.value.toString())
        }
    }

}