package com.example.movieapp.data.mappers

import com.example.movieapp.data.entity.PopularMoviesDTO
import com.example.movieapp.data.entity.PopularMoviesResultDTO
import com.example.movieapp.domain.model.PopularMovies
import com.example.movieapp.domain.model.PopularMoviesResult

fun PopularMoviesDTO.asDomain() = PopularMovies(
    page = page,
    results = results.asDomain(),
    totalPages = totalPages,
    totalResults = totalResults
)

fun PopularMoviesResultDTO.asDomain() = PopularMoviesResult(
    adult = adult,
    backdropPath = backdropPath,
    genreIds = genreIds,
    id = id,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)

fun List<PopularMoviesResultDTO>.asDomain() = map { it.asDomain() }