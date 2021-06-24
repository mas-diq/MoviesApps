package com.dicoding.moviesapps.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviesapps.R
import com.dicoding.moviesapps.data.model.MovieEntity
import com.dicoding.moviesapps.databinding.ItemsMoviesBinding
import com.dicoding.moviesapps.ui.detail.movie.DetailMovieActivity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.CourseViewHolder>() {
    private var listCourses = ArrayList<MovieEntity>()

    fun setCourses(movie: List<MovieEntity>?) {
        if (movie == null) return
        this.listCourses.clear()
        this.listCourses.addAll(movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemsMoviesBinding =
            ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = listCourses[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listCourses.size


    class CourseViewHolder(private val binding: ItemsMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemDate.text =
                    itemView.resources.getString(R.string.duration_value, movie.duration)
                itemView.setOnClickListener {
                    val intent = Intent(
                        itemView.context,
                        DetailMovieActivity::class.java
                    )
                    intent.putExtra(
                        DetailMovieActivity.EXTRA_COURSE,
                        movie.moviesId
                    )
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(movie.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }
}