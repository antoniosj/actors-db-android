package com.antoniosj.actorstmdb.models.remote

import com.antoniosj.actorstmdb.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//service
object ApiRouterFactory {

    private const val BASE_URL = "https://api.themoviedb.org/3/"

    private val authInterceptor = Interceptor {
        chain ->
        val newUrl = chain.request()
            .url()
            .newBuilder()
            .addQueryParameter("api_key", Constants.tmdbApiKey)
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    private val tmdbClient = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .build()

    private fun apiBuilder(): Retrofit = Retrofit.Builder()
        .client(tmdbClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val tmdbApi : TmdbService = apiBuilder().create(TmdbService::class.java)

}