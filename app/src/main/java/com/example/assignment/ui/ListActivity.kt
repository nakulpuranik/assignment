package com.example.assignment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment.adapter.MovieAdapter
import com.example.assignment.databinding.ActivityListBinding
import com.example.assignment.mock.movieList
import com.example.assignment.model.MovieDetails
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var movieDataMock: ArrayList<MovieDetails>
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        movieDataMock = mockMovieList()
        bindRecyclerView()
    }

    private fun mockMovieList(): ArrayList<MovieDetails> {
        val typeToken = object : TypeToken<ArrayList<MovieDetails>>() {}
        return Gson().fromJson(movieList, typeToken.type)
    }


    private fun bindRecyclerView(){
        binding.movieReceyclerView.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieAdapter(
            movieDataMock
        ) { selectedMovie ->
            var intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("selectedData", selectedMovie)
            startActivity(intent)
        }
        binding.movieReceyclerView.adapter = movieAdapter
    }
}