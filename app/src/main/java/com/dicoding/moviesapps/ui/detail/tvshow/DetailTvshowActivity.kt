package com.dicoding.moviesapps.ui.detail.tvshow

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
import com.dicoding.moviesapps.data.model.TvShowEntity
import com.dicoding.moviesapps.data.MovieDatabase
import com.dicoding.moviesapps.databinding.ActivityDetailTvshowBinding
import com.dicoding.moviesapps.databinding.ContentDetailTvshowBinding
import com.dicoding.moviesapps.ui.reader.CourseReaderActivity

class DetailTvshowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    private lateinit var detailContentBinding: ContentDetailTvshowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = MovieDatabase.getInstance(this).movieDao()
        val repository = MovieRepository(dao)

        val factory = ViewModelFactory.getInstance(repository)
        val viewModel = ViewModelProvider(this, factory)[DetailTvshowViewModel::class.java]


        val activityDetailTvShowBinding = ActivityDetailTvshowBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailTvShowBinding.detailContent

        setContentView(activityDetailTvShowBinding.root)

        setSupportActionBar(activityDetailTvShowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = DetailTvshowAdapter()

        val extras = intent.extras
        if (extras != null) {
            val tvshowId =
                extras.getString(EXTRA_TVSHOW)
            if (tvshowId != null) {

                viewModel.setSelectedTvShow(tvshowId)
                val module = viewModel.getDesc()

                module.observe(this) { module ->
                    adapter.setModules(module)
                    viewModel.checkFavorite(tvshowId)

                }
                viewModel.getTvShow().observe(this) { courses ->
                    populateCourse(courses)

                }

            }
        }

        with(detailContentBinding.rvModule) {
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@DetailTvshowActivity)
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
                viewModel.getTvShow().value?.let { it1 ->
                    viewModel.addFavorite(
                        it1
                    )
                }
            } else {
                viewModel.getTvShow().value?.let { it1 ->
                    viewModel.removeFavorite(
                        it1
                    )
                }
            }

        }
    }

    private fun populateCourse(tvshowEntity: TvShowEntity) {
        detailContentBinding.textTitleTvshow.text = tvshowEntity.title
        detailContentBinding.textDescriptionTvshow.text = tvshowEntity.description
        detailContentBinding.textEpisode.text =
            resources.getString(R.string.episode_value, tvshowEntity.episode)

        Glide.with(this)
            .load(tvshowEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentBinding.imagePoster)

        detailContentBinding.btnStartTvshow.setOnClickListener {
            val intent = Intent(this@DetailTvshowActivity, CourseReaderActivity::class.java)
            intent.putExtra(CourseReaderActivity.EXTRA_COURSE_ID, tvshowEntity.tvShowId)
            startActivity(intent)
        }
    }
}