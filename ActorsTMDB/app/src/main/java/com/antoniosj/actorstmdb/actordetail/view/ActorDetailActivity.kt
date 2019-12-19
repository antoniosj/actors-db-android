package com.antoniosj.actorstmdb.actordetail.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.antoniosj.actorstmdb.R
import com.antoniosj.actorstmdb.entity.Actor
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_actor_detail.*

class ActorDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor_detail)
        initUi()
    }

    private fun initUi() {
        var actor = intent.getSerializableExtra("ACTOR") as Actor
        tv_actor_name.text = actor.name
        tv_actor_popularity.text = actor.popularity.toString()
        Glide.with(this).load(actor.profilePath).into(iv_actor_detail)
    }
}
