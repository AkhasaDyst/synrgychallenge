package com.yudhi.moviedatabase.data

import com.yudhi.moviedatabase.api.RemoteDataSource

class MovieRepository(private val remoteDataSource: RemoteDataSource) {

    suspend fun searchMovie(query: String) = remoteDataSource.searchMovie(query)
    suspend fun moviePopular() = remoteDataSource.moviePopular()
    suspend fun getMovieDetail(query: Int) = remoteDataSource.getMovieDetail(query)
}
