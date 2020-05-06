package com.antoniosj.actorstmdb.actordetail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.antoniosj.actorstmdb.R
import com.antoniosj.actorstmdb.actordetail.viewmodel.ActorDetailViewModel
import com.antoniosj.actorstmdb.ActorsApplication
import com.antoniosj.actorstmdb.entity.Actor
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_actor_detail.*
import javax.inject.Inject

class ActorDetailActivity : AppCompatActivity() {

    @Inject lateinit var actorsDetailViewModel: ActorDetailViewModel
    lateinit var actorDetailAdapter: ActorDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as ActorsApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor_detail)

        actorDetailAdapter = ActorDetailAdapter(this)
        rv_movie_credit.adapter = actorDetailAdapter
        rv_movie_credit.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        initUi()
    }

    private fun initUi() {
        var actor = intent.getSerializableExtra("ACTOR") as Actor
        Glide.with(this).load(actor.profilePath).into(iv_actor_detail)
        getActorDetails(actor)
        getMovieCredit(actor.id)
        tv_actor_name.text = actor.name
        tv_actor_popularity.text = actor.popularity.toString()
    }

    private fun getMovieCredit(id: Int) {
        actorsDetailViewModel.movieCreditsResponse
        actorsDetailViewModel.getMovieCredits(id).observe(this, Observer {
            actorDetailAdapter.setMovieCredits(it.movieCredits)
        })
    }

    private fun getActorDetails(actor: Actor) {
        actorsDetailViewModel.getActorDetails(actor.id).observe(this, Observer {
            tv_actor_biography.text = it.biography
        })
    }
}
