package com.antoniosj.actorstmdb.repository

interface RemoteRepository<T> {
    fun getAll() : T
}