package com.dicoding.moviesapps.ui.favorite.tvShow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviesapps.R
import com.dicoding.moviesapps.data.model.TvShowEntity
import com.dicoding.moviesapps.databinding.ItemsMoviesBinding
import com.dicoding.moviesapps.ui.detail.tvshow.DetailTvshowActivity

class TvShowFavoriteAdapter :
    PagedListAdapter<TvShowEntity, TvShowFavoriteAdapter.FavoriteViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.tvShowId == newItem.tvShowId
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val itemsMoviesBinding =
            ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }


    class FavoriteViewHolder(private val binding: ItemsMoviesBinding) :
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
//                imgShare.setOnClickListener { callback.onShareClick(tvShow) }
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