package com.antoniosj.actorstmdb.repository

interface Repository<T> {
    suspend fun getById(id: Int) : T
    suspend fun getDetailsById(id: Int) : T
}