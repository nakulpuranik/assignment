package com.example.assignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment.R
import com.example.assignment.databinding.MovieListItemBinding
import com.example.assignment.model.MovieDetails

class MovieAdapter (
    private val movieList: ArrayList<MovieDetails>,
    private val onItemClick: (MovieDetails) -> Unit
        ): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding =  MovieListItemBinding.bind(itemView)
        fun bindData(movieDetails : MovieDetails) {

            binding.itemTitle.text = movieDetails.title + " (" + movieDetails.year +")"
            binding.itemSubTitle.text = movieDetails.actors

            Glide.with(binding.view.context)
                .load(movieDetails.poster)
                .into(binding.itemImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false))

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movieDetails = movieList[position]
        holder.bindData(movieDetails)
        holder.itemView.setOnClickListener { onItemClick(movieDetails) }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun addData(listOfMovie: List<MovieDetails>) {
        movieList.addAll(listOfMovie)
    }
}