package com.dicoding.moviesapps.ui.reader

import com.dicoding.moviesapps.data.model.ContentEntity
import com.dicoding.moviesapps.utils.DataMovies
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class CourseReaderViewModelTest {
    private lateinit var viewModel: CourseReaderViewModel

    private val dummyCourse = DataMovies.generateDummymovies()[0]
    private val courseId = dummyCourse.moviesId
    private val dummyModules = DataMovies.generateDummyDesc(courseId)
    private val moduleId = dummyModules[0].descId

    @Before
    fun setUp() {
        viewModel = CourseReaderViewModel()
        viewModel.setSelectedCourse(courseId)
        viewModel.setSelectedModule(moduleId)

        val dummyModule = dummyModules[0]
        dummyModule.contentEntity =
            ContentEntity("<h3 class=\\\"fr-text-bordered\\\">" + dummyModule.title + "</h3><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>")
    }

    @Test
    fun getModules() {
        val moduleEntities = viewModel.getModules()
        assertNotNull(moduleEntities)
        assertEquals(11, moduleEntities.size.toLong())
    }

    @Test
    fun getSelectedModule() {
        val moduleEntity = viewModel.getSelectedModule()
        assertNotNull(moduleEntity)
        val contentEntity = moduleEntity.contentEntity
        assertNotNull(contentEntity)
        val content = contentEntity?.content
        assertNotNull(content)
        assertEquals(content, dummyModules[0].contentEntity?.content)
    }
}