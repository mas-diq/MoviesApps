package com.dicoding.moviesapps.ui.favorite.tvShow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.moviesapps.data.MovieRepository
import com.dicoding.moviesapps.data.ViewModelFactory
import com.dicoding.moviesapps.data.MovieDatabase
import com.dicoding.moviesapps.databinding.FragmentTvShowFavoriteBinding
import com.dicoding.moviesapps.ui.favorite.FavoriteViewModel


class TvShowFavoriteFragment : Fragment() {


    private lateinit var fragmentTvshowBinding: FragmentTvShowFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvshowBinding = FragmentTvShowFavoriteBinding.inflate(inflater, container, false)
        return fragmentTvshowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {


            val dao = MovieDatabase.getInstance(requireContext()).movieDao()
            val repository = MovieRepository(dao)

            val factory = ViewModelFactory.getInstance(repository)
            val viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]


            val adapter = TvShowFavoriteAdapter()
            with(fragmentTvshowBinding.rvFavoriteTvshow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }


            viewModel.getTvShowsFavorite().observe(viewLifecycleOwner) {
                adapter.submitList(it)
            }
        }
    }

}