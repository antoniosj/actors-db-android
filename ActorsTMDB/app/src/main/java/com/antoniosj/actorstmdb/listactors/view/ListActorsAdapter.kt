package com.antoniosj.actorstmdb.listactors.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.antoniosj.actorstmdb.R
import com.antoniosj.actorstmdb.entity.Actor
import com.antoniosj.actorstmdb.remote.paging.ActorsDiffCallback
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.actor_item.view.*

/**
 * Adapter do meu list de actors
 *
 * @property actorsResponse ao invés de passar uma lista de actors, eu tenho 1 classe ActorResponse
 * que contém uma lista de actors dentro
 * @property callback callback que vai enviar o actor clicado para a view
 */

/*
*  Paging 4/5:
*  Precisei trocar o tipo do adapter pra PagedListAdapter, assando key e value e no construtor o
*  callback
*
*  Também posso usar do método "getItem()" pro paging direto.
*/
class ListActorsAdapter(private val context: Context)
    : PagedListAdapter<Actor ,ListActorsAdapter.ListActorsViewHolder>(ActorsDiffCallback()) {

    // not in use: Paging
    var actorsResponse: List<Actor> = ArrayList()

    lateinit var callback: (Actor) -> Unit

    //This way I avoid orientation changes problems
    fun setActors(actors: List<Actor>, callback: (Actor) -> Unit) {
        // not in use: Paging
        actorsResponse = actors
        this.callback = callback
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListActorsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.actor_item, parent, false)
        return ListActorsViewHolder(view)
    }

// not in use: Paging
//    override fun getItemCount(): Int {
//        return actorsResponse.size
//    }

    override fun onBindViewHolder(holder: ListActorsViewHolder, position: Int) {
        var actor: Actor? = getItem(position) //actorsResponse[position]
        Glide.with(context).load(actor?.profilePath).into(holder.imProfile)
        holder.imProfile.setOnClickListener { this.callback(actorsResponse[position]) }
    }


    /**
     * ViewHolder pra fazer o bind com os elementos da lista
     *
     * @constructor
     * Recebe o itemView quando o adapter for instanciado
     *
     * @param itemView
     * vai fazer o bind com o textview do actors_item.xml.
     * Como o itemView é passado por construtor no kotlin,
     * só precisa atribuir o valor (findviewbyId) que o adapter
     * já consegue visualizar
     */
    class ListActorsViewHolder(itemView: View)
        // java = super(itemView)
        : RecyclerView.ViewHolder(itemView) {
//        var tvActors: TextView = itemView.tv_actors
        var imProfile: ImageView = itemView.im_profile
    }
}