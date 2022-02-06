package com.example.assignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assignment.R
import com.example.assignment.model.MovieDetails

class DetailsActivity : AppCompatActivity() {
    private lateinit var movieInfo: MovieDetails

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        getMovieInfo()
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(baseContext, movieInfo.title, Toast.LENGTH_LONG).show()
    }

    private fun getMovieInfo(){
        intent?.getParcelableExtra<MovieDetails>("selectedData").also {
            if (it != null) {
                movieInfo = it
            }
        }
    }
}