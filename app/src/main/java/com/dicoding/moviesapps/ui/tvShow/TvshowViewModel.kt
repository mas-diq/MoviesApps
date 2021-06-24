package com.dicoding.moviesapps.ui.tvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.moviesapps.data.MovieRepository
import com.dicoding.moviesapps.data.model.TvShowEntity

class TvshowViewModel(private val repository: MovieRepository) : ViewModel() {

    private var tvShows = MutableLiveData<List<TvShowEntity>>()

    fun getTvShow() : LiveData<List<TvShowEntity>> {
        if (!tvShows.value.isNullOrEmpty()) return tvShows

        tvShows.value = repository.getTvShow()
        return tvShows
    }

}