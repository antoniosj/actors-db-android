package com.antoniosj.actorstmdb.listactors.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.antoniosj.actorstmdb.R
import com.antoniosj.actorstmdb.listactors.viewmodel.ListActorsViewModel

class MainActivity : AppCompatActivity() {

    /*
     * temporary. Change for Dagger in the future
     */
    private val listActorsViewModel: ListActorsViewModel by lazy {
        ViewModelProviders.of(this).get(ListActorsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listActorsViewModel.personResponse.observe(this, Observer {
            s -> Log.d("ASJ", s.results.toString())
        })
        
        listActorsViewModel.loadPeople()
    }
}
