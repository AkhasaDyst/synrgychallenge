package com.yudhi.moviedatabase.api

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun searchMovie(query: String) = apiService.searchMovie(query = query)
    suspend fun getMovieDetail(query: Int) = apiService.getMovieDetail(movieId = query)
    suspend fun moviePopular() = apiService.getMoviePopular()
}
