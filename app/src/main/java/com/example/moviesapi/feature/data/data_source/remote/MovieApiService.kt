package com.example.moviesapi.feature.data.data_source.remote.dto

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    @GET("titles/search/title/{movieTitle}")
    suspend fun getMoviesByTitle(
       @Path("movieTitle") movieTitle: String?,
       @Query("exact") exact: Boolean,
       @Query("page") page: Int,
       @Query("sort") sort: String?,
       @Query("titleType") titleType: String?,
       @Header("X-RapidAPI-Host") host: String,
       @Header("X-RapidAPI-Key") apiKey: String
    ): MoviesDto
}
