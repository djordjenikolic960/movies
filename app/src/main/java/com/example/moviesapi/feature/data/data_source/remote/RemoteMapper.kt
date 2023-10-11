package com.example.moviesapi.feature.data.data_source.remote

import com.example.moviesapi.core.EntityMapper
import com.example.moviesapi.feature.data.data_source.remote.dto.MoviesDto
import com.example.moviesapi.feature.domain.model.Movie
import com.example.moviesapi.feature.domain.model.Movies
import javax.inject.Inject

class RemoteMapper @Inject constructor() : EntityMapper<MoviesDto, Movies> {
    override fun mapToEntity(domainModel: Movies): MoviesDto {
        TODO("Not yet implemented")
    }

    override fun mapFromEntity(entity: MoviesDto): Movies {
        val movies = entity.results.map {
            Movie(
                title = it.titleText.text,
                imageUrl = if (it.primaryImage != null) {
                    it.primaryImage.url
                } else {
                    ""
                }
            )
        }
        return Movies(movies = movies)
    }

}