package com.antoniosj.actorstmdb.listactors.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.antoniosj.actorstmdb.R
import com.antoniosj.actorstmdb.actordetail.view.ActorDetailActivity
import com.antoniosj.actorstmdb.di.ActorsApplication
import com.antoniosj.actorstmdb.entity.Actor
import com.antoniosj.actorstmdb.listactors.viewmodel.ListActorsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var listActorsAdapter: ListActorsAdapter

    /*
     * temporary. Change for Dagger in the future
     */
    @Inject lateinit var listActorsViewModel: ListActorsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as ActorsApplication).appComponent.inject(this)
        setContentView(R.layout.activity_main)

        listActorsAdapter = ListActorsAdapter(this)
        rv_actors.adapter = listActorsAdapter
        rv_actors.layoutManager = GridLayoutManager(this, 2)
        
        listActorsViewModel.getActors()

        listActorsViewModel.personResponse.observe(this, Observer {
            actorsResponse ->
            listActorsAdapter.setActors(actorsResponse.results) {
                clicked(it)
            }
        })
        

    }

    fun clicked(actor: Actor) {
        //in future this will open a detail screen
        Log.d("ASJ", actor.name)
        var intent = Intent(this, ActorDetailActivity::class.java).apply {
            putExtra("ACTOR", actor)
        }
        startActivity(intent)
    }
}
