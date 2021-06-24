package com.dicoding.moviesapps.ui.tvShow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviesapps.R
import com.dicoding.moviesapps.data.model.TvShowEntity
import com.dicoding.moviesapps.databinding.ItemsTvshowBinding
import com.dicoding.moviesapps.ui.detail.tvshow.DetailTvshowActivity

class TvshowAdapter(private val callback: TvshowFragmentCallback) :
    RecyclerView.Adapter<TvshowAdapter.CourseViewHolder>() {
    private val listCourses = ArrayList<TvShowEntity>()

    fun setCourses(tvShow: List<TvShowEntity>?) {
        if (tvShow == null) return
        this.listCourses.clear()
        this.listCourses.addAll(tvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemsBookmarkBinding =
            ItemsTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(itemsBookmarkBinding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val tvShow = listCourses[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listCourses.size

    inner class CourseViewHolder(private val binding: ItemsTvshowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                tvItemTitle.text = tvShow.title
                tvItemDate.text =
                    itemView.resources.getString(R.string.episode_value, tvShow.episode)
                itemView.setOnClickListener {
                    val intent = Intent(
                        itemView.context,
                        DetailTvshowActivity::class.java
                    )
                    intent.putExtra(
                        DetailTvshowActivity.EXTRA_TVSHOW,
                        tvShow.tvShowId
                    )
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callback.onShareClick(tvShow) }
                Glide.with(itemView.context)
                    .load(tvShow.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }
}