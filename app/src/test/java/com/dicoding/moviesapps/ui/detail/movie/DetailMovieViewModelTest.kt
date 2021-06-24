package com.dicoding.moviesapps.ui.detail.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.moviesapps.data.MovieDao
import com.dicoding.moviesapps.data.MovieRepository
import com.dicoding.moviesapps.utils.DataMovies
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class DetailMovieViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()
    private val dao = mock(MovieDao::class.java)
    private lateinit var repository: MovieRepository
    private lateinit var vm: DetailMovieViewModel
    private val dummyMovie = DataMovies.generateDummymovies()[0]
    private val movieId = dummyMovie.moviesId

    @Before
    fun setUp() {

        repository = MovieRepository(dao)
        vm = DetailMovieViewModel(repository)
        vm.setSelectedMovies(movieId)
    }

    @Test
    fun getMovies() {
        vm.setSelectedMovies(dummyMovie.moviesId)
        val movie = vm.getMovies().value
        assertNotNull(movie)
        assertEquals(dummyMovie.moviesId, movie?.moviesId)
        assertEquals(dummyMovie.duration, movie?.duration)
        assertEquals(dummyMovie.description, movie?.description)
        assertEquals(dummyMovie.imagePath, movie?.imagePath)
        assertEquals(dummyMovie.title, movie?.title)
    }

    @Test
    fun getDesc() {
        val desc = vm.getDesc().value
        assertNotNull(desc)
        assertEquals(11L, desc?.size?.toLong())
    }

    @Test
    fun favorite() {
        val returnNumber = 1L
        Mockito.`when`(repository.addFavorite(dummyMovie))
            .thenReturn(returnNumber)
        val addedFavorite = repository.addFavorite(dummyMovie)
        assertNotNull(addedFavorite)
        Mockito.`when`(repository.removeFavorite(dummyMovie))
            .thenReturn(returnNumber.toInt())
        val removeFavorite = repository.removeFavorite(dummyMovie)
        assertNotNull(removeFavorite)
    }
}