package com.example.assignment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment.R
import com.example.assignment.adapter.MovieAdapter
import com.example.assignment.mock.movieList
import com.example.assignment.model.MovieDetails
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private lateinit var movieDataMock: ArrayList<MovieDetails>
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        movieDataMock = mockMovieList()
        bindRecyclerView()
    }

    private fun mockMovieList(): ArrayList<MovieDetails> {
        val typeToken = object : TypeToken<ArrayList<MovieDetails>>() {}
        return Gson().fromJson(movieList, typeToken.type)
    }

    private fun bindRecyclerView(){
        movieReceyclerView.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieAdapter(
            movieDataMock
        ) { selectedMovie ->
            var intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("selectedData", selectedMovie)
            startActivity(intent)
        }
        movieReceyclerView.adapter = movieAdapter
        movieReceyclerView.setHasFixedSize(true)
    }
}