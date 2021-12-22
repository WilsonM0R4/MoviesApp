package com.example.moviesapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.adapters.MovieAdapter
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.interfaces.MovieItemClickListener
import com.example.moviesapp.models.Movie
import com.example.moviesapp.viewmodels.MovieViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var viewModel : MovieViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MovieAdapter()
        val intent = Intent(this, MovieDetailActivity::class.java)
        viewModel = MovieViewModel()
        viewModel.binding = binding
        binding.rvMovieList.layoutManager = LinearLayoutManager(this)
        binding.rvMovieList.adapter = adapter
        binding.progressBar.visibility = View.VISIBLE

        binding.btnLoadLocalData.setOnClickListener {
            viewModel.getMoviesFromLocal(this)
        }

        viewModel.movies.observe(this,{
            binding.progressBar.visibility = View.GONE
            binding.txtNoRemoteMessage.visibility = View.GONE
            binding.btnLoadLocalData.visibility = View.GONE
            adapter.dataSource = it

            adapter.notifyDataSetChanged()
        })
        adapter.listener = object:MovieItemClickListener {
            override fun onItemClicked(movie: Movie) {
                intent.putExtra("movie", movie)
                startActivity(intent)
            }
        }
        viewModel.getMovies(this)
    }
}