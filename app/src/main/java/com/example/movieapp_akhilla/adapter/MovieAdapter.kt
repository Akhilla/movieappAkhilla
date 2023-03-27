package com.example.movieapp_akhilla.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp_akhilla.R
import com.example.movieapp_akhilla.model.Movie

class MovieAdapter(
    val movies: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){
    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int )
            :MovieViewHolder {
        var inflate = LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent, false)
        return  MovieViewHolder(inflate)
    }
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int ) {
        var data = movies.get(position)
        holder.title.text= data.title
        Glide.with(holder.itemView).
        load(IMAGE_BASE + data.poster_path).
        into(holder.image)
    }

    override fun getItemCount(): Int = movies.size

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var title: TextView = itemView.findViewById(R.id.titlemovie)
        var image: ImageView = itemView.findViewById(R.id.imgmovie)
    }
}
