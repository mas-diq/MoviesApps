package com.dicoding.moviesapps.ui.detail.tvshow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.moviesapps.data.MovieRepository
import com.dicoding.moviesapps.data.model.DescEntity
import com.dicoding.moviesapps.data.model.TvShowEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailTvshowViewModel(private val repository: MovieRepository) : ViewModel() {
    private lateinit var tvshowId: String

     val tvShowEntity =  MutableLiveData<TvShowEntity>()
    val descEntity = MutableLiveData<List<DescEntity>>()

    fun setSelectedTvShow(tvshowId: String) {
        this.tvshowId = tvshowId
    }

    fun getTvShow(): MutableLiveData<TvShowEntity> {

        val tvshowEntities = repository.getTvShow()
        for (tvShowEntity in tvshowEntities) {
            if (tvShowEntity.tvShowId == tvshowId) {
                this.tvShowEntity.postValue(tvShowEntity)
            }
        }
        return tvShowEntity
    }


    fun getDesc(): MutableLiveData<List<DescEntity>> {

        descEntity.value = repository.getDescTvShow(tvshowId)
        return descEntity
    }

    fun addFavorite(entity: TvShowEntity) {

        viewModelScope.launch(Dispatchers.IO) {
            repository.addFavoriteTvShow(entity)
            isFavorite.postValue(true)

        }
    }

    fun removeFavorite(entity: TvShowEntity) {

        viewModelScope.launch(Dispatchers.IO) {
            repository.removeFavoriteTvSho(entity)
            isFavorite.postValue(false)
        }
    }


    val isFavorite = MutableLiveData<Boolean>()

    fun checkFavorite(tvshowId: String) =
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val tvShow = getTvShow()
                val getMovie = repository.isTvShowFavorite(tvshowId)
                if (getMovie != null) {
                    isFavorite.postValue(true)
                } else {
                    isFavorite.postValue(false)
                }


            }
        }
}
