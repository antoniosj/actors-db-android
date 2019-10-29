package com.antoniosj.actorstmdb.repository

interface Repository<T> {
    suspend fun getAll(): T
}