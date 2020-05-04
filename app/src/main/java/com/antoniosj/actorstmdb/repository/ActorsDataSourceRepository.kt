package com.antoniosj.actorstmdb.repository

interface ActorsDataSourceRepository<T> {
    fun getAll() : T
}