package com.example.moviesapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesapp.R
import com.example.moviesapp.commons.Constants
import com.example.moviesapp.databinding.ActivityMovieDetailBinding
import com.example.moviesapp.models.Movie
import com.squareup.picasso.Picasso

class MovieDetailActivity : AppCompatActivity() {

    lateinit var binding : ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie : Movie = intent.getSerializableExtra("movie") as Movie

        Picasso.get().load(Constants.IMAGE_MAIN_PATH+movie.poster_path).into(binding.posterImage)
        binding.txtTitle.text = movie.title
        binding.txtDescription.text = movie.overview
        binding.txtOriginalLanguage.text = String.format(getString(R.string.original_language), movie.original_language)
        binding.txtOriginalTitle.text = String.format(getString(R.string.original_title), movie.original_title)
        binding.txtPopularity.text = String.format(getString(R.string.popularity), movie.popularity)
        binding.txtReleaseDate.text = String.format(getString(R.string.release_date), movie.release_date)
        binding.txtVoteAverage.text = String.format(getString(R.string.vote_average), movie.vote_average)

    }
}