package com.dicoding.moviesapps.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.moviesapps.R
import com.dicoding.moviesapps.ui.favorite.FavoriteFragment
import com.dicoding.moviesapps.ui.movie.MovieFragment
import com.dicoding.moviesapps.ui.profile.ProfileFragment
import com.dicoding.moviesapps.ui.tvShow.TvshowFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object {
        @StringRes
        private val TAB_TITLES =
            intArrayOf(R.string.movie, R.string.tvshow, R.string.favorite, R.string.profile)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MovieFragment()
            1 -> TvshowFragment()
            2 -> FavoriteFragment()
            3 -> ProfileFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence =
        mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 4

}