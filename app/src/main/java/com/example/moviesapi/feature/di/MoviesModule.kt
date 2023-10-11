package com.example.moviesapi.feature.di

import com.example.moviesapi.core.Constants.BASE_URL
import com.example.moviesapi.feature.data.data_source.remote.RemoteMapper
import com.example.moviesapi.feature.data.data_source.remote.dto.MovieApiService
import com.example.moviesapi.feature.data.repository.MoviesRepositoryImpl
import com.example.moviesapi.feature.domain.repository.MoviesRepository
import com.example.moviesapi.feature.domain.use_case.GetMoviesByTitle
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MoviesModule {

    @Provides
    @Singleton
    fun provideGetMoviesByTitleUseCase(repository: MoviesRepository): GetMoviesByTitle {
        return GetMoviesByTitle(repository = repository)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        movieApiService: MovieApiService,
        remoteMapper: RemoteMapper,
    ): MoviesRepository {
        return MoviesRepositoryImpl(movieApiService, remoteMapper,)
    }

    @Provides
    @Singleton
    fun provideApiService(): MovieApiService {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(MovieApiService::class.java)
    }


}