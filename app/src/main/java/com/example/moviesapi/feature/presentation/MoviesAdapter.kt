package com.example.moviesapi.feature.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.moviesapi.R
import com.example.moviesapi.feature.domain.model.Movie

class MoviesAdapter(private val dataSet: List<Movie>) : RecyclerView.Adapter<MoviesAdapter.MoviesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.MoviesHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MoviesHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.MoviesHolder, position: Int) {
        holder.text.text = dataSet[position].title
        Glide.with(holder.itemView.context)
            .load(dataSet[position].imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.image)
        holder.itemView.setOnClickListener {
            //todo open web view
        }
        holder.like.setOnClickListener {
            holder.like.setImageDrawable(ResourcesCompat.getDrawable(holder.itemView.context.resources, R.drawable.ic_liked, holder.itemView.context.theme))
            //todo add to db
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    inner class MoviesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.movieImage)
        val text: TextView = itemView.findViewById(R.id.movieTitle)
        val like: ImageView = itemView.findViewById(R.id.likeButton)
    }
}