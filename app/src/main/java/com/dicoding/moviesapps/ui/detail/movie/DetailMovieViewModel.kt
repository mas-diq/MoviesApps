package com.dicoding.moviesapps.ui.detail.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.moviesapps.data.MovieRepository
import com.dicoding.moviesapps.data.model.DescEntity
import com.dicoding.moviesapps.data.model.MovieEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailMovieViewModel(private val repository: MovieRepository) : ViewModel() {

    private lateinit var movieId: String
    val movie = MutableLiveData<MovieEntity>()
    val descEntity = MutableLiveData<List<DescEntity>>()

    fun setSelectedMovies(courseId: String) {
        this.movieId = courseId
    }

    fun getMovies(): MutableLiveData<MovieEntity> {
        val movieEntities = repository.getMovies()
        for (movEntity in movieEntities) {
            if (movEntity.moviesId == movieId) {
                movie.postValue(movEntity)
            }
        }
        return movie
    }

    fun getDesc(): MutableLiveData<List<DescEntity>> {
        descEntity.postValue(repository.getDescMovie(movieId))
        return descEntity
    }

    fun addFavorite(movieEntity: MovieEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addFavorite(movieEntity)
            isFavorite.postValue(true)

        }
    }

    fun removeFavorite(movieEntity: MovieEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeFavorite(movieEntity)
            isFavorite.postValue(false)
        }
    }

    val isFavorite = MutableLiveData<Boolean>()
    fun checkFavoriteMovie(moviesId: String) =
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val movie = getMovies()
                val getMovie = repository.isFavorite(moviesId)
                if (getMovie != null) {
                    isFavorite.postValue(true)
                } else {
                    isFavorite.postValue(false)
                }
            }
        }
}
