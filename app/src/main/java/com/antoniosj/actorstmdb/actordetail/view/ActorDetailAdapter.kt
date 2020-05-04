package com.antoniosj.actorstmdb.actordetail.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.antoniosj.actorstmdb.R
import com.antoniosj.actorstmdb.entity.MovieCredit
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_credits_item.view.*


class ActorDetailAdapter(private val context: Context)
    : RecyclerView.Adapter<ActorDetailAdapter.MovieCreditViewHolder>() {

    private var movieCreditResponse : List<MovieCredit> = ArrayList()

    fun setMovieCredits(movieCredits: List<MovieCredit>) {
        movieCreditResponse = movieCredits
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCreditViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.movie_credits_item, parent, false)
        return MovieCreditViewHolder(view)
    }

    override fun getItemCount() =  movieCreditResponse.size


    override fun onBindViewHolder(holder: MovieCreditViewHolder, position: Int) {
        val movieCredit = movieCreditResponse[position]
        Glide.with(context).load(movieCredit.posterPath).into(holder.ivMovieCredit)
    }


    class MovieCreditViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivMovieCredit : ImageView = itemView.iv_movie_credit
    }
}