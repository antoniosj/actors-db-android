package com.antoniosj.actorstmdb.listactors.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import com.antoniosj.actorstmdb.R
import com.antoniosj.actorstmdb.actordetail.view.ActorDetailActivity
import com.antoniosj.actorstmdb.ActorsApplication
import com.antoniosj.actorstmdb.entity.Actor
import com.antoniosj.actorstmdb.listactors.viewmodel.ListActorsViewModel
import com.antoniosj.actorstmdb.repository.paging.ActorsDataSource
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    lateinit var listActorsAdapter: ListActorsAdapter

    @Inject lateinit var listActorsViewModel: ListActorsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as ActorsApplication).appComponent.inject(this)
        setContentView(R.layout.activity_main)

        initializeList()
    }


    private fun initializeList() {

        listActorsAdapter = ListActorsAdapter(this)
        rv_actors.adapter = listActorsAdapter
        rv_actors.layoutManager = GridLayoutManager(this, 3)

        //2
        val actorsPagedList = listActorsViewModel.initializedPagedListBuilder()

        //3
        actorsPagedList.observe(this, Observer<PagedList<Actor>> { pagedList ->

            listActorsAdapter.submitList(pagedList)
            listActorsAdapter.actorClicked {
                var intent = Intent(this, ActorDetailActivity::class.java).apply {
                    putExtra("ACTOR", it)
                }
                startActivity(intent)
            }
        })
    }
}
