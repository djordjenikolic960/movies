package com.example.moviesapi.feature.data.data_source.remote.dto

data class Result(
    val _id: String,
    val id: String,
    val originalTitleText: OriginalTitleText,
    val primaryImage: PrimaryImage?,
    val releaseDate: ReleaseDate,
    val releaseYear: ReleaseYear,
    val titleText: TitleText,
    val titleType: TitleType
)