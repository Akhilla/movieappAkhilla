package com.example.movieapp_akhilla.service

import com.example.movieapp_akhilla.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET


interface MovieApiInterface {
    @GET("3/movie/now_playing?api_key=30df4096d613b43e3f468bc53f25bf2c")
    fun getMovieListNowPlaying() :Call<MovieResponse>

}