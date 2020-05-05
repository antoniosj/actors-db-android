package com.antoniosj.actorstmdb.repository.bypage

import androidx.paging.DataSource
import com.antoniosj.actorstmdb.entity.Actor
import com.antoniosj.actorstmdb.remote.TmdbService
import javax.inject.Inject

class ActorsDataSourceFactory @Inject constructor(val tmdbService: TmdbService)
    : DataSource.Factory<Int, Actor>() {

    override fun create(): DataSource<Int, Actor> {
        return ActorsDataSource(tmdbService)
    }
}