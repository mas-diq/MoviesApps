package com.dicoding.moviesapps.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.moviesapps.data.MovieRepository
import com.dicoding.moviesapps.data.model.MovieEntity

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    private var movies = MutableLiveData<List<MovieEntity>>()



    fun setMovie() {

        movies.postValue(repository.getMovies())
    }

    fun getMovie(): LiveData<List<MovieEntity>> {

        return movies
    }

}