package com.antoniosj.actorstmdb.listactors.view

import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.antoniosj.actorstmdb.R
import com.antoniosj.actorstmdb.entity.TmdbActor
import com.antoniosj.actorstmdb.remote.TmdbActorResponse
import kotlinx.android.synthetic.main.actor_item.view.*

/**
 * Adapter do meu list de actors
 *
 * @property actorsResponse ao invés de passar uma lista de actors, eu tenho 1 classe ActorResponse
 * que contém uma lista de actors dentro
 * @property callback callback que vai enviar o actor clicado para a view
 */
class ListActorsAdapter(val actorsResponse: TmdbActorResponse, val callback: (TmdbActor) -> Unit)
    : RecyclerView.Adapter<ListActorsAdapter.ListActorsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListActorsViewHolder {
        TODO("not implemented")
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ListActorsViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
        var tvActors: TextView = itemView.tv_actors
    }
}