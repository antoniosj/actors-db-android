package com.antoniosj.actorstmdb.repository

interface Repository<T> {
    suspend fun getAll(page: Int = 1): T
    suspend fun getById(id: Int) : T
}