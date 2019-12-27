package com.antoniosj.actorstmdb.actordetail.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.antoniosj.actorstmdb.R
import com.antoniosj.actorstmdb.actordetail.viewmodel.ActorDetailViewModel
import com.antoniosj.actorstmdb.entity.Actor
import com.antoniosj.actorstmdb.entity.MovieCredit
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_actor_detail.*

//TODO incluir o cardview na tela
class ActorDetailActivity : AppCompatActivity() {

    lateinit var actorsDetailViewModel: ActorDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor_detail)

        actorsDetailViewModel = ViewModelProviders.of(this)
            .get(ActorDetailViewModel::class.java)

        initUi()
    }

    private fun initUi() {
        var actor = intent.getSerializableExtra("ACTOR") as Actor
        tv_actor_name.text = actor.name
        tv_actor_popularity.text = actor.popularity.toString()
        Glide.with(this).load(actor.profilePath).into(iv_actor_detail)
        getMovieCredit(actor.id)
    }

    private fun getMovieCredit(id: Int) {
        actorsDetailViewModel.movieCreditsResponse
        actorsDetailViewModel.getMovieCredits(id).observe(this, Observer {
            Log.d("ASJ", it.movieCredits[0].character)
        })
    }
}
