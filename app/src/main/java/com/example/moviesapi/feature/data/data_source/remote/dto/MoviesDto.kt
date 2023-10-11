package com.example.moviesapi.feature.data.data_source.remote.dto

data class MoviesDto(
    val entries: Int,
    val next: Any,
    val page: String,
    val results: List<Result>
)