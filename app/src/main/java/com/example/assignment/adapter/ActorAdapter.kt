package com.example.assignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.databinding.ActorListItemBinding

class ActorAdapter (
    private val actorList: Array<String>
    ): RecyclerView.Adapter<ActorAdapter.ActorViewHolder>() {

        inner class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            private val binding =  ActorListItemBinding.bind(itemView)
            fun bindData(actorName : String) {
                binding.actorName.text = actorName
                binding.castName.text = ""
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ActorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.actor_list_item, parent, false))

        override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
            val actorName = actorList[position]
            holder.bindData(actorName)
        }

        override fun getItemCount(): Int {
            return actorList.size
        }
}