package com.example.movieapp.di

import android.util.Log
import com.example.movieapp.data.api.PopularMoviesApi
import com.example.movieapp.data.api.PopularMoviesApiImpl
import com.example.movieapp.data.repository.MoviesRepositoryImpl
import com.example.movieapp.domain.repository.MoviesRepository
import com.example.movieapp.domain.usecase.GetPopularMoviesUseCase
import com.example.movieapp.presentation.HomeScreenViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory<PopularMoviesApi> { PopularMoviesApiImpl(get()) }
    single<MoviesRepository> { MoviesRepositoryImpl(get()) }
    factory<GetPopularMoviesUseCase> { GetPopularMoviesUseCase(get()) }
    viewModel { HomeScreenViewModel(getPopularMoviesUseCase = get()) }
}

val networkModule = module {
    single {
        HttpClient(Android) {
            defaultRequest { url("https://api.themoviedb.org/3/movie/") }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
            engine {
                connectTimeout
                socketTimeout
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.d("HttpLogging:", message)
                    }

                }
            }

            //Http Response
            install(ResponseObserver) {
                onResponse { response ->
                    Log.d("HTTP status:", "${response.status.value}")
                }
            }

            // Headers
            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }
        }
    }
}