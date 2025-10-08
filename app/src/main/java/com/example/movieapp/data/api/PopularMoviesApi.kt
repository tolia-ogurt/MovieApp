package com.example.movieapp.data.api

import com.example.movieapp.data.entity.PopularMoviesDTO

interface PopularMoviesApi {
    suspend fun getPopularMovies(): PopularMoviesDTO
}