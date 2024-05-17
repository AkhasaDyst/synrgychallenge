package com.yudhi.moviedatabase.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.*
import com.yudhi.moviedatabase.api.ApiClient
import com.yudhi.moviedatabase.data.MovieRepository
import com.yudhi.moviedatabase.helper.MyDataStore
import com.yudhi.moviedatabase.helper.Resource
import com.yudhi.moviedatabase.model.movie.MovieResponse
import com.yudhi.moviedatabase.model.movie.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MovieViewModel(private val repository: MovieRepository, private var pref: MyDataStore) : ViewModel() {

    private var _movieResponse = MutableLiveData<MovieResponse?>()
    val movieResponse: LiveData<MovieResponse?> get() = _movieResponse
    private val _detailMovie = MutableLiveData<Result?>()
    val detailMovie: LiveData<Result?> get() = _detailMovie

    //async
    fun searchMovie(query: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(data = repository.searchMovie(query)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getMoviePopular() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(data = repository.moviePopular()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
    fun getDetailMovie(query: Int) {
        ApiClient.instance.getMovieDetail(movieId = query).enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                val data = response.body()
                _detailMovie.postValue(data)
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                _detailMovie.postValue(null)
            }
        })


    }

    fun getMovieNowPlaying() {
        ApiClient.instance.getMovieNowPlaying().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val data = response.body()
                _movieResponse.postValue(data)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                _movieResponse.postValue(null)
            }

        })
    }


}
