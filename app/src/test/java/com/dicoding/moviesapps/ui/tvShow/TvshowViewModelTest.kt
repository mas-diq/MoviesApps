package com.dicoding.moviesapps.ui.tvShow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.moviesapps.data.MovieDao
import com.dicoding.moviesapps.data.MovieRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class TvshowViewModelTest {

    private lateinit var vm: TvshowViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()
    private val dao = Mockito.mock(MovieDao::class.java)

    private lateinit var repository: MovieRepository

    @Before
    fun setUp() {
        repository = MovieRepository(dao)
        vm = TvshowViewModel(repository)
    }

    @Test
    fun getTvShow() {
        val tvShowEntities = vm.getTvShow().value
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)
    }
}