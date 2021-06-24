package com.dicoding.moviesapps.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.moviesapps.data.MovieRepository
import com.dicoding.moviesapps.data.model.MovieEntity
import com.dicoding.moviesapps.data.model.TvShowEntity

class FavoriteViewModel(private val repository: MovieRepository) : ViewModel() {

    private lateinit var movies: LiveData<PagedList<MovieEntity>>

    fun getMovieFavorite(): LiveData<PagedList<MovieEntity>> {
        if (::movies.isInitialized) return movies

        movies = repository.getMovieFavorites()
        return movies
    }
    private lateinit var tvshows: LiveData<PagedList<TvShowEntity>>

    fun getTvShowsFavorite(): LiveData<PagedList<TvShowEntity>> {
        if (::tvshows.isInitialized) return tvshows

        tvshows = repository.getTvShowFavorites()
        return tvshows
    }


}