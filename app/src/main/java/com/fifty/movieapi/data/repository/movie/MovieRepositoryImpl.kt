package com.fifty.movieapi.data.repository.movie

import android.util.Log
import com.fifty.movieapi.data.model.movie.Movie
import com.fifty.movieapi.data.model.movie.MovieList
import com.fifty.movieapi.data.repository.movie.datasource.MovieCacheDataSource
import com.fifty.movieapi.data.repository.movie.datasource.MovieLocalDataSource
import com.fifty.movieapi.data.repository.movie.datasource.MovieRemoteDataSource
import com.fifty.movieapi.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDataSource.getMovies()
            val body: MovieList? = response.body()

            if (body != null)
                movieList = body.movies

        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return movieList
    }

    private suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var moviesList: List<Movie>

        try {
            moviesList = movieLocalDataSource.getMoviesFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (moviesList.isNotEmpty()) {
            return moviesList
        } else {
            moviesList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(moviesList)
        }

        return moviesList
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }

}