package com.antoniosj.actorstmdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.antoniosj.actorstmdb.viewmodels.ActorsViewModel

class MainActivity : AppCompatActivity() {

    private val actorsViewModel: ActorsViewModel by lazy {
        ViewModelProviders.of(this).get(ActorsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actorsViewModel.personResponse.observe(this, Observer {
            s -> Log.d("ASJ", s.results.toString())
        })
        
        actorsViewModel.loadPeople()
    }
}
