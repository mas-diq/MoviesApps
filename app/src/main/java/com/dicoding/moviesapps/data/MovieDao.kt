package com.dicoding.moviesapps.data

import androidx.paging.DataSource
import androidx.room.*
import com.dicoding.moviesapps.data.model.MovieEntity
import com.dicoding.moviesapps.data.model.TvShowEntity

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovie(favoriteMovie: MovieEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTvShow(favoriteTvShow: TvShowEntity): Long

    @Query("SELECT * FROM movie WHERE moviesId=:idMovie ")
    fun isFavoriteMovie(idMovie: String): MovieEntity?

    @Query("SELECT * FROM tvshows WHERE tvShowId=:id ")
    fun isFavoriteTvShow(id: String): TvShowEntity?


    @Delete
    fun removeFavoriteMovie(favoriteMovie: MovieEntity): Int

    @Delete
    fun removeTvShow(tvShow: TvShowEntity): Int

    @Query("SELECT * FROM movie")
    fun getMovieFavorites(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvshows")
    fun getTvShowFavorites(): DataSource.Factory<Int, TvShowEntity>


}