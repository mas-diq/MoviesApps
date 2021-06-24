package com.dicoding.moviesapps.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dicoding.moviesapps.R
import com.dicoding.moviesapps.utils.DataMovies
import com.dicoding.moviesapps.utils.DataTvShow
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val dummyMovie = DataMovies.generateDummymovies()
    private val dummyTvShow = DataTvShow.generateDummytvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    // Movies
    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        // Title
        onView(withId(R.id.text_title_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title_movie)).check(matches(withText(dummyMovie[0].title)))
        // Duration
        onView(withId(R.id.text_duration_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.text_duration_movie)).check(matches(withText("Duration : ${dummyMovie[0].duration}")))
        // Button Start
        onView(withId(R.id.btn_start_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_start_movie)).check(matches(withText("Watch Now!")))
        // Text description
        onView(withId(R.id.text_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.text_desc)).check(matches(withText("Description Movie :")))
        // TextView description
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(withText(dummyMovie[0].description)))
        // Text list module
        onView(withId(R.id.text_list_module_movie)).perform(ViewActions.scrollTo())
        onView(withId(R.id.text_list_module_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.text_list_module_movie)).check(matches(withText("List Movies :")))
    }

    @Test
    fun loadModuleMovie() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.btn_start_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_start_movie)).check(matches(withText("Watch Now!")))
        onView(withId(R.id.btn_start_movie)).perform(click())
        onView(withId(R.id.rv_module)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailModuleMovie() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.btn_start_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_start_movie)).check(matches(withText("Watch Now!")))
        onView(withId(R.id.btn_start_movie)).perform(click())
        onView(withId(R.id.rv_module)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.web_view)).check(matches(isDisplayed()))
    }

    // Tv Show
    @Test
    fun loadTvShow() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        // Title
        onView(withId(R.id.text_title_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title_tvshow)).check(matches(withText(dummyTvShow[0].title)))
        // Episodes
        onView(withId(R.id.text_episode)).check(matches(isDisplayed()))
        onView(withId(R.id.text_episode)).check(matches(withText("Episodes : ${dummyTvShow[0].episode}")))
        // Button Start
        onView(withId(R.id.btn_start_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_start_tvshow)).check(matches(withText("Watch Now!")))
        // Text description
        onView(withId(R.id.text_desc_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.text_desc_tvshow)).check(matches(withText("Description Tv Show :")))
        // TextView description
        onView(withId(R.id.text_description_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description_tvshow)).check(matches(withText(dummyTvShow[0].description)))
        // Text list module
        onView(withId(R.id.text_list_module_tvshow)).perform(ViewActions.scrollTo())
        onView(withId(R.id.text_list_module_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.text_list_module_tvshow)).check(matches(withText("List Tv Show :")))
    }

    @Test
    fun loadModuleTvShow() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.btn_start_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_start_tvshow)).check(matches(withText("Watch Now!")))
        onView(withId(R.id.btn_start_tvshow)).perform(click())
        onView(withId(R.id.rv_module)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailModuleTvShow() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.btn_start_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_start_tvshow)).check(matches(withText("Watch Now!")))
        onView(withId(R.id.btn_start_tvshow)).perform(click())
        onView(withId(R.id.rv_module)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.web_view)).check(matches(isDisplayed()))
    }


    @Test
    fun loadProfile() {

        onView(withText("Profile")).perform(click())
        onView(withId(R.id.img_watermark)).check(matches(isDisplayed()))
        onView(withId(R.id.username)).check(matches(isDisplayed()))
        onView(withId(R.id.nounique)).check(matches(isDisplayed()))
        onView(withId(R.id.fullname)).check(matches(isDisplayed()))
        onView(withId(R.id.company_img)).check(matches(isDisplayed()))
        onView(withId(R.id.company)).check(matches(isDisplayed()))
        onView(withId(R.id.location_img)).check(matches(isDisplayed()))
        onView(withId(R.id.location)).check(matches(isDisplayed()))
        onView(withId(R.id.repository_img)).check(matches(isDisplayed()))
        onView(withId(R.id.repository)).check(matches(isDisplayed()))
        onView(withId(R.id.follower_img)).check(matches(isDisplayed()))
        onView(withId(R.id.follower)).check(matches(isDisplayed()))
        onView(withId(R.id.follower_value)).check(matches(isDisplayed()))
        onView(withId(R.id.following_img)).check(matches(isDisplayed()))
        onView(withId(R.id.following)).check(matches(isDisplayed()))
        onView(withId(R.id.following_value)).check(matches(isDisplayed()))
    }

    @Test
    fun favoriteTvShow() {

        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        //adding new favorite
        onView(withId(R.id.fab_favorites)).perform(click())

        Espresso.pressBack()
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        //removing favorite
        onView(withId(R.id.fab_favorites)).perform(click())

    }

    @Test
    fun favoriteMovie() {

        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        //adding new favorite
        onView(withId(R.id.fab_favorites)).perform(click())

        Espresso.pressBack()
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        //removing favorite
        onView(withId(R.id.fab_favorites)).perform(click())

    }
}