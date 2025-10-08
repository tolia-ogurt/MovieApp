package com.example.movieapp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class PopularMovies(
    @SerialName("page")
    val page: Int? = null,
    @SerialName("results")
    val results: List<PopularMoviesResult> = emptyList(),
    @SerialName("total_pages")
    val totalPages: Int? = null,
    @SerialName("total_results")
    val totalResults: Int? = null
)

@Serializable
data class PopularMoviesResult(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)