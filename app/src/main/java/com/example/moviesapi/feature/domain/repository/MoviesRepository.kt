package com.example.moviesapi.feature.domain.repository

import com.example.moviesapi.core.Resource
import com.example.moviesapi.feature.domain.model.Movies
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getMovies(title: String): Flow<Resource<Movies>>
}