package com.dicoding.moviesapps.ui.favorite.movie

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
import com.dicoding.moviesapps.databinding.FragmentMovieFavoriteBinding
import com.dicoding.moviesapps.ui.favorite.FavoriteViewModel

class MovieFavoriteFragment : Fragment() {

    private lateinit var fragmentMovieBinding: FragmentMovieFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieBinding =
            FragmentMovieFavoriteBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val dao = MovieDatabase.getInstance(requireContext()).movieDao()
            val repository = MovieRepository(dao)

            val factory = ViewModelFactory.getInstance(repository)
            val viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]


            val movieAdapter = MovieFavoriteAdapter()

            with(fragmentMovieBinding.rvMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }



            viewModel.getMovieFavorite().observe(viewLifecycleOwner) {
                movieAdapter.submitList(it)
            }
        }
    }
}