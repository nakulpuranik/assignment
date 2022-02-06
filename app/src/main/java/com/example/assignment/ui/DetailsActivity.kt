package com.example.assignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment.R
import com.example.assignment.adapter.ActorAdapter
import com.example.assignment.model.MovieDetails
import com.example.assignment.databinding.ActivityDetailsBinding


class DetailsActivity : AppCompatActivity() {
    private lateinit var movieInfo: MovieDetails
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var actorAdapter: ActorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_details)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        getMovieInfo()
        binding.movie = movieInfo
        setActorList()
        setOnClickListeners()
    }

    fun setOnClickListeners(){
        binding?.apply {
            this.seeAll.setOnClickListener { comingSoonToast() }
            this.seeAll1.setOnClickListener { comingSoonToast() }
            this.streamingContainer.setOnClickListener { comingSoonToast() }
            this.watchListContainer.setOnClickListener { comingSoonToast() }
            this.moreOption.setOnClickListener { comingSoonToast() }
        }
    }

    /**
     * Get intent data
     */
    private fun getMovieInfo(){
        intent?.getParcelableExtra<MovieDetails>("selectedData").also {
            if (it != null) {
                movieInfo = it
            }
        }
    }

    /**
     * convert actors data to list
     */
    fun actorList(): Array<String> = movieInfo.actors.split(",").toTypedArray()

    /**
     * initiate the actors listt
     */
    private fun setActorList(){
        binding.actorsList.layoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.HORIZONTAL, false)
        actorAdapter = ActorAdapter( actorList() )
        binding.actorsList.adapter = actorAdapter
        binding.actorsList.setHasFixedSize(true)
    }

    private fun comingSoonToast(){
       Toast.makeText(baseContext, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show()
    }

}