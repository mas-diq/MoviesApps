package com.dicoding.moviesapps.ui.movie

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
import com.dicoding.moviesapps.databinding.FragmentMoviesBinding

class MovieFragment : Fragment() {

    private lateinit var fragmentMovieBinding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val dao = MovieDatabase.getInstance(requireContext()).movieDao()
            val repository = MovieRepository(dao)

            val factory = ViewModelFactory.getInstance(repository)
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            viewModel.setMovie()


            viewModel.getMovie().observe(viewLifecycleOwner) { movies ->
                val academyAdapter = MovieAdapter()
                academyAdapter.setCourses(movies)
                with(fragmentMovieBinding.rvMovies) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = academyAdapter
                }
            }


        }
    }
}