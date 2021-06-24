package com.dicoding.moviesapps.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.moviesapps.data.MovieDao
import com.dicoding.moviesapps.data.MovieRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MovieViewModelTest {

    private lateinit var vm: MovieViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()
    private val dao = Mockito.mock(MovieDao::class.java)

    private lateinit var repository: MovieRepository

    @Before
    fun setUp() {
        repository = MovieRepository(dao)

        vm = MovieViewModel(repository)
    }


    @Test
    fun getMovies() {

        vm.setMovie()
        val movieEntities = vm.getMovie().value
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

    }
}