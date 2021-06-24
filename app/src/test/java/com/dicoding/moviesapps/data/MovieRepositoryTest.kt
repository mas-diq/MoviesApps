package com.dicoding.moviesapps.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.dicoding.moviesapps.PagedListUtil
import com.dicoding.moviesapps.utils.DataMovies
import com.dicoding.moviesapps.utils.DataTvShow
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieRepositoryTest {

    @Mock
    lateinit var dao: MovieDao


    private lateinit var repository: MovieRepository

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {

        repository = MovieRepository(dao)
    }

    @Test
    fun listMovies() {
        val items = repository.getMovies()
        assertEquals(DataMovies.generateDummymovies(), items)
    }

    @Test
    fun listTvShow() {
        val items = repository.getTvShow()
        assertEquals(DataTvShow.generateDummytvShow(), items)
    }


    @Test
    fun favoritesMovies() {
        val favorite = PagedListUtil.mockPagedList(DataMovies.generateDummymovies())
        val dummyFavoriteLiveData = MutableLiveData(favorite)

        val repository = Mockito.mock(MovieRepository::class.java)
        Mockito.`when`(repository.getMovieFavorites()).thenReturn(dummyFavoriteLiveData)
        val movies = repository.getMovieFavorites()

        Mockito.verify(repository).getMovieFavorites()
        assertNotNull(movies)
        assertEquals(DataMovies.generateDummymovies().size, movies.value?.size)
    }

    @Test
    fun getFavoritesTvShow() {
        val favorite = PagedListUtil.mockPagedList(DataTvShow.generateDummytvShow())
        val dummy = MutableLiveData(favorite)

        val repository = Mockito.mock(MovieRepository::class.java)
        Mockito.`when`(repository.getTvShowFavorites()).thenReturn(dummy)
        val movies = repository.getTvShowFavorites()

        assertNotNull(favorite)
        assertEquals(DataTvShow.generateDummytvShow().size, movies.value?.size)
    }


    @Test
    fun addRemoveFavoriteMovie() {

        val dummy = DataMovies.generateDummymovies()[0]
        Mockito.`when`(dao.addMovie(dummy))
            .thenReturn(1)
        val addedFavorite = dao.addMovie(dummy)
        assertNotNull(addedFavorite)

        Mockito.`when`(dao.removeFavoriteMovie(dummy))
            .thenReturn(1)
        val removeFavorite = dao.removeFavoriteMovie(dummy)
        assertNotNull(removeFavorite)
    }

    @Test
    fun addRemoveFavoriteSeries() {
        val detailDummy = DataTvShow.generateDummytvShow()[0]

        Mockito.`when`(dao.addTvShow(detailDummy))
            .thenReturn(1)

        val addedFavorite = dao.addTvShow(detailDummy)
        assertNotNull(addedFavorite)

        Mockito.`when`(dao.removeTvShow(detailDummy))
            .thenReturn(1)

        val removeFavorite = dao.removeTvShow(detailDummy)
        assertNotNull(removeFavorite)
    }
}

