package com.dicoding.moviesapps.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.dicoding.moviesapps.PagedListUtil
import com.dicoding.moviesapps.data.MovieDao
import com.dicoding.moviesapps.data.MovieRepository
import com.dicoding.moviesapps.utils.DataMovies
import com.dicoding.moviesapps.utils.DataTvShow
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    private lateinit var vm: FavoriteViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()
    private val dao = Mockito.mock(MovieDao::class.java)

    private lateinit var repository: MovieRepository

    @Before
    fun setUp() {
        repository = MovieRepository(dao)

        vm = FavoriteViewModel(repository)
    }

    @Test
    fun getMoviesFavorites() {

        val dummy = MutableLiveData(PagedListUtil.mockPagedList(DataMovies.generateDummymovies()))
        val repository = Mockito.mock(MovieRepository::class.java)
        Mockito.`when`(repository.getMovieFavorites()).thenReturn(dummy)

        vm = FavoriteViewModel(repository)
        val movieEntities = vm.getMovieFavorite()
        Assert.assertNotNull(movieEntities)
        Assert.assertEquals(10, movieEntities.value?.size)
    }
    @Test
    fun getTvShowFavorites() {

        val dummy = MutableLiveData(PagedListUtil.mockPagedList(DataTvShow.generateDummytvShow()))
        val repository = Mockito.mock(MovieRepository::class.java)
        Mockito.`when`(repository.getTvShowFavorites()).thenReturn(dummy)

        vm = FavoriteViewModel(repository)
        val tvShowEntity = vm.getTvShowsFavorite()
        Assert.assertNotNull(tvShowEntity)
        Assert.assertEquals(10, tvShowEntity.value?.size)
    }
}