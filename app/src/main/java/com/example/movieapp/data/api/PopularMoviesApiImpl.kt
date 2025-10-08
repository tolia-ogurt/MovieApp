package com.example.movieapp.data.api

import com.example.movieapp.data.entity.PopularMoviesDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

private const val GET_POPULAR_MOVIES_ENDPOINT = "popular?language=en-US&page=1"

class PopularMoviesApiImpl(private val httpClient: HttpClient) : PopularMoviesApi {
    override suspend fun getPopularMovies(): PopularMoviesDTO =
        httpClient.get(GET_POPULAR_MOVIES_ENDPOINT).body()
}