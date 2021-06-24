package com.dicoding.moviesapps.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dicoding.moviesapps.data.model.MovieEntity
import com.dicoding.moviesapps.data.model.TvShowEntity

@Database(
    entities = [MovieEntity::class, TvShowEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private var INSTANCE: MovieDatabase? = null

        private const val TABLE_NAME = "movie_catalogue"

        fun getInstance(context: Context): MovieDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        MovieDatabase::class.java,
                        TABLE_NAME
                    ).build()
                }
            }
            return INSTANCE as MovieDatabase
        }
    }
}