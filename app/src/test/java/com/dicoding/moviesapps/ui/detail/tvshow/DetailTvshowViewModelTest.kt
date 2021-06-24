package com.dicoding.moviesapps.ui.detail.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.moviesapps.data.MovieDao
import com.dicoding.moviesapps.data.MovieRepository
import com.dicoding.moviesapps.utils.DataTvShow
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class DetailTvshowViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()
    private val dao = Mockito.mock(MovieDao::class.java)
    private lateinit var repository: MovieRepository
    private lateinit var vm: DetailTvshowViewModel
    private val dummyTvShow = DataTvShow.generateDummytvShow()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @Before
    fun setUp() {
        repository = MovieRepository(dao)
        vm = DetailTvshowViewModel(repository)
        vm.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShow() {
        vm.setSelectedTvShow(dummyTvShow.tvShowId)
        val tvShow = vm.getTvShow().value
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.tvShowId, tvShow?.tvShowId)
        assertEquals(dummyTvShow.episode, tvShow?.episode)
        assertEquals(dummyTvShow.description, tvShow?.description)
        assertEquals(dummyTvShow.imagePath, tvShow?.imagePath)
        assertEquals(dummyTvShow.title, tvShow?.title)
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
        Mockito.`when`(repository.addFavoriteTvShow(dummyTvShow))
            .thenReturn(returnNumber)
        val addedFavorite = repository.addFavoriteTvShow(dummyTvShow)
        assertNotNull(addedFavorite)
        Mockito.`when`(repository.removeFavoriteTvSho(dummyTvShow))
            .thenReturn(returnNumber.toInt())
        val removeFavorite = repository.removeFavoriteTvSho(dummyTvShow)
        assertNotNull(removeFavorite)
    }
}