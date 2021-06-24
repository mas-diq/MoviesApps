package com.dicoding.moviesapps.utils

import android.util.Log
import com.dicoding.moviesapps.data.model.DescEntity
import com.dicoding.moviesapps.data.model.MovieEntity

object DataMovies {
    fun generateDummymovies(): List<MovieEntity> {

        Log.d("DataMovies", ": generateDummymovies called")

        val movies = ArrayList<MovieEntity>()
        movies.add(
            MovieEntity(
                "m1",
                "Spider-Man: Into the Spider-Verse",
                "Bitten by a radioactive spider in the subway, Brooklyn teenager Miles Morales suddenly develops mysterious powers that transform him into the one and only Spider-Man. When he meets Peter Parker, he soon realizes that there are many others who share his special, high-flying talents. Miles must now use his newfound skills to battle the evil Kingpin, a hulking madman who can open portals to other universes and pull different versions of Spider-Man into our world.",
                "1h 56min",
                false,
                "https://i.imgur.com/V6tZgPh.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m2",
                "Avenger: Endgame",
                "Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.",
                "3h 2min",
                false,
                "https://i.imgur.com/W1eXF34.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m3",
                "Joker",
                "Forever alone in a crowd, failed comedian Arthur Fleck seeks connection as he walks the streets of Gotham City. Arthur wears two masks -- the one he paints for his day job as a clown, and the guise he projects in a futile attempt to feel like he's part of the world around him. Isolated, bullied and disregarded by society, Fleck begins a slow descent into madness as he transforms into the criminal mastermind known as the Joker.",
                "2h 2min",
                false,
                "https://i.imgur.com/04X2mHW.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m4",
                "The Platform",
                "In the future, prisoners housed in vertical cells watch as inmates in the upper cells are fed while those below starve.",
                "1h 34min",
                false,
                "https://i.imgur.com/OpFw6Is.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m5",
                "Ralph Breaks the Internet: Wreck-It Ralph",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, \"Sugar Rush.\" In way over their heads, Ralph and Vanellope rely on the citizens of the internet -- the netizens -- to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                "1h 56min",
                false,
                "https://i.imgur.com/IKUu7vw.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m6",
                "Ready Player One",
                "In 2045, the planet is on the brink of chaos and collapse, but people find salvation in the OASIS, an expansive virtual reality universe created by James Halliday. When Halliday dies, he promises his immense fortune to the first person to discover a digital Easter egg that's hidden somewhere in the OASIS. When young Wade Watts joins the contest, he finds himself becoming an unlikely hero in a reality-bending treasure hunt through a fantastical world of mystery, discovery and danger.",
                "1h 56min",
                false,
                "https://i.imgur.com/cwqHFch.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m7",
                "Shazam",
                "We all have a superhero inside of us -- it just takes a bit of magic to bring it out. In 14-year-old Billy Batson's case, all he needs to do is shout out one word to transform into the adult superhero Shazam. Still a kid at heart, Shazam revels in the new version of himself by doing what any other teen would do -- have fun while testing out his newfound powers. But he'll need to master them quickly before the evil Dr. Thaddeus Sivana can get his hands on Shazam's magical abilities.",
                "2h 12min",
                false,
                "https://i.imgur.com/bbtu0kp.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m8",
                "Interstellar",
                "In Earth's future, a global crop blight and second Dust Bowl are slowly rendering the planet uninhabitable. Professor Brand (Michael Caine), a brilliant NASA physicist, is working on plans to save mankind by transporting Earth's population to a new home via a wormhole. But first, Brand must send former NASA pilot Cooper (Matthew McConaughey) and a team of researchers through the wormhole and across the galaxy to find out which of three planets could be mankind's new home.",
                "1h 39min",
                false,
                "https://i.imgur.com/0Nw7yxt.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m9",
                "Tenet",
                "A secret agent embarks on a dangerous, time-bending mission to prevent the start of World War III.",
                "2h 30min",
                false,
                "https://i.imgur.com/5zEC2Hl.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m10",
                "Venom",
                "Journalist Eddie Brock is trying to take down Carlton Drake, the notorious and brilliant founder of the Life Foundation. While investigating one of Drake's experiments, Eddie's body merges with the alien Venom -- leaving him with superhuman strength and power. Twisted, dark and fueled by rage, Venom tries to control the new and dangerous abilities that Eddie finds so intoxicating.",
                "2h 20min",
                false,
                "https://i.imgur.com/RjZwUbd.jpg"
            )
        )

        return movies
    }

    fun generateDummyDesc(movieId: String): List<DescEntity> {

        val desc = ArrayList<DescEntity>()

        desc.add(
            DescEntity(
                "{$movieId}m1",
                movieId,
                "Review : Rotten Tomatoes",
                0, false
            )
        )
        desc.add(
            DescEntity(
                "{$movieId}m2",
                movieId,
                "by Rogert Ebert",
                1, false
            )
        )
        desc.add(
            DescEntity(
                "{$movieId}m3",
                movieId,
                "by Pauline Kael",
                2, false
            )
        )
        desc.add(
            DescEntity(
                "{$movieId}m4",
                movieId,
                "by Gene Siskel",
                3, false
            )
        )
        desc.add(
            DescEntity(
                "{$movieId}m5",
                movieId,
                "Review : IMDB Team",
                4, false
            )
        )
        desc.add(
            DescEntity(
                "{$movieId}m6",
                movieId,
                "by Leonard Maltin",
                5, false
            )
        )
        desc.add(
            DescEntity(
                "{$movieId}m7",
                movieId,
                "by Peter Travers",
                6, false
            )
        )
        desc.add(
            DescEntity(
                "{$movieId}m8",
                movieId,
                "by Andrew Sarris",
                7, false
            )
        )
        desc.add(
            DescEntity(
                "{$movieId}m9",
                movieId,
                "by Francois Truffaut",
                8, false
            )
        )
        desc.add(
            DescEntity(
                "{$movieId}m10",
                movieId,
                "by Gene Shalit",
                9, false
            )
        )
        desc.add(
            DescEntity(
                "{$movieId}m11",
                movieId,
                "by Molly Haskell",
                10, false
            )
        )
        return desc
    }
}