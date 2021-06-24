package com.dicoding.moviesapps.ui.detail.movie

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviesapps.R
import com.dicoding.moviesapps.data.MovieRepository
import com.dicoding.moviesapps.data.ViewModelFactory
import com.dicoding.moviesapps.data.model.MovieEntity
import com.dicoding.moviesapps.data.MovieDatabase
import com.dicoding.moviesapps.databinding.ActivityDetailMoviesBinding
import com.dicoding.moviesapps.databinding.ContentDetailMoviesBinding
import com.dicoding.moviesapps.ui.reader.CourseReaderActivity

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_COURSE = "extra_course"
    }

    private lateinit var detailContentBinding: ContentDetailMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = MovieDatabase.getInstance(this).movieDao()
        val repository = MovieRepository(dao)

        val factory = ViewModelFactory.getInstance(repository)
        val viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]


        val activityDetailMoviesBinding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMoviesBinding.detailContent

        setContentView(activityDetailMoviesBinding.root)

        setSupportActionBar(activityDetailMoviesBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = DetailMovieAdapter()

        val extras = intent.extras
        if (extras != null) {
            val moviesId =
                extras.getString(EXTRA_COURSE)
            if (moviesId != null) {

                viewModel.setSelectedMovies(moviesId)
                val module = viewModel.getDesc()
                module.observe(this) { modules ->
                    adapter.setModules(modules)

                }

                viewModel.getMovies().observe(this) {
                    populateCourse(it)

                }
                viewModel.checkFavoriteMovie(moviesId)

            }
        }

        with(detailContentBinding.rvModuleMovie) {
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@DetailMovieActivity)
            setHasFixedSize(true)
            this.adapter = adapter
            val dividerItemDecoration =
                DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }



        viewModel.isFavorite.observe(this) {

            val fabBtn = detailContentBinding.fabFavorites
            if (it) {
                fabBtn.setImageResource(R.drawable.ic_favorite_true)
            } else {
                fabBtn.setImageResource(R.drawable.ic_favorite_false)
            }

        }


        detailContentBinding.fabFavorites.setOnClickListener {
            if (viewModel.isFavorite.value == false) {
                viewModel.getMovies().value?.let { it1 ->
                    viewModel.addFavorite(
                        it1
                    )
                }
            } else {
                viewModel.getMovies().value?.let { it1 ->
                    viewModel.removeFavorite(
                        it1
                    )
                }
            }

        }

    }

    private fun populateCourse(movieEntity: MovieEntity) {
        detailContentBinding.textTitleMovie.text = movieEntity.title
        detailContentBinding.textDescription.text = movieEntity.description
        detailContentBinding.textDurationMovie.text =
            resources.getString(R.string.duration_value, movieEntity.duration)

        Glide.with(this)
            .load(movieEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentBinding.imagePoster)

        detailContentBinding.btnStartMovie.setOnClickListener {
            val intent = Intent(this@DetailMovieActivity, CourseReaderActivity::class.java)
            intent.putExtra(CourseReaderActivity.EXTRA_COURSE_ID, movieEntity.moviesId)
            startActivity(intent)
        }
    }
}