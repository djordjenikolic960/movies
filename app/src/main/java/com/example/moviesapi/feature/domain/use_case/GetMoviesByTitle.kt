package com.example.moviesapi.feature.domain.use_case

import com.example.moviesapi.core.Resource
import com.example.moviesapi.feature.domain.model.Movies
import com.example.moviesapi.feature.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMoviesByTitle(
    private val repository: MoviesRepository
) {
    operator fun invoke(title: String): Flow<Resource<Movies>> {
        if (title.isBlank()) {
            return flow { }
        }
        return repository.getMovies(title)
    }

}