package com.antoniosj.actorstmdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.antoniosj.actorstmdb.viewmodels.PersonViewModel

class MainActivity : AppCompatActivity() {

    val viewModel: PersonViewModel by lazy {
        ViewModelProviders.of(this).get(PersonViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.personResponse.observe(this, Observer {
            s -> Log.d("ASJ", s.results.toString())
        })
        viewModel.loadPeople()
    }
}
