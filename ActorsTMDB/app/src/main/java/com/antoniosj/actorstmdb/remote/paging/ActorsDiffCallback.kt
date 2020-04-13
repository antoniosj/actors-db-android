package com.antoniosj.actorstmdb.remote.paging

import androidx.recyclerview.widget.DiffUtil
import com.antoniosj.actorstmdb.entity.Actor

// Paging 2/5: Cria o callback que implementa o DiffUtil pra a lista saber se tem os mesmos items.
// Isso é usado no Adapter.

class ActorsDiffCallback: DiffUtil.ItemCallback<Actor>() {
    override fun areItemsTheSame(oldItem: Actor, newItem: Actor): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Actor, newItem: Actor): Boolean {
        return oldItem.name == newItem.name
    }
}