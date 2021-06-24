package com.dicoding.moviesapps.ui.tvShow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.moviesapps.R
import com.dicoding.moviesapps.data.MovieRepository
import com.dicoding.moviesapps.data.ViewModelFactory
import com.dicoding.moviesapps.data.model.TvShowEntity
import com.dicoding.moviesapps.data.MovieDatabase
import com.dicoding.moviesapps.databinding.FragmentTvshowBinding

class TvshowFragment : Fragment(), TvshowFragmentCallback {

    private lateinit var fragmentTvshowBinding: FragmentTvshowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentTvshowBinding = FragmentTvshowBinding.inflate(inflater, container, false)
        return fragmentTvshowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {


            val dao = MovieDatabase.getInstance(requireContext()).movieDao()
            val repository = MovieRepository(dao)

            val factory = ViewModelFactory.getInstance(repository)
            val viewModel = ViewModelProvider(this, factory)[TvshowViewModel::class.java]


            val tvShows = viewModel.getTvShow().observe(viewLifecycleOwner){tvShows->

                val adapter = TvshowAdapter(this)
                adapter.setCourses(tvShows)
                with(fragmentTvshowBinding.rvTvshow) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    this.adapter = adapter
                }
            }

        }
    }

    override fun onShareClick(tvShow: TvShowEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Tonton sekarang!")
                .setText(resources.getString(R.string.share_text, tvShow.title))
                .startChooser()
        }
    }
}