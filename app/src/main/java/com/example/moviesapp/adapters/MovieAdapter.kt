package com.example.moviesapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.moviesapp.R
import com.example.moviesapp.commons.Constants
import com.example.moviesapp.databinding.MovieItemBinding
import com.example.moviesapp.interfaces.MovieItemClickListener
import com.example.moviesapp.models.Movie
import com.squareup.picasso.Picasso

class MovieAdapter : Adapter<MovieAdapter.ViewHolder>() {

    var dataSource : ArrayList<Movie> = ArrayList()
    lateinit var listener : MovieItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.movie_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSource[position]
        Picasso.get().load(Constants.IMAGE_MAIN_PATH+item.poster_path)
            .into(holder.binding.movieImg)
        holder.binding.txtMovieTitle.text = item.title
        holder.binding.txtMovieDescription.text = item.overview
        holder.binding.itemContainer.setOnClickListener {
            listener.onItemClicked(item)
        }
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = MovieItemBinding.bind(itemView)
    }

}