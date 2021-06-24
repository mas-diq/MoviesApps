package com.dicoding.moviesapps.data

import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dicoding.moviesapps.data.model.MovieEntity
import com.dicoding.moviesapps.data.model.TvShowEntity
import com.dicoding.moviesapps.utils.DataMovies
import com.dicoding.moviesapps.utils.DataTvShow

class MovieRepository(private val movieDao: MovieDao) {

    fun getMovies() = DataMovies.generateDummymovies()
    fun getTvShow() = DataTvShow.generateDummytvShow()

    fun getDescMovie(id: String) = DataMovies.generateDummyDesc(id)
    fun getDescTvShow(id: String) = DataTvShow.generateDummyDesc(id)

    fun addFavorite(movie: MovieEntity) = movieDao.addMovie(movie)
    fun addFavoriteTvShow(tvShow: TvShowEntity) = movieDao.addTvShow(tvShow)

    fun removeFavorite(movie: MovieEntity) = movieDao.removeFavoriteMovie(movie)
    fun removeFavoriteTvSho(tvShow: TvShowEntity) = movieDao.removeTvShow(tvShow)

    private val config = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setInitialLoadSizeHint(4)
        .setPageSize(4)
        .build()

    fun getMovieFavorites() = LivePagedListBuilder(movieDao.getMovieFavorites(), config).build()
    fun getTvShowFavorites() = LivePagedListBuilder(movieDao.getTvShowFavorites(), config).build()

    fun isFavorite(movieId: String) = movieDao.isFavoriteMovie(movieId)
    fun isTvShowFavorite(id: String) = movieDao.isFavoriteTvShow(id)

}