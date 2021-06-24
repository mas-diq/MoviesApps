package com.dicoding.moviesapps.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.moviesapps.ui.detail.movie.DetailMovieViewModel
import com.dicoding.moviesapps.ui.detail.tvshow.DetailTvshowViewModel
import com.dicoding.moviesapps.ui.favorite.FavoriteViewModel
import com.dicoding.moviesapps.ui.movie.MovieViewModel
import com.dicoding.moviesapps.ui.tvShow.TvshowViewModel

class ViewModelFactory(private val repository: MovieRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {


        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(repository: MovieRepository): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(repository)
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                return DetailMovieViewModel(repository) as T
            }
            modelClass.isAssignableFrom(DetailTvshowViewModel::class.java) -> {
                return DetailTvshowViewModel(repository) as T
            }
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(repository) as T
            }
            modelClass.isAssignableFrom(TvshowViewModel::class.java) -> {
                return TvshowViewModel(repository) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                return FavoriteViewModel(repository) as T
            }


            else -> throw Throwable("Tidak diketahui View Model ${modelClass.name}")


        }

    }
}