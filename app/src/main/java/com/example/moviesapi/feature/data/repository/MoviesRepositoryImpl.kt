package com.example.moviesapi.feature.data.repository

import com.example.moviesapi.core.Constants.apiKey
import com.example.moviesapi.core.Constants.host
import com.example.moviesapi.core.Resource
import com.example.moviesapi.feature.data.data_source.remote.RemoteMapper
import com.example.moviesapi.feature.data.data_source.remote.dto.MovieApiService
import com.example.moviesapi.feature.domain.model.Movies
import com.example.moviesapi.feature.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class MoviesRepositoryImpl constructor(
    private val moviesApiService: MovieApiService,
    private val remoteMapper: RemoteMapper,
) : MoviesRepository {
    override fun getMovies(title: String): Flow<Resource<Movies>> = flow {
        emit(Resource.Loading())

        try {
            val moviesDto = moviesApiService.getMoviesByTitle(
                movieTitle = title,
                exact = false,
                page = 1,
                sort = null,
                titleType = null,
                host = host,
                apiKey = apiKey
            )
            val movies = remoteMapper.mapFromEntity(moviesDto)
            emit(
                Resource.Success(
                    data = movies
                )
            )
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = e.message ?: "something went wrong"
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check you internet connection."
                )
            )
        }
    }

}
