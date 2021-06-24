package com.dicoding.moviesapps.utils

import android.util.Log
import com.dicoding.moviesapps.data.model.DescEntity
import com.dicoding.moviesapps.data.model.TvShowEntity

object DataTvShow {
    fun generateDummytvShow(): List<TvShowEntity> {
        Log.d("DataTvShow", ": generateDummytvShow called")

        val tvShow = ArrayList<TvShowEntity>()
        tvShow.add(
            TvShowEntity(
                "m1",
                "Stranger Things: Season 2",
                "A love letter to the '80s classics that captivated a generation, Stranger Things is set in 1983 Indiana, where a young boy vanishes into thin air. As friends, family and local police search for answers, they are drawn into an extraordinary mystery involving top-secret government experiments, terrifying supernatural forces and one very strange little girl.",
                "9",
                false,
                "https://i.imgur.com/XlEeVTt.jpg"
            )
        )
        tvShow.add(
            TvShowEntity(
                "m2",
                "Sherlock: Season 4",
                "Sherlock makes a welcome and shocking return, and Cumberbatch and Freeman are game, but it may prove difficult to live up to the lofty expectations created by the series' lengthy hiatus.",
                "13",
                false,
                "https://i.imgur.com/YFw9STy.jpg"
            )
        )
        tvShow.add(
            TvShowEntity(
                "m3",
                "Dark: Season 3",
                "Dark is set in a German town in present day where the disappearance of two young children exposes the double lives and fractured relationships among four families.",
                "13",
                false,
                "https://resizing.flixster.com/1PVfrTyNmLTxt1Aj1jcitKeAlC8=/206x305/v1.dDsyNjY4Mjk7ajsxODgxMzsxMjAwOzE1MDA7MjIyMg"
            )
        )
        tvShow.add(
            TvShowEntity(
                "m4",
                "Queen's Gambit",
                "Based on the novel by Walter Tevis, the Netflix limited series drama The Queen's Gambit is a coming-of-age story that explores the true cost of genius. Abandoned and entrusted to a Kentucky orphanage in the late 1950s, a young Beth Harmon (Anya Taylor-Joy) discovers an astonishing talent for chess while developing an addiction to tranquilizers provided by the state as a sedative for the children. Haunted by her personal demons and fueled by a cocktail of narcotics and obsession, Beth transforms into an impressively skilled and glamorous outcast while determined to conquer the traditional boundaries established in the male-dominated world of competitive chess.",
                "7",
                false,
                "https://i.imgur.com/PcFDAzu.jpg"
            )
        )
        tvShow.add(
            TvShowEntity(
                "m5",
                "Start-Up",
                "Set in South Korea's fictional Silicon Valley called Sandbox, Start-Up tells the story of people in the world of startup companies. Seo Dal-mi (Bae Suzy) is a bright and ambitious young woman who dreams of becoming Korea’s Steve Jobs. Dal-mi doesn’t have a fancy background but she’s passionate about her work. She has bright energy and is a person of great vitality, having experience in a wide range of part-time jobs. Nam Do-san (Nam Joo-hyuk), is the founder of Samsan Tech. A ‘math genius’ as a young boy, Do-san was once the pride of his family but became their shame now, as his business has been going down for the past two years. He finds out that Dal-mi mistakenly remembers him as her first love, so he decides to work his way up in hopes of turning that misunderstanding into reality.",
                "16",
                false,
                "https://i.imgur.com/FUDOSn9.jpg"
            )
        )
        tvShow.add(
            TvShowEntity(
                "m6",
                "How To Sell Drug Online (Fast)",
                "A high school nerd trying to get back with his girlfriend starts an online drug business, and unwittingly ends up as one of Europe's most successful dealers.",
                "12",
                false,
                "https://i.imgur.com/QsnOI7h.jpg"
            )
        )
        tvShow.add(
            TvShowEntity(
                "m7",
                "Itaewon Class",
                "In a dynamic Seoul neighborhood, a former convict and his pals take on an enemy in order to make their business dreams come true.",
                "16",
                false,
                "https://i.imgur.com/uJM03OX.jpg"
            )
        )
        tvShow.add(
            TvShowEntity(
                "m8",
                "Extracurricular",
                "Jisoo may come off as a shy model student, but he is actually the mastermind behind a criminal activity that is beyond imagination of his fellow schoolmates. He made this choice because he needed the money for living expenses and to save for college tuition. His risky double life seems to run without a hitch, until he gets mixed up with rich girl Gyuri and reckless troublemaker Minhee. Their bad choices come with irreversible consequences. There is no more turning back now. A life of crime and violence awaits them.",
                "10",
                false,
                "https://i.imgur.com/3FNCEwk.jpg"
            )
        )
        tvShow.add(
            TvShowEntity(
                "m9",
                "The Falcon and the Winter Soldier",
                "Sam Wilson allies himself with Bucky Barnes to embark on a series of international adventures, the duo drawn together by their ties to Steve Rogers, to thwart the activities of the Flag-Smashers, an anti-patriotism terrorist cell.",
                "6",
                false,
                "https://i.imgur.com/j00u6CU.jpg"
            )
        )
        tvShow.add(
            TvShowEntity(
                "m10",
                "Rick And Morty: Season 4",
                "Mad scientist Rick Sanchez moves in with his daughter's family after disappearing for 20 years and involves them in his wacky adventures in this animated comedy.",
                "12",
                false,
                "https://i.imgur.com/44OzqM7.jpg"
            )
        )

        return tvShow
    }

    fun generateDummyDesc(tvShowId: String): List<DescEntity> {

        val desc = ArrayList<DescEntity>()

        desc.add(
            DescEntity(
                "{$tvShowId}m1",
                tvShowId,
                "Review : Rotten Tomatoes",
                0, false
            )
        )
        desc.add(
            DescEntity(
                "{$tvShowId}m2",
                tvShowId,
                "by Rogert Ebert",
                1, false
            )
        )
        desc.add(
            DescEntity(
                "{$tvShowId}m3",
                tvShowId,
                "by Pauline Kael",
                2, false
            )
        )
        desc.add(
            DescEntity(
                "{$tvShowId}m4",
                tvShowId,
                "by Gene Siskel",
                3, false
            )
        )
        desc.add(
            DescEntity(
                "{$tvShowId}m5",
                tvShowId,
                "Review : IMDB Team",
                4, false
            )
        )
        desc.add(
            DescEntity(
                "{$tvShowId}m6",
                tvShowId,
                "by Leonard Maltin",
                5, false
            )
        )
        desc.add(
            DescEntity(
                "{$tvShowId}m7",
                tvShowId,
                "by Peter Travers",
                6, false
            )
        )
        desc.add(
            DescEntity(
                "{$tvShowId}m8",
                tvShowId,
                "by Andrew Sarris",
                7, false
            )
        )
        desc.add(
            DescEntity(
                "{$tvShowId}m9",
                tvShowId,
                "by Francois Truffaut",
                8, false
            )
        )
        desc.add(
            DescEntity(
                "{$tvShowId}m10",
                tvShowId,
                "by Gene Shalit",
                9, false
            )
        )
        desc.add(
            DescEntity(
                "{$tvShowId}m11",
                tvShowId,
                "by Molly Haskell",
                10, false
            )
        )
        return desc
    }
}