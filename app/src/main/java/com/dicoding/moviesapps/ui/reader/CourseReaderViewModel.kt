package com.dicoding.moviesapps.ui.reader

import androidx.lifecycle.ViewModel
import com.dicoding.moviesapps.data.model.ContentEntity
import com.dicoding.moviesapps.data.model.DescEntity
import com.dicoding.moviesapps.utils.DataMovies

class CourseReaderViewModel : ViewModel() {
    private lateinit var movieId: String
    private lateinit var descId: String

    fun setSelectedCourse(movieId: String) {
        this.movieId = movieId
    }

    fun setSelectedModule(descId: String) {
        this.descId = descId
    }

    fun getModules(): ArrayList<DescEntity> =
        DataMovies.generateDummyDesc(movieId) as ArrayList<DescEntity>

    fun getSelectedModule(): DescEntity {
        lateinit var desc: DescEntity
        val moduleEntities = getModules()
        for (moduleEntity in moduleEntities) {
            if (moduleEntity.descId == descId) {
                desc = moduleEntity
                desc.contentEntity =
                    ContentEntity("<h3 class=\\\"fr-text-bordered\\\">" + desc.title + "</h3><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>")
                break
            }
        }
        return desc
    }
}